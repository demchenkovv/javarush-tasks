package com.github.demchenkovv.multithreading.level07.lecture15.task3110.command;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ConsoleHelper;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ZipFileManager;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полное имя файла или директорию для архивации:");
            Path filePath = Paths.get(ConsoleHelper.readString());

            zipFileManager.createZip(filePath);
            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException pathIsNotFoundException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
