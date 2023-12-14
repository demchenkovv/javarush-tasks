package com.github.demchenkovv.multithreading.level07.lecture15.task3110.javarush_archiver_18.command;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.javarush_archiver_18.ConsoleHelper;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.javarush_archiver_18.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        Path zipPath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(zipPath);
    }
}