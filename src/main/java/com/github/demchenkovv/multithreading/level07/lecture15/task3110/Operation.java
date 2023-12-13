package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

/**
 * Все команды, которые поддерживает наш архиватор
 */
public enum Operation {
    CREATE("упаковать файлы в архив"),
    ADD("добавить файл в архив"),
    REMOVE("удалить файл из архив"),
    EXTRACT("распаковать архив"),
    CONTENT("просмотреть содержимое архива"),
    EXIT("выход");

    private String title;

    Operation(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
