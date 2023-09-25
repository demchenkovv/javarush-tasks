package com.github.demchenkovv.javacore.level04.lecture08.task13;

/*
Singleton
*/

public class Solution {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}


/*
Singleton
Класс является синглтоном (реализует паттерн Singleton), если позволяет создать всего один объект
своего типа.

Реализуй Singleton pattern:
Создай класс Singleton в отдельном файле.
Добавь в него статический метод getInstance().
При любом вызове метода getInstance() он должен возвращать один и тот же объект класса Singleton.
Подумай, каким образом можно запретить создание других объектов этого класса.
Сделай все конструкторы в классе Singleton приватными (private).
В итоге должна быть возможность создать объект (экземпляр класса) используя только метод getInstance.

Requirements:
1. Класс Singleton должен быть создан в отдельном файле.
2. Класс Singleton не должен позволять создавать объекты своего типа извне класса.
3. Класс Singleton должен содержать приватное статическое поле instance типа Singleton.
4. В классе Singleton должен быть реализован публичный статический метод getInstance() возвращающий
значение поля instance.
5. Метод getInstance должен всегда возвращать один и тот же объект.
 */