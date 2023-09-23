package com.github.demchenkovv.javacore.level03.lecture11.task9;

import java.awt.*;

/*
Один метод в классе
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();

        Integer getAge();
    }

    public abstract class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
}




/*
Один метод в классе
Реализуй интерфейс Animal в классе Fox.
Поменяй код так, чтобы в классе Fox был только один метод - getName.
Учти, что методы удалять нельзя.


Requirements:
1. Интерфейс Animal должен быть реализован в классе Fox.
2. В классе Fox должен быть реализован только один метод — getName.
3. Интерфейс Animal изменять нельзя.
4. Дополнительные классы или интерфейсы создавать нельзя.
 */