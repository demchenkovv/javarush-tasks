package com.github.demchenkovv.multithreading.level10.lecture06.task3004;

import java.util.concurrent.RecursiveTask;

/**
 * В Java, многопоточность реализуется с использованием концепции потоков. Потоки позволяют выполнять несколько операций одновременно, что может увеличить производительность приложения и улучшить его отзывчивость.
 * <p>
 * Методы fork и join в интерфейсе RecursiveTask используются для реализации рекурсивной параллельной обработки в библиотеке Fork/Join Framework. Эти методы отвечают за разделение работы между потоками и сбор результатов после выполнения работы.
 * <p>
 * Метод fork() используется для разделения работы между несколькими потоками. Он принимает на вход часть работы, которую нужно выполнить, и возвращает копию этой работы. Этот метод обычно вызывается из метода compute() класса RecursiveTask.
 * <p>
 * После разделения работы, метод fork() запускает новый поток для выполнения полученной части работы. Затем он возвращает управление вызывающему коду, который продолжает выполнение в основном потоке.
 * <p>
 * Когда все подзадачи выполнены, они должны быть объединены в окончательный результат. Для этого используется метод join(), который собирает результаты всех подзадач и возвращает объединенный результат.
 * <p>
 * Таким образом, методы fork() и join() в RecursiveTask позволяют реализовать рекурсивную параллельную обработку данных с использованием нескольких потоков, что может значительно ускорить выполнение сложных алгоритмов и снизить нагрузку на процессор.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private final int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    // Метод compute представляет собой рекурсивную задачу, которая вычисляет двоичное представление числа x.
    // Метод compute разделяет задачу на подзадачи и асинхронно их выполняет, а затем объединяет результаты
    // подзадач в один общий результат и возвращает его.
    @Override
    protected String compute() {
        int a = x % 2; // Делим десятичное число на 2 и записываем остаток от деления.
        int b = x / 2; // Делим десятичное число на 2 и записываем его целую часть.
        String result = String.valueOf(a); // записываем остаток от деления

        // Повторяем операцию деления до тех пор, пока результат деления не будет равен нулю.
        if (b > 0) {

            // создается новый экземпляр BinaryRepresentationTask с параметром b
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);

            // Метод fork() отвечает за асинхронное выполнение подзадачи. Он разделяет текущую задачу
            // на две подзадачи, каждая из которых может быть выполнена независимо.
            // Метод fork() отправляет задачу в пул, но не запускает ее выполнение. Для этой цели
            // необходимо использовать метод join () .
            task.fork();

            // Затем вызывается метод join() для задачи task, который блокирует выполнение текущего потока
            // до тех пор, пока не выполнится задача task. Метод join() возвращает результат выполнения задачи.
            // Результат выполнения задачи task складывается с переменной result и возвращается как результат
            // выполнения метода compute.
            return task.join() + result;
        }
        return result;
    }
}