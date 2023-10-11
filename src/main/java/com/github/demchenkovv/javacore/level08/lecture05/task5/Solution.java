package com.github.demchenkovv.javacore.level08.lecture05.task5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            FileInputStream fileInputStream;
            while (true) {
                fileInputStream = new FileInputStream(reader.readLine());
                if (fileInputStream.available() < 1000) {
                    fileInputStream.close();
                    throw new DownloadException();
                }
            }
        } catch (Exception ex) {
            throw new DownloadException();
        }
    }

    public static class DownloadException extends Exception {

    }
}
