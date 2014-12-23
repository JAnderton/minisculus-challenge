package me.karun.models;

public class DecryptionTuple {
    private final int wheel1Position;
    private final int wheel2Position;
    private final String plainText;


    public DecryptionTuple(int wheel1Position, int wheel2Position, String plainText) {
        this.wheel1Position = wheel1Position;
        this.wheel2Position = wheel2Position;
        this.plainText = plainText;
    }

    public boolean isValidSolution() {
        return plainText.startsWith("We");
    }

    @Override
    public String toString() {
        return "{" + wheel1Position + ", " + wheel2Position + "} => " + plainText;
    }
}
