package com.github.demchenkovv.level11.lecture03.task1;


/*
Двигатель — сердце автомобиля
*/

/**
 * Внутренние классы бывают статические и нестатические.
 * Статические классы еще называют вложенными (static nested class),
 * нестатические просто называют внутренними классами (inner class).
 */
public class Car {
    //напишите тут ваш код
    Engine engine = new Engine();

    class Engine {
        private boolean isRunning;

        public void start() {
            isRunning = true;
        }

        public void stop() {
            isRunning = false;
        }
    }
}

/*
Двигатель — сложный механизм, для описания которого недостаточно обычной переменной.
В классе Car создай внутренний класс (inner class) Engine.
В классе Engine создай boolean поле isRunning, которое принимает значение true,
если двигатель запущен, и false в противном случае.
Также в этот класс добавь методы start и stop, которые будут запускать/останавливать
двигатель (устанавливать соответствующее значение полю isRunning).
Чтобы использовать двигатель, создай поле engine типа Engine в классе Car.

Требования:
•	В классе Car нужно создать внутренний класс (inner class) Engine.
•	В классе Engine должно существовать приватное поле isRunning типа boolean.
•	В классе Engine должен существовать публичный метод void start, который устанавливает значение true полю isRunning.
•	В классе Engine должен существовать публичный метод void stop, который устанавливает значение false полю isRunning.
•	В классе Car должно существовать поле engine типа Engine.
 */