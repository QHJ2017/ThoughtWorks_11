

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

/**
 * Created by ArtistQiu on 2017/6/3.
 */
public class Checkerboard extends JFrame {
	String state = "随机";
	double speed = 1.0;
	String color = "蓝色";
	String method = "自动";
	int size = 10;

    Board myboard = new Board(size);
    int width_ract = 800 / size;


	public Checkerboard() {
		setTitle("棋盘格");
		//棋盘格大小
		setSize(800, 800);
		setVisible(true);
	}

	public Checkerboard(String in_state,double in_speed,String in_color,String in_method,int in_size) {
		myboard = new Board(in_size);
		state = in_state;
		speed = in_speed;
		color = in_color;
		method = in_method;
		size = in_size;
		width_ract = 800 / size;
		setTitle("棋盘格");
		//棋盘格大小
		setSize(800, 800);
		setVisible(true);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./source/temp.txt"),true));
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					writer.write(myboard.board[i][j]);
					if (j != size - 1) {
						writer.write(",");
					}
				}
				writer.write("\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Checkerboard (String filename,int size) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("./source/temp.txt")));
			int[][] temp = new int[size][size];
			String line = reader.readLine();
			int i = 0;
			while (line != null) {
				String[] split = line.split(",");
				for (int j = 0; j < size; j++) {
					temp[i][j] = Integer.valueOf(split[j]);
				}
				i++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {//调用超类的绘制方法
        super.paint(g);
        //绘制一个白色背景
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 800, 800);
        //绘制棋盘格
        g.setColor(new Color(35, 140, 220));

        Random random = new Random();
        int k = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (myboard.board[i][j] == 1) {
					random.setSeed(k++);
//                    g.setColor(new Color((int)(random.nextDouble() * 255) % 255, (int)(random.nextDouble() * 255) % 255, (int)(random.nextDouble() * 255) % 255));
					g.fillRect(j * width_ract,i * width_ract,width_ract - 3,width_ract - 3);
				}
			}
		}

        myboard.life_game();
    }

    public static void main(String args[]) throws InterruptedException {
        Checkerboard application = new Checkerboard();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int i = 0;
        while (true) {
            Thread.sleep(1000);
            application.repaint(100,0,0,800,800);
        }
    }
}

