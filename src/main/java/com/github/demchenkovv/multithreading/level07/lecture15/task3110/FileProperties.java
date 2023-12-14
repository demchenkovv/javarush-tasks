package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

/**
 * Класс отвечает за свойства каждого файла в архиве. Свойства - это набор,
 * состоящий из: имя файла, размер файла до и после сжатия, метод сжатия.
 */
public class FileProperties {
    private String name;
    private long size; // в байтах
    private long compressedSize; // в байтах
    private int compressionMethod;

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    @Override
    public String toString() {
        long sizeInKb = size / 1024;
        long compressedSizeInKb = compressedSize / 1024;
        String message = String.format("%s %d Kb (%d Kb) сжатие: %d%%", name, sizeInKb, compressedSizeInKb, getCompressionRatio());
        return size > 0 ? message : name;
    }

    // Степень сжатия
    public long getCompressionRatio() {
        return 100 - ((compressedSize * 100) / size);
    }
}
