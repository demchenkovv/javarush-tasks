package com.github.demchenkovv.multithreading.level10.lecture08.task3006;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        // x = 4       == 00000011
        // y = 5       == 00000100
        // x ^ y       == 00000111
        x = x ^ y; // 111 == 8 (x)

        // x        == 00000111
        // y        == 00000100
        // x ^ y    == 00000011
        y = x ^ y; // 011 == 4 (y)

        // x        == 00000111
        // y        == 00000011
        // x ^ y    == 00000100
        x = x ^ y; // 100 == 5 (x)
    }
}
