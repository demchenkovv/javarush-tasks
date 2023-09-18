package com.github.demchenkovv.javasyntaxzero.level15.lecture04.task1;

/*
Зри в корень
*/

import java.nio.file.Path;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //напишите тут ваш код
        Path fullPath = Path.of(str);
        Path rootPath = fullPath.getRoot();
        System.out.println(rootPath);
    }
}