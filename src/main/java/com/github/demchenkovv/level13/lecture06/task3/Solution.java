package com.github.demchenkovv.level13.lecture06.task3;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getShapeNameByCountOfCorners(3));
        System.out.println(getShapeNameByCountOfCorners(5));
        System.out.println(getShapeNameByCountOfCorners(1));
    }

    public static String getShapeNameByCountOfCorners(int countOfCorner) {
        String shape = switch (countOfCorner) {
            case 3: yield "Треугольник";
            case 4: yield "Четырехугольник";
            case 5: yield "Пятиугольник";
            case 6: yield "Шестиугольник";
            case 7: yield "Семиугольник";
            case 8: yield "Восьмиугольник";
            default: yield "Другая фигура";
        };
        return shape;
    }
}

////    Альтернативная реализация
//    public static String getShapeNameByCountOfCorners(int countOfCorner) {
//        String shape;
//        switch (countOfCorner) {
//            case 3 : shape = "Треугольник"; break;
//            case 4 : shape = "Четырехугольник"; break;
//            case 5 : shape = "Пятиугольник"; break;
//            case 6 : shape = "Шестиугольник"; break;
//            case 7 : shape = "Семиугольник"; break;
//            case 8 : shape = "Восьмиугольник"; break;
//            default: shape = "Другая фигура"; break;
//        }
//        return shape;
//    }
//}


/*
В классе Solution есть метод getShapeNameByCountOfCorners(int), который возвращает название многоугольника
в зависимости от количества углов.
Твоя задача — переписать метод, используя только оператор switch.
Требования:
•	Результат работы метода getShapeNameByCountOfCorners(int) не должен измениться.
•	В методе getShapeNameByCountOfCorners(int) должен использоваться только оператор switch.
 */