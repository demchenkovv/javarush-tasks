package com.github.demchenkovv.javacore.level05.lecture12.task6;

import java.math.BigDecimal;

/*
ООП. Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        //Блок 2.
        //Вызов для Object
        new Tree().info((Object) new Integer("4"));
        new Tree().info((Object) new Short("4"));
        new Tree().info((Object) new BigDecimal("4"));

        //Блок 3.
        //Вызов для Number
        new Tree().info(new Integer("4"));
        new Tree().info(new Short("4"));
        new Tree().info(new BigDecimal("4"));

        //Блок 4.
        //Вызов для String
        new Tree().info(new String("4"));
        new Tree().info(new Integer("4").toString());
        new Tree().info(new Short("4").toString());
        new Tree().info(new BigDecimal("4").toString());
    }
}


/*
ООП. Перегрузка
Для решения этой задачи:
1. Два раза перегрузи в классе Tree метод info(Object s) так, чтобы получилось три метода: info(Object s), info(Number s), info(String s).
2. Разберись в методе info(Object s). Сделай по аналогии функционал новых методов.
Например, для метода info(Number s) результат может быть таким: "Дерево № 123 , метод Number, параметр Short".

Requirements:
1. В классе Tree должен быть реализован метод info(Object s).
2. В классе Tree должен быть реализован метод info(Number s).
3. В классе Tree должен быть реализован метод info(String s).
4. Метод info(Number s) должен выводить на экран строку, аналогичную строке из метода info(Object s), заменив лишь фразу("метод Object" на "метод Number").
5. Метод info(String s) должен выводить на экран строку, аналогичную строке из метода info(Object s), заменив лишь фразу("метод Object" на "метод String").
 */