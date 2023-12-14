package com.github.demchenkovv.multithreading.level07.lecture15.task3110.command;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ConsoleHelper;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ZipFileManager;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.exception.WrongZipFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива.");
            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полное имя архива и директорию, куда будем распаковывать:");
            Path filePath = Paths.get(ConsoleHelper.readString());

            zipFileManager.extractAll(filePath);
            ConsoleHelper.writeMessage("Архив распакован.");
        } catch (WrongZipFileException wrongZipFileException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
