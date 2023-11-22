package com.github.demchenkovv.multithreading.level04.lecture09.messageformatexample;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Date;

/**
 * <a href="https://javarush.com/groups/posts/590-klass-messageformat">Класс MessageFormat [JavaRush, Виталий Рыжаков]</a>
 */
public class MessageFormatDemo {
    public static void main(String[] args) {

        /* Пример 1. */
        // Для начала простой пример использования данного Java класса без создания объекта, а используя статический метод.
        // Здесь вызывается статический метод MessageFormat.format, в который передаются аргументами шаблон строки и, собственно,
        // объекты, которые будут вставлены в места, ограниченные скобками {}. В скобках задается позиция объекта начиная с 0, а
        // также тип форматирования, если таковой имеется.
        int planet = 7;
        String event = "a disturbance in the Force";
        // В скобках {} задается позиция объекта начиная с 0, а также тип форматирования, если таковой имеется.
        String result = MessageFormat.format("At {0, time, medium} on {0, date}, there was {1} on planet {2, number, integer}.",
                new Date(), event, planet);
        System.out.println(result);


        /* Пример 2. */
        // В следующем примере уже создается объект класса MessageFormat.
        // При создании объекта класса MessageFormat в его конструктор передается шаблон строки.
        // Далее, при вызове метода format у объекта, туда в качестве аргумента передается массив объектов, которые будут вставлены в шаблон строки.
        int fileCount = 1273;
        String diskName = "MyDisk";
        Object[] testArgs2 = {fileCount, diskName};

        MessageFormat messageFormat = new MessageFormat("The disk \"{1}\" contains {0} file(s).");
        System.out.println(messageFormat.format(testArgs2));


        /* Пример 3. */
        // Также возможно сделать так, что в зависимости от значения переменной будет выбираться необходимый текст.
        // Своего рода реализация оператора if...else, только с помощью класса ChoiceFormat.
        MessageFormat form = new MessageFormat("Я могу {1} {0}.");
        int count = 2;
        String exercise = "подтянуться";
        Object[] testArgs3 = {count, exercise};

        // Шаблоны для ChoiceFormat
        double[] filelimits = {0, 2, 5}; // пределы значений, при которых будет меняться вывод строк
        String[] filepart = {"{0} раз", "{0} раза", "{0} раз"}; // варианты строк, которые могут быть использованы

        // Условия выбора варианта строки от значения переменной определяются следующим образом:
        // выберется вариант filepart[j], если filelimits[j] <= count < filelimits[j+1]
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);

        // когда вызовут метод format, то для индекса 0 в шаблоне строки используй
        // форматирование, которое было задано в объекте ChoiceFormat fileform.
        form.setFormatByArgumentIndex(0, fileform);
        System.out.println(form.format(testArgs3));


        /* Пример 4. */
        // Здесь основная фишка в массиве Format[] testFormats.
        MessageFormat pattform4 = new MessageFormat("There {0} on {1}.\n{2} {2}");
        int count4 = 0;
        Date date = new Date();
        Object[] testArgs = {count4, "ADisk", date, date};

        double[] filelimits4 = {0, 1, 2};
        String[] filepart4 = {"are no files", "is one file", "are {0} files"};
        ChoiceFormat fileform4 = new ChoiceFormat(filelimits4, filepart4);

        // В данный массив мы заносим объекты (реализующие абстрактный класс Format), которые отвечают за
        // форматирование объектов, определенных в массиве Object[] testArgs. Если объект не нуждается в
        // форматировании, то в массиве Format[] testFormats записывается null.
        // При создании testFormats мы обязаны отталкиваться от порядка шаблона pattform, а именно:
        // MessageFormat pattform = new MessageFormat("There {0} on {1}.\n{2} {2}");
        Format[] testFormats = {fileform4, null, DateFormat.getDateInstance(DateFormat.SHORT), DateFormat.getTimeInstance(DateFormat.SHORT)};

        // Далее с помощью метода pattform.setFormats(testFormats) мы говорим объекту MessageFormat pattform,
        // что для всех индексов в шаблоне строки надо использовать форматирование, определенное в массиве Format[] testFormats.
        pattform4.setFormats(testFormats);
        System.out.println(pattform4.format(testArgs));


        /* Пример 5. */
        MessageFormat mesFormat = new MessageFormat("{0} {1}");

        String who = "Я";    // {0}
        int money = 1000;    // {1}
        Object[] arguments = {who, money}; // {0}, {1} - в фигурных скобках указываются индексы значений

        // Настройка для choiceFormat в зависимости от money (стр 110, индекс 1)
        // limits[0] >= money >= limits[1] соответствует formats[1] - начинающий инвестор...
        // limits[1] >= limits[2] соответствует formats[2] - специалист...
        double[] limits = {
                0,
                100,
                1_000,
                10_000};
        String[] formats = {
                "начинающий инвестор. У меня {1} у.е.",
                "специалист. Смог заработать {1} у.е.",
                "эксперт. Мой капитал {1} у.е.",
                "могу многое себе позволить! Мои активы {1} у.е."};
        ChoiceFormat choiceFormat = new ChoiceFormat(limits, formats);

        // Устанавливаем для какого индекса переданного массива будет применяться форматирование
        mesFormat.setFormatByArgumentIndex(1, choiceFormat);
        System.out.println(mesFormat.format(arguments));
    }
}
