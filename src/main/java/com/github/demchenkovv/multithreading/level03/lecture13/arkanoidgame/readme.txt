Как сделать графический интерфейс.

По мотивам игры змейка:
Для тех кто, как и я думал что решение данной задачи будет графическим, а не консольным:
Я сделал минимальные, как мне кажется исправления, у же имеющегося решения

В классе KeyboardObserver делаем следующие исправления:
1. private JFrame frame; меняем на: static JFrame frame; чтобы меньше делать исправлений;
2. frame.setSize(400, 400); задаем новые размеры окна frame.setSize((Arkanoid.game.getWidth() * 20) + 55, (Arkanoid.game.getHeight() * 20) + 85); это с учетом толщены рамок окна
3. Ниже добавляем строку frame.setLocationRelativeTo(null); чтобы окно открывалось по центру экрана
3. frame.setExtendedState(JFrame.MAXIMIZED_BOTH); убираем разворот окна: //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
4. frame.setUndecorated(true); меняем на: frame.setUndecorated(false); чтобы у окна появилась рамка;
5. frame.setOpacity(0.0f); закомментируем эту строку //frame.setOpacity(0.0f); чтобы убрать прозрачность;
6. frame.setVisible(true); закомментируем и эту строку //frame.setVisible(true); отобразим окно в другом месте;


Далее добавляем новый класс, это класс отвечает за прорисовку графических элементов в окно программы:
import javax.swing.*;
import java.awt.*;

public class Layer extends JPanel {

    private char[][] matrix;

    public Layer(char[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                switch (matrix[i][j]) {
                    case 'O':
                        g.setColor(java.awt.Color.GREEN); //Задаем зеленый цвет для шарика
                        break;
                    case 'M':
                        g.setColor(Color.BLUE); //Задаем синийцвет для доски
                        break;
                    case 'H':
                        g.setColor(Color.CYAN); //Задаем бирюзовый цвет для кирпичей
                        break;
                    case '-':
                    case '|':
                        g.setColor(Color.BLACK); //Задаем черный цвет для границ
                        break;
                    default:
                        g.setColor(Color.DARK_GRAY); //Задаем темно-серый цвет для всего остального
                }
                g.fillRect(j * 20, i * 20, 20, 20);
            }
        }
    }
}


в классе Canvas заменить метод print на следующий

    public void print() {
        if (KeyboardObserver.frame != null) {
            KeyboardObserver.frame.setContentPane(new Layer(matrix));
            KeyboardObserver.frame.setVisible(true);
        }
    }