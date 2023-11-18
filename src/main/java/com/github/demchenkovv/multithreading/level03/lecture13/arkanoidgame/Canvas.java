package com.github.demchenkovv.multithreading.level03.lecture13.arkanoidgame;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height + 2][width + 2];
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    public void setPoint(double x, double y, char c) {
        int roundY = (int) Math.round(y);
        int roundX = (int) Math.round(x);
        if ((roundX < 0 || roundY < 0) || (roundY >= matrix.length) || roundX >= matrix[0].length) {
            return;
        }
        matrix[roundY][roundX] = c;
    }

    public void clear() {
        matrix = new char[height + 2][width + 2];
    }

    public void print() {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
