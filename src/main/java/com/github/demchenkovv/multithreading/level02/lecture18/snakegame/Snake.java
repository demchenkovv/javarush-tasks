package com.github.demchenkovv.multithreading.level02.lecture18.snakegame;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private ArrayList<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        SnakeSection section = new SnakeSection(x, y);
        this.sections = new ArrayList<>();
        this.sections.add(section);
        this.isAlive = true;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }


    public void move() {
        if (!isAlive) {
            return;
        }

        switch (direction) {
            case UP:
                move(0, -1);
                break;
            case RIGHT:
                move(1, 0);
                break;
            case DOWN:
                move(0, 1);
                break;
            case LEFT:
                move(-1, 0);
                break;
        }
    }

    public void move(int dx, int dy) {
        // Получить текущее положение головы
        int currentHeadY = getY();
        int currentHeadX = getX();

        // Создаем голову с новыми координатами
        SnakeSection head = new SnakeSection(currentHeadX + dx, currentHeadY + dy);

        // Проверяем, что голова не выходит за рамки поля и не съела саму себя
        // Доп. проверка isAlive не является обязательной, поскольку в цикле методе run()
        // условием выхода из цикла (завершения игры) является isAlive == false.
        checkBorders(head);
//        if (!isAlive) return; // не является обязательным
        checkBody(head);
//        if (!isAlive) return; // не является обязательным

        // Если координаты мыши совпадают с координатами головы, то добавляем новую голову в начало списка
        if (Room.game.getMouse().getY() == head.getY() && Room.game.getMouse().getX() == head.getX()) {
            sections.add(0, head);
            Room.game.eatMouse();
            // Иначе добавляем голову в начало списка и отрезаем хвост (имитация движения змеи)
        } else {
            sections.add(0, head); //
            sections.remove(sections.size() - 1);
        }
    }

    /** Проверка, что голова змеи не выходит на рамки поля */
    public void checkBorders(SnakeSection head) {
        boolean isCrashedY = head.getY() >= Room.game.getHeight() || head.getY() < 0;
        boolean isCrashedX = head.getX() >= Room.game.getWidth() || head.getX() < 0;
        if (isCrashedY || isCrashedX) {
            isAlive = false;
        }
    }

    /** Проверка, что змея не съела саму себя */
    public void checkBody(SnakeSection head) {
        // Проверка - является ли голова с новыми координатами частью текущего тела
        if (sections.contains(head)) {
            isAlive = false;
        }
    }
}