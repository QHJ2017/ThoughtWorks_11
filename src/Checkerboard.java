import javax.swing.*;
import java.awt.*;

/**
 * Created by ArtistQiu on 2017/6/3.
 */
public class Checkerboard extends JFrame {

    Board myboard = new Board(10);
    //定西西洋棋盘格名称大小
    public Checkerboard() {
        //西洋棋盘格名称
        super("西洋棋盘格");
        //西洋棋盘格大小
        setSize(1000, 800);
        setVisible(true);
        JTextArea area = new JTextArea();
        super.add(area);
        area.setLocation(820,400);
        area.setVisible(true);
    }

    public void paint(Graphics g) {//调用超类的绘制方法
        super.paint(g);
        //绘制一个白色背景
        g.setColor(new Color(255, 255, 225));
        g.fillRect(0, 0, 800, 800);
        //绘制棋盘格
        g.setColor(new Color(35, 140, 220));
        for (int i = 0; i <= 10; i++) {//y方向循环,循环8行
            if (i % 2 != 0) {//1，3，5，7行判断
                for (int j = 1; j <= 10; j++) {//x方向循环，绘制基数行黑框
                    if (j % 2 == 0) {
                        g.fillRect((j - 1) * 80, (i - 1) * 80, 80, 80);
                    }
                }
            } else {//2，4，6，8行段
                for (int j = 1; j <= 10; j++) {
                    if (j % 2 != 0) {//x方向循环，绘制偶数行黑框
                        g.fillRect((j - 1) * 80, (i - 1) * 80, 80, 80);
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Checkerboard application = new Checkerboard();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

