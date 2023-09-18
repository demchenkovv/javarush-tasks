package com.github.demchenkovv.javacore.level01.lecture11.task13;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair result = getMinimumMaximumPair(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair getMinimumMaximumPair(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair(null, null);
        }

        // напишите тут ваш код


//        Идея в том, чтобы коллекцию/массив int[] превратить в объект Pair(min,max).
//                Задачу можно легко решить через for, разделив на этапы:
//        1. Создаем начальное значение для Pair(x, y). Подумай, чему могут быть изначально равны x и y,
//        если в итоге в x будет минимальное значение, а в y -- максимальное.
//        2. Внутри for проводим вычисления для каждого value из массива: Pair(Math.min(x, value),
//        Math.max(x, value)). Здесь можно так вычислять, поскольку по условию очередное значение массива
//        может быть либо минимальным, либо максимальным, но не одновременно :)
//        На этом шаге могут быть дополнительные вычисления, поскольку для каждого value мы получим некоторый Pair,
//        а для следующего value -- уже может быть другой, но мы знаем и предыдущий и текущий Pair.
//        В этой задаче это вычисление не требуется.
//        3. Когда элементы закончились, просто вернуть текущее состояние Pair.
//        Эти шаги эквивалентны единственному вызову collect:
//        Pair collect = Arrays.stream(inputArray)
//                .collect(
//                        () -> new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE), // <-- начальная инициализация
//                        (Pair pair, int value) -> { // <-- вычисления minmax
//                            pair.x = Math.min(pair.x, value);
//                            pair.y = Math.max(pair.y, value);
//                        },
//                        (pair, pair2) -> { // <-- доп. операция, но здесь не требуется
//                        });
//        return collect;
        // Рекомендую начать с изучения устройства функциональных интерфейсов: Supplier, ObjIntConsumer, BiConsumer.
        // Но если там будет что-то непонятно, то спрашивай.
        // Для тренировки можешь переписать лямбды на анонимные классы.


        // Второй вариант -- reduce.
        //Идея -- превратить массив int[] в коллекцию Pair, которую "свернуть" в единственный Pair,
        // применив "функцию свертки".
        //Например, в Scala для этого используется операторы fold, foldLeft, foldRight (да-да, сворачивать
        // можно "с конца"), и конечно же reduce.
        //У них есть общие части: начальное значение, и функция, которая применяется к результату предыдущего
        // вычисления и очередному значению. В случае с reduce требуется "однородность элементов" коллекции,
        // то есть это всегда коллекция Pair.
        //Вопрос: как массив int[] превратить в коллекцию Pair?
        //Ответ: mapToObj.
        //Но придется размножить элементы, ведь у Pair два поля. -- И чем же их заполнить?
        // -- Да просто Pair(value, value) для каждого value из массива int[].
        //Начальное значение -- такое же, какое и для collect.
        //Функция свертки -- Pair(Math.min(x1, x2), Math.max(y1, y2)), x, y -- итые элементы коллекции,
        // содержащей Pair(x1, y1), Pair(x2, y2), при этом это не начальные соседние элементы, а результат
        // вычисления предыдущего Pair с текущим: Pair(min, max) и Pair(x, y).
//        Pair reduce = Arrays.stream(inputArray)
//                .mapToObj(x -> new Pair(x, x)) // <-- нужна коллекция Pair
//                .reduce(
//                        new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE), // <-- начальное значение
//                        (a, b) -> new Pair(Math.min(a.x, b.x), Math.max(a.y, b.y)));// <-- свертка. Просто вызов new Pair с подсчетом локального минимума и максимума, что нам и нужно
//        return reduce;
//        Рекомендуемые для изучения интерфейсы: BinaryOperator, BiFunction.
//        Внутри кода лямбды можно вставить, например, System.out.println(a.x + "," + a.y)


        // Тривиальное и не самое эффективное решение.
        int x = Arrays.stream(inputArray).min().getAsInt();
        int y = Arrays.stream(inputArray).max().getAsInt();
        return new Pair(x, y);
    }

    public static class Pair {
        public Integer x;
        public Integer y;

        public Pair() {
        }

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                   "x=" + x +
                   ", y=" + y +
                   '}';
        }
    }
}

/*
Минимакс
Реализуй метод, который возвращает объект класса Pair.
В поле x этого объекта должно содержаться минимальное число, а в поле y - максимальное число из массива inputArray.


Requirements:
1. Программа не должна считывать данные с клавиатуры.
2. Класс Pair не изменяй.
3. Метод main не изменяй.
4. Допиши реализацию метода getMinimumMaximumPair: он должен возвращать пару из минимума и максимума.
5. Программа должна вывести правильный результат.
6. Метод getMinimumMaximumPair не должен изменять массив inputArray.
 */