package com.github.demchenkovv.multithreading.level03.lecture02.task2;

/* 
Запрети переопределение
*/

public class Solution {

    public static class Listener {
        public final void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }

    public static void main(String[] args) {

    }
}