package com.github.demchenkovv.multithreading.level02.lecture18.snakegame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Room {
    public static Room game;
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
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

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     * Метод main
     */
    public static void main(String[] args) {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }

    /**
     * Создает новую мышь
     */
    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        this.mouse = new Mouse(x, y);
    }

    /**
     * Метод вызывается, когда мышь съели
     */
    public void eatMouse() {
        createMouse();
    }

    /**
     * Основной цикл программы. Тут происходят все важные действия
     */
    // TODO: Сделать версию Swing (см. readme.txt в текущей папке)
    public void run() {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        System.out.println("Game Over!");
    }

    /**
     * Программа делает паузу, длинна которой зависит от длинны змеи.
     */
    public void sleep() {
        int countSections = snake.getSections().size();
        int sleepTime = countSections < 16 ? 500 - ((countSections - 1) * 20) : 200;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Выводим на экран текущее состояние игры
     */
    public void print() {
        int[][] gameBoard = new int[height][width];

        // Отмечаем тело змеи - 1
        List<SnakeSection> sections = snake.getSections();
        for (SnakeSection section : sections) {
            gameBoard[section.getY()][section.getX()] = 1;
        }

        // Отмечаем голову змеи - 2
        gameBoard[snake.getY()][snake.getX()] = snake.isAlive() ? 2 : 4;

        // Отмечаем мышь - 3
        gameBoard[mouse.getY()][mouse.getX()] = 3;


        // Выводим на экран символы, индекс которых соответствует значению в двумерном массиве.
        // Символ под индексом 1 (тело) соответствует значению 1 (телу) в массиве gameBoard...
        String[] symbols = {" . ", " x ", " X ", "^_^", "RIP"};
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(symbols[gameBoard[y][x]]);
            }
            System.out.println();
        }
        System.out.print("\n\n\n");
    }
}
