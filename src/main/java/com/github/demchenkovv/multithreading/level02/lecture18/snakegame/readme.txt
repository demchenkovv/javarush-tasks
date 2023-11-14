https://javarush.com/quests/lectures/questmultithreading.level02.lecture18

Как сделать графическую оболочку для игры. Автор https://javarush.com/users/1357540


Для тех кто, как и я думал что решение данной задачи будет графическим, а не консольным:
Я сделал минимальные, как мне кажется исправления, у же имеющегося решения

В классе KeyboardObserver делаем следующие исправления:
1. private JFrame frame; меняем на: static JFrame frame; чтобы меньше делать исправлений;
2. frame.setSize(400, 400); задаем новые размеры окна frame.setSize((Room.game.getWidth() * 10) + 17, (Room.game.getHeight() * 10) + 40); это с учетом толщены рамок окна
3. frame.setExtendedState(JFrame.MAXIMIZED_BOTH); убираем разворот окна: //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
4. frame.setUndecorated(true); меняем на: frame.setUndecorated(false); чтобы у окна появилась рамка;
5. frame.setOpacity(0.0f); закомментарим эту строку //frame.setOpacity(0.0f); чтобы убрать прозрачность;
6. frame.setVisible(true); закомментарим и эту строку //frame.setVisible(true); отобразим окно в другом месте;

Далее добавляем новый класс, это класс отвечает за добавление графических элементов в окно программы:
public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(java.awt.Color.GREEN); //Задаем цвет элементов зеленый
        g.fillRect(Room.game.getWidth() * 10, 0, 10, (Room.game.getWidth() * 10) + 10);  //Рисуем прямоугольник показывающий край поля справа
        g.fillRect(0, Room.game.getHeight() * 10, (Room.game.getHeight() * 10) + 10, 10); //Рисуем прямоугольник показывающий край поля снизу

        g.fillRect(Room.game.getMouse().getX()*10, Room.game.getMouse().getY()*10, 10, 10); //Рисуем прямоугольник показывающий мышь

        List<SnakeSection> getsection = Room.game.getSnake().getSections(); //Получаем секции змейки
        for (int i = 0; i < getsection.size(); i++) {
            g.fillRect(getsection.get(i).getX()*10, getsection.get(i).getY()*10, 10, 10); //Рисуем по очереди секции змейки
        }
    }
}



Код для вставки:

// Класс Room
static JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("KeyPress Tester");
        frame.setTitle("Transparent JFrame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(false);
        frame.setSize((Room.game.getWidth() * 10) + 17, (Room.game.getHeight() * 10) + 40);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridBagLayout());

        //frame.setOpacity(0.0f);
        //frame.setVisible(true);


    // заменить метод paint на следующий
    public void print() {
         if (KeyboardObserver.frame != null) {
             KeyboardObserver.frame.setContentPane(new Layer());
             KeyboardObserver.frame.setVisible(true);
         }
     }


// Класс Layer
public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(java.awt.Color.GREEN); //Задаем цвет элементов зеленый
        g.fillRect(Room.game.getWidth() * 10, 0, 10, (Room.game.getWidth() * 10) + 10);  //Рисуем прямоугольник показывающий край поля справа
        g.fillRect(0, Room.game.getHeight() * 10, (Room.game.getHeight() * 10) + 10, 10); //Рисуем прямоугольник показывающий край поля снизу

        g.fillRect(Room.game.getMouse().getX() * 10, Room.game.getMouse().getY() * 10, 10, 10); //Рисуем прямоугольник показывающий мышь

        List<SnakeSection> getsection = Room.game.getSnake().getSections(); //Получаем секции змейки
        for (int i = 0; i < getsection.size(); i++) {
            g.fillRect(getsection.get(i).getX() * 10, getsection.get(i).getY() * 10, 10, 10); //Рисуем по очереди секции змейки
        }
    }
}