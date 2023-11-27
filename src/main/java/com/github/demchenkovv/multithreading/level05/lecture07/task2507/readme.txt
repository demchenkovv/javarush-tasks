В задаче используется инкапсулирование нестандартной отмены в потоке путем переопределения метода interrupt.
Подробнее о данном методе описано в главе 7.1.6 книги Б. Гетца "Java Concurrency на практике".

Классы Socket и ServerSocket
https://javarush.com/groups/posts/654-klassih-socket-i-serversocket-ili-allo-server-tih-menja-slihshishjh

В чем разница между закрытием Input/OutputStream и непосредственным закрытием Socket?
https://stackoverflow.com/questions/3428127/what-is-the-difference-between-closing-input-outputstream-and-closing-socket-dir


- https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html#close--
-- Метод public void close() throws IOException закрывает этот сокет.

1. Любой поток, который в данный момент заблокирован в операции ввода-вывода в этом сокете, вызовет исключение SocketException.
2. Как только сокет был закрыт, он недоступен для дальнейшего использования в сети (т.е. не может быть повторно подключен или восстановлен). Необходимо создать новый сокет.
3. Закрытие этого сокета также приведет к закрытию входного и выходного потоков сокета.
4. Если у этого сокета есть связанный канал, то канал также закрывается.

-- Метод getInputStream() возвращает входной поток для этого сокета.
Закрытие возвращаемого InputStream приведет к закрытию связанного сокета.
То же самое касается закрытия OutputStream сокета.