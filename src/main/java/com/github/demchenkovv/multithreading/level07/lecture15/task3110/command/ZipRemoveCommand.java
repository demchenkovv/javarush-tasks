package com.github.demchenkovv.multithreading.level07.lecture15.task3110.command;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ConsoleHelper;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ZipFileManager;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.exception.WrongZipFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Удаление файла из архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полный путь файла в архиве:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.removeFile(sourcePath);

            ConsoleHelper.writeMessage("Удаление из архива завершено.");
        } catch (WrongZipFileException wrongZipFileException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
