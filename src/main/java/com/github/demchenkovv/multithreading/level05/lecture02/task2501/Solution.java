package com.github.demchenkovv.multithreading.level05.lecture02.task2501;

/* 
Новые возможности!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(Alphabet.G.getLetterPosition());
    }

    public enum Alphabet {
        A, B, C, D, E,
        F, G, H, I, J,
        K, L, M, N, O,
        P, Q, R, S, T,
        U, V, W, X, Y, Z;

        int getLetterPosition() {
            return this.ordinal() + 1;
        }
    }
}
