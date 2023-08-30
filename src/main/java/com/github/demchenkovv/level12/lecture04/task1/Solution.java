package com.github.demchenkovv.level12.lecture04.task1;

import java.util.ArrayList;
import java.util.Arrays;

/*
Прощай, Паскаль
*/

public class Solution {
    public static ArrayList<String> programmingLanguages = new ArrayList<>(Arrays.asList("C", "C++", "Python", "JavaScript", "Ruby", "Java", "Pascal"));

    public static void main(String[] args) {
        //напишите тут ваш код
        programmingLanguages.remove("Pascal");
        System.out.println(programmingLanguages);
    }
}

/*
В методе main найди и удали язык программирования Pascal из списка programmingLanguages.

Требования:
•	В методе main должен удаляться Pascal из списка programmingLanguages.
 */
