package com.github.demchenkovv.javacore.level09.lecture11.task13;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* 
Исправить ошибку. Классы и интерфейсы
*/

/** <a href="https://javarush.com/groups/posts/2019-rasshirenie-i-suzhenie-ssihlochnihkh-tipov">Расширение и сужение ссылочных типов</a> */

public class Solution {
    {
        System.out.println("This is the Solution class");
    }

    public static void main(String... args) throws IOException {
        try (
                FileOutputStream outputStream = new FileOutputStream(args[0]);
                InputStream is = Solution.class.getClassLoader().getResourceAsStream(args[1]);
        ) {
            ;
            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }

            if (result instanceof C) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }
            // Переменной-наследнику нельзя присвоить объект предка. Наоборот делать можно.
            // Иными словами:
            // С А до С сузить можно, если в переменной А хранится ссылка на объект С. Если же
            // в ней хранится ссылка на объект типа А, то при сужении может возникнуть ситуация,
            // когда у объекта А попытаются вызвать добавленный при extends метод класса С.
            // Это приведёт к крашу. Поэтому при cast-е и производится проверка совместимости.

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("This is the A class");
        }
    }

    class B implements Example {
        {
            System.out.println("This is the B class");
        }
    }

    class C extends A {
        {
            System.out.println("This is the C class");
        }
    }
}
