package com.github.demchenkovv.multithreading.level07.lecture15.task3110.javarush_archiver_18.command;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.javarush_archiver_18.*;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.javarush_archiver_18.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла из архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Введите полный путь файла в архиве:");
        Path sourcePath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(sourcePath);

        ConsoleHelper.writeMessage("Удаление из архива завершено.");
    }
}