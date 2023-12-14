package com.github.demchenkovv.multithreading.level07.lecture15.task3110.command;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ConsoleHelper;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.FileProperties;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ZipFileManager;

import java.util.List;

/**
 * Класс отвечает за получение содержимого архива. Содержимое архива - это упакованные файлы и папки,
 * но нам было бы интересно узнать не только имена объектов архива, но и их размер до и после сжатия,
 * степень сжатия и метод сжатия.
 */
public class ZipContentCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        List<FileProperties> filePropertiesList = zipFileManager.getFilesList();
        for (FileProperties file : filePropertiesList) {
            System.out.println(file);
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
