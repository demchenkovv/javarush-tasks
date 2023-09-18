package com.github.demchenkovv.javasyntaxzero.level14.lecture05.task4;

/*
Логирование стектрейса
*/

public class Solution {

    public static void main(String[] args) {
        try {
            dangerousMethod();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void dangerousMethod() throws Exception {
        throw new Exception("Mu-ha-ha!");
    }
}

/*
В методе main перехвати исключение и выведи его стектрейс.

Требования:
•	Метод main должен вызывать метод dangerousMethod.
•	Метод dangerousMethod должен бросать Exception.
•	Метод main должен выводить на экран стектрейс перехваченного исключения.
 */
