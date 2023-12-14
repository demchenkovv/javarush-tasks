package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.exception.PathIsNotFoundException;
import com.github.demchenkovv.multithreading.level07.lecture15.task3110.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
/*
В Java есть специальный класс ZipOutputStream из пакета java.util.zip, который сжимает
(архивирует) переданные в него данные. Чтобы несколько файлов, сжимаемые в один архив, не
слиплись вместе, для каждого из них создается специальная сущность - элемент архива ZipEntry.
Т.е. в ZipOutputStream мы сначала кладем ZipEntry, а затем уже записываем содержимое файла.
При записи файл автоматически сжимается, а при чтении - автоматически восстанавливается.
ZipEntry может быть не только файлом, но и папкой.
 */

/**
 * Менеджер архива будет совершать операции над файлом архива
 * (файлом, который будет храниться на диске и иметь расширение zip).
 */
public class ZipFileManager {
    private Path zipFile; // полный путь к архиву, с которым будем работать

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }


    // Path source - это путь к чему-то, что мы будем архивировать.
    public void createZip(Path source) throws Exception {
        // Если директории не существует, создать её со всеми вложенными папками
        if (Files.notExists(zipFile.getParent())) {
            Files.createDirectories(zipFile.getParent());
        }

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isRegularFile(source)) {
                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());

            } else if (Files.isDirectory(source)) {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList(); // список относительных путей файлов

                // Добавляем каждый файл в архив
                for (Path path : fileNames) {
                    addNewZipEntry(zipOutputStream, source, path);
                }
            } else {
                // Если переданный source не директория и не файл
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path newPath = filePath.resolve(fileName); // объединяем пути filePath + fileName (разделитель зависит от ОС)
        try (InputStream is = Files.newInputStream(newPath)) {
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);

            // Копировать данные из InputStream в переданный zipOutputStream
            copyData(is, zipOutputStream);

            // Закрывать в zipOutputStream элемент архива ZipEntry
            zipOutputStream.closeEntry();
        }
    }

    /**
     * Метод для копирования данных
     */
    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
    }

    /**
     * Метод возвращает список свойств файлов в архиве
     */
    public List<FileProperties> getFilesList() throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }
        // Сюда складываем свойства файлов
        List<FileProperties> filePropertiesResult = new ArrayList<>();

        // Создаем входящий поток zip и временный буфер типа ByteArrayOutputStream
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            ZipEntry zipEntry;
            // Пока есть элементы в потоке, получаем их и считываем информацию
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                // Нельзя узнать размер файла в архиве, не вычитав его. Это очень легко сделать с помощью
                // нашего метода copyData, используя временный буфер типа ByteArrayOutputStream.
                // Если этого не делать, то вернутся значения -1 (неизвестный размер).
                copyData(zipInputStream, baos);

                // Извлекаем информацию из файла и добавляем в коллекцию
                String name = zipEntry.getName();
                long size = zipEntry.getSize();
                long compressionSize = zipEntry.getCompressedSize();
                int compressionMethod = zipEntry.getMethod();
                filePropertiesResult.add(new FileProperties(name, size, compressionSize, compressionMethod));
            }
        }
        return filePropertiesResult;
    }

    /**
     * Метод для распаковки, где outputFolder это путь, куда мы будем распаковывать наш архив.
     */
    public void extractAll(Path outputFolder) throws Exception {
        // Проверка наличия zip-файла
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        // Если директория outputFolder не существует, то она будет
        // создана, как и все папки, внутри которых она лежит.
        if (Files.notExists(outputFolder.getParent())) {
            Files.createDirectories(outputFolder.getParent());
        }

        // Создаем входящий поток zip
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {

            // Проходимся по содержимому zip потока (файла)
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                // Извлекаем имя файла и получаем путь до родителей
                String zipFileName = zipEntry.getName();
                Path fullPath = outputFolder.resolve(zipFileName);

                // Создаем нужные директории (если они еще не созданы) от родительской директории
                // zipEntry до главной директории. Создаем файл, используя полный путь.
                Path parent = fullPath.getParent();
                if (Files.notExists(parent))
                    Files.createDirectories(parent);

                // Создаем поток outputStream для полного пути файла, в нем копируем данные
                // с помощью copyData из одного потока в другой
                try (OutputStream outputStream = Files.newOutputStream(fullPath)) {
                    copyData(zipInputStream, outputStream);
                }
            }
        }
    }

    /**
     * Метод для удаления файлов из архива, где pathList - это
     * список относительных путей на файлы внутри архива.
     */
    public void removeFiles(List<Path> pathList) throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        // Создать временный файл архива в директории по умолчанию
        Path tempFile = Files.createTempFile("task3110", ".tmp");

        // Создаем zip-поток для чтения файлов
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));

             // Создаем выходной поток для записи в tempFile
             ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempFile))) {

            // текущий zip-файл
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                // Получаем путь текущего zip-файла
                Path currentZipEntryPath = Paths.get(zipEntry.getName());

                // Проверяем путь текущего zip-файла со списком на удаление;
                // Если есть - удаляем, иначе - кладем текущий zip-файл в zipOutputStream
                // и производим копирование данных во временный файл.
                if (pathList.contains(currentZipEntryPath)) {
                    ConsoleHelper.writeMessage("Файл " + zipEntry.getName() + " удален.");
                } else {
                    zipOutputStream.putNextEntry(zipEntry);
                    copyData(zipInputStream, zipOutputStream);
                }
            }
        }

        // Переместить временный файл на место оригинального
        Files.move(tempFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Метод удаление одного файла из архива, который вызывает метод
     * removeFiles, создавая список из одного элемента.
     */
    public void removeFile(Path path) throws Exception {
        removeFiles(Collections.singletonList(path));
    }
}
