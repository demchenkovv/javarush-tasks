package com.github.demchenkovv.multithreading.level07.lecture15.task3110.command;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ConsoleHelper;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        Path archivePath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(archivePath);
    }
}
