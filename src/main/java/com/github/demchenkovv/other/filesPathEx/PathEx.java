package com.github.demchenkovv.other.filesPathEx;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path, по большому счету, — это переработанный аналог класса File. Работать с ним значительно проще, чем с File.
 * <p> Во-первых, из него убрали многие утилитные (статические) методы, и перенесли их в класс Files.
 * <p> Во-вторых, в Path были упорядочены возвращаемые значения методов. В классе File методы возвращали то String,
 * то boolean, то File — разобраться было непросто.
 */
public class PathEx {
    public static void main(String[] args) {

        Path testFilePath = Paths.get("C:\\Users\\Username\\Desktop\\testFile.txt");

        // возвращает имя файла из пути;
        Path fileName = testFilePath.getFileName();
        System.out.println(fileName);

        // возвращает «родительскую» директорию по отношению к текущему пути (то есть ту директорию, которая находится выше по дереву каталогов);
        Path parent = testFilePath.getParent();
        System.out.println(parent);

        // возвращает «корневую» директорию; то есть ту, которая находится на вершине дерева каталогов;
        Path root = testFilePath.getRoot();
        System.out.println(root);

        // проверяют, заканчивается/начинается ли путь с переданного пути. Именно на путь, а не на набор символов.
        boolean endWithTxt = testFilePath.endsWith("Desktop\\testFile.txt");
        System.out.println(endWithTxt);

        boolean startsWithLalala = testFilePath.startsWith("lalalala");
        System.out.println(startsWithLalala);

        // возвращает true, если текущий путь является абсолютным
        System.out.println(testFilePath.isAbsolute());


        // Path normalize() - «нормализует» текущий путь, удаляя из него ненужные элементы.
        // Если в твоей программе появился путь, использующий “.” или “..”,
        // метод normalize() позволит удалить их и получить путь, в котором они не будут содержаться
        Path path5 = Paths.get("C:\\Users\\Java\\.\\examples");
        System.out.println(path5.normalize()); // C:\Users\Java\examples

        Path path6 = Paths.get("C:\\Users\\Java\\..\\examples");
        System.out.println(path6.normalize()); // C:\Users\examples

        // Path relativize() — вычисляет относительный путь между текущим и переданным путем.
        Path testFilePath1 = Paths.get("C:\\Users\\Users\\Users\\Users");
        Path testFilePath2 = Paths.get("C:\\Users\\Users\\Users\\Users\\Username\\Desktop\\testFile.txt");

        System.out.println(testFilePath1.relativize(testFilePath2));
    }
}