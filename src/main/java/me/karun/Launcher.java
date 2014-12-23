package me.karun;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.karun.solutions.Question;
import me.karun.solutions.Question5;
import me.karun.models.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;

public class Launcher {
    private static final String BASE_DOMAIN = "http://minisculuschallenge.com";
    private static final String START_URL = "/start";

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        final JsonParser parser = new JsonParser();

        int iterationCount = 1;
        String message = getUrlData(START_URL);

        while (true) {
            final JsonObject jsonObject = parser.parse(message).getAsJsonObject();
            final String referenceUrl = jsonObject.get("reference-url").getAsString();
            if (referenceUrl.startsWith("/finish/")) {
                break;
            }
            final String completeReferenceUrl = BASE_DOMAIN + referenceUrl;
            final String question = jsonObject.get("question").getAsString();

            System.out.println("URL: " + completeReferenceUrl);
            System.out.println("Question: " + question);

            final String answer = evaluateAnswer(iterationCount, question);
            System.out.println("Answer: " + answer);

            final Response response = putResponse(referenceUrl, answer);
            System.out.println("Response: " + response);
            message = response.getMessage();

            iterationCount++;
            System.out.println();
        }

        final String code = parser.parse(message).getAsJsonObject().get("code").getAsString();
        System.out.println("Code: " + code);
        System.out.println("Solutions:");
        Question5.getAllSolutions(code).forEach(System.out::println);
        System.out.println();

        System.out.println("Ending program");
    }

    private static String evaluateAnswer(final int iterationCount, final String question) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        final Class<Question> questionSolver = (Class<Question>) Class.forName("me.karun.solutions.Question" + iterationCount);
        final Question questionInstance = questionSolver.newInstance();
        return questionInstance.solve(question);
    }

    private static String getUrlData(final String partialUrl) throws IOException {
        final HttpGet request = new HttpGet(URI.create(BASE_DOMAIN + partialUrl));
        request.addHeader("Accept", "application/json");
        final HttpResponse response = HttpClientBuilder.create().build().execute(request);
        final HttpEntity entity = response.getEntity();

        return EntityUtils.toString(entity);
    }


    private static Response putResponse(final String referenceUrl, final String answer) throws IOException {
        final String urlString = BASE_DOMAIN + referenceUrl.substring(referenceUrl.lastIndexOf("/"), referenceUrl.lastIndexOf("."));
        final JsonObject answerJson = new JsonObject();
        answerJson.addProperty("answer", answer);
        final String data = answerJson.toString();

        final HttpPut request = new HttpPut(urlString);
        request.setEntity(new StringEntity(data));
        request.addHeader("Accept", "application/json");
        request.addHeader("Content-type", "application/json");
        final HttpResponse response = HttpClientBuilder.create().build().execute(request);
        final HttpEntity entity = response.getEntity();

        return new Response(response.getStatusLine().getStatusCode(), EntityUtils.toString(entity));
    }
}

