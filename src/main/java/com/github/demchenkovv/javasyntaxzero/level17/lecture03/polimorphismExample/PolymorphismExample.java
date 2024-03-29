package com.github.demchenkovv.javasyntaxzero.level17.lecture03.polimorphismExample;

/**
 * Главное — не в каком классе написан метод, а какой тип (класс) объекта, у которого этот метод вызван.
 * <p>
 * Наследовать и переопределять можно только нестатические методы. Статические методы не наследуются и,
 * следовательно, не переопределяются.
 * <p>
 * Т.к. класс при наследовании получает все методы и данные класса-родителя, объект этого класса разрешается
 * сохранять (присваивать) в переменные класса-родителя (и родителя родителя, и т.д., вплоть до Object)
 * <p>
 * При вызове метода у переменной, реальный метод вызывается у объекта.
 * Этот механизм называется динамической диспетчеризацией методов.
 * <p>
 * Обратите внимание, что на то, какой именно метод printName() вызовется, от класса Cow или Whale, влияет
 * не тип переменной, а тип объекта, на который она ссылается.
 * <p>
 * В переменной типа Cow сохранена ссылка на объект типа Whale, и будет вызван метод printName(),
 * описанный в классе Whale.
 * <p>
 * Это не очень очевидно. Запомните главное правило:
 * <p>
 * Набор методов, которые можно вызвать у переменной, определяется типом переменной.
 * А какой именно метод/какая реализация вызовется, определяется типом/классом объекта,
 * ссылку на который хранит переменная.
 * <p>
 * В данном случае происходит расширяющее приведение типа: его еще называют неявным.
 * Мы расширили ссылку cow, и теперь она ссылается на объект типа Whale.
 * При таком приведении мы не сможем через ссылку cow вызвать методы, которые есть у класса Whale,
 * но которых нет у класса Cow.
 */
public class PolymorphismExample {
    public static void main(String[] args) {
        Cow cow = new Whale(); // можем вызывать только методы Cow
        cow.printAll();
        cow.printName();

        Whale whale = new Whale(); // можем вызывать методы класса Cow и Whale
        whale.printAll();
        whale.printName();

        // Переменная cow имеет тип Cow со ссылкой на объект Whale.
        // Т.о. переменной cow доступны все методы класса Cow, но с реализацией Whale для тех методов,
        // у которых реализация есть. Т.е. если методы (или их часть) переопределены, то будут вызваны Whale, иначе Cow.
    }
}