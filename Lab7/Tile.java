package org.example;

public record Tile(int num1, int num2) {

    @Override
    public String toString() {
        return "(" + num1 + ", " + num2 + ")";
    }
}
