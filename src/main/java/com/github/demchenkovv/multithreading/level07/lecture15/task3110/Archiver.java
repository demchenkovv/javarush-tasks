package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.exception.WrongZipFileException;

import java.io.IOException;

/**
 * Главный класс приложения "Архиватор"
 */
public class Archiver {

    public static void main(String[] args) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//
//            System.out.println("Введите полный путь файла архива:");
//            Path zipFile = Paths.get(reader.readLine()); // файл, в котором мы будем хранить сжатые данные
//            while (!zipFile.isAbsolute()) {
//                System.out.println("Введен некорректный путь. Убедитесь, что путь до файла является абсолютным.");
//                zipFile = Paths.get(reader.readLine());
//            }
//            ZipFileManager zipFileManager = new ZipFileManager(zipFile);
//
//            System.out.println("Введите полное имя файла для архивации:");
//            Path source = Paths.get(reader.readLine()); // файл, который мы будем сжимать
//            while (!source.isAbsolute()) {
//                System.out.println("Введен некорректный путь. Убедитесь, что путь до файла является абсолютным.");
//                source = Paths.get(reader.readLine());
//            }
//
//            zipFileManager.createZip(source);
//        }

        Operation operation = null;
        while (operation != Operation.EXIT) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (IOException wrongEx) { // здесь должен быть catch (WrongZipFileException) !!!
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception ex) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }

    }

    /**
     * Выводит в консоль список доступных команд и просит выбрать одну из них.
     */
    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        for (Operation operation : Operation.values()) {
            ConsoleHelper.writeMessage(operation.ordinal() + " - " + operation.getTitle());
        }
        int numOperation = ConsoleHelper.readInt();
        return Operation.values()[numOperation];
    }
}