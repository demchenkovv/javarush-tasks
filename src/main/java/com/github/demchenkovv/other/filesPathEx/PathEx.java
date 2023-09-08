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

        // Path getFileName() - Возвращает имя файла без директории;
        Path fileName = testFilePath.getFileName();
        System.out.println(fileName);

        // Path getParent() - Возвращает родительскую директорию;
        Path parent = testFilePath.getParent();
        System.out.println(parent);

        // Path getRoot() - Возвращает корневую директорию из пути
        Path root = testFilePath.getRoot();
        System.out.println(root);

        // проверяют, заканчивается/начинается ли путь с переданного пути. Именно на путь, а не на набор символов.
        boolean endWithTxt = testFilePath.endsWith("Desktop\\testFile.txt");
        System.out.println(endWithTxt);

        boolean startsWithLalala = testFilePath.startsWith("lalalala");
        System.out.println(startsWithLalala);

        // boolean isAbsolute() - Проверяет, что текущий путь — абсолютный
        System.out.println(testFilePath.isAbsolute());

        // Path toAbsolutePath() - Преобразует путь в абсолютный
        Path relativePath = Path.of("src/main/java/com/github/demchenkovv/other/filesPathEx");
        System.out.println(relativePath.toAbsolutePath());

        // Path relativize() — вычисляет относительный путь между текущим и переданным путем.
        Path testFilePath1 = Paths.get("C:\\Users\\Users\\Users\\Users");
        Path testFilePath2 = Paths.get("C:\\Users\\Users\\Users\\Users\\Username\\Desktop\\testFile.txt");
        System.out.println(testFilePath1.relativize(testFilePath2));

        // Path resolve(Path other) - Строит новый абсолютный путь из абсолютного и относительного.
        System.out.println(testFilePath1.resolve(testFilePath2));



        // Path normalize() - Убирает шаблоны в имени директории.
        // «Нормализует» текущий путь, удаляя из него ненужные элементы.
        // Если в твоей программе появился путь, использующий “.” или “..”,
        // метод normalize() позволит удалить их и получить путь, в котором они не будут содержаться
        Path path5 = Paths.get("C:\\Users\\Java\\.\\examples");
        System.out.println(path5.normalize()); // C:\Users\Java\examples

        Path path6 = Paths.get("C:\\Users\\Java\\..\\examples");
        System.out.println(path6.normalize()); // C:\Users\examples

        // int getNameCount() - Дробит путь на части с помощью разделителя /.
        // Возвращает количество частей.
        int getNameCount = testFilePath2.getNameCount();
        System.out.println(getNameCount);

        // Дробит путь на части с помощью разделителя /.
        // Возвращает часть по ее номеру.
//        Path getName(int index)

        // Дробит путь на части с помощью разделителя /.
        // Возвращает часть пути, заданную интервалом.
        // Path subpath(int beginIndex, int endIndex)

        // File toFile() - Преобразует объект Path в устаревший объект File

        // URI toUri() - Преобразует объект Path в объект типа URI
    }
}