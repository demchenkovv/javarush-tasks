package com.github.demchenkovv.javacore.level04.lecture08.task13;

/** <a href=https://refactoring.guru/ru/design-patterns/singleton>Паттерны проектирования / Порождающие паттерны / Одиночка (Singleton)</a> */

// Класс одиночки определяет статический метод `getInstance`,
// который позволяет клиентам повторно использовать одно и то же
// подключение к базе данных по всей программе.
public final class Singleton {

    // Поле для хранения объекта-одиночки должно быть объявлено
    // статичным.
    private static Singleton instance = null;

    // Конструктор одиночки всегда должен оставаться приватным,
    // чтобы клиенты не могли самостоятельно создавать
    // экземпляры этого класса через оператор `new`.
    private Singleton() {
        // Здесь может жить код инициализации подключения к
        // серверу баз данных.
        // ...
    }

    // Основной статический метод одиночки служит альтернативой
    // конструктору и является точкой доступа к экземпляру этого
    // класса.
    public static Singleton getInstance() {
        if (Singleton.instance == null) {
            instance = new Singleton();

        }
        return Singleton.instance;
    }

    // Наконец, любой класс одиночки должен иметь какую-то
    // полезную функциональность, которую клиенты будут
    // запускать через полученный объект одиночки.
    //    public method query(sql) {
            // Все запросы к базе данных будут проходить через этот
            // метод. Поэтому имеет смысл поместить сюда какую-то
            // логику кеширования.
            // ...
    //    }

}

/*
class Application is
    method main() is
        Database foo = Database.getInstance()
        foo.query("SELECT ...")
        // ...
        Database bar = Database.getInstance()
        bar.query("SELECT ...")
        // Переменная "bar" содержит тот же объект, что и
        // переменная "foo".
 */