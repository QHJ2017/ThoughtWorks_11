import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by ArtistQiu on 2017/6/3.
 */
public class Selection extends JFrame {
	int[][] temp;


    String[] state = {"随机","1","2","3"};
    String[] speed = {"0.5","1","2","5"};
    String[] color = {"彩色","蓝色"};
    String[] method = {"自动","手动"};

    JPanel panel_buttom = new JPanel();
    JComboBox comboBox_state = new JComboBox(state);
    JComboBox comboBox_speed = new JComboBox(speed);
    JComboBox comboBox_color = new JComboBox(color);
    JComboBox comboBox_method = new JComboBox(method);
    JTextField field_size = new JTextField();
    JLabel label_state = new JLabel();
    JLabel label_speed = new JLabel();
    JLabel label_color = new JLabel();
    JLabel label_method = new JLabel();
    JLabel label_size = new JLabel();
    JButton button_start = new JButton();
    JButton button_next = new JButton();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Selection selection = new Selection();
        selection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Selection () {
        add(panel_buttom);
        panel_buttom.setLocation(800, 0);
        panel_buttom.setSize(300, 200);
        panel_buttom.setVisible(true);
        panel_buttom.setLayout(new GridLayout(6, 2, 5, 5));

        label_state.setText("初始状态");
        label_state.setVisible(true);
        label_state.setSize(100, 20);
        label_state.setLocation(20, 20);
        panel_buttom.add(label_state);
        comboBox_state.setVisible(true);
        comboBox_state.setSize(200, 40);
        comboBox_state.setLocation(20, 40);
        comboBox_state.setToolTipText("随机");
        panel_buttom.add(comboBox_state);

        label_speed.setText("速度选择(单位：s)");
        label_speed.setVisible(true);
        label_speed.setSize(100, 20);
        label_speed.setLocation(20, 20);
        panel_buttom.add(label_speed);
        comboBox_speed.setVisible(true);
        comboBox_speed.setSize(200, 40);
        comboBox_speed.setLocation(20, 40);
        comboBox_speed.setToolTipText("1");
        panel_buttom.add(comboBox_speed);

        label_color.setText("颜色选择");
        label_color.setVisible(true);
        label_color.setSize(100, 20);
        label_color.setLocation(20, 20);
        panel_buttom.add(label_color);
        comboBox_color.setVisible(true);
        comboBox_color.setSize(200, 40);
        comboBox_color.setLocation(20, 40);
        comboBox_color.setToolTipText("蓝色");
        panel_buttom.add(comboBox_color);

        label_size.setText("空间大小");
        label_size.setVisible(true);
        label_size.setSize(100, 20);
        label_size.setLocation(20, 20);
        panel_buttom.add(label_size);
        field_size.setText("10");
        field_size.setSize(50, 40);
        field_size.setLocation(50, 200);
        panel_buttom.add(field_size);

        button_start.setText("自动");
        button_start.setVisible(true);
        button_start.setSize(50, 20);
        button_start.setLocation(50, 600);
        button_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                Checkerboard application = new Checkerboard();
                application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    application.repaint(100, 0, 0, 800, 800);
                }
            }
        });
        panel_buttom.add(button_start);

	    final boolean[] flag = {true};

        button_next.setText("手动");
        button_next.setVisible(true);
        button_next.setSize(50, 20);
        button_next.setLocation(50, 600);
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
	            int size = Integer.valueOf(field_size.getText());
            	if (flag[0]) {
		            String state = comboBox_state.getSelectedItem().toString();
		            double speed = Double.valueOf(comboBox_speed.getSelectedItem().toString());
		            String color = comboBox_color.getSelectedItem().toString();
		            String method = comboBox_method.getSelectedItem().toString();
		            temp = new int[size][size];
		            System.out.println(state);
		            System.out.println(speed);
		            System.out.println(color);
		            System.out.println(method);
		            System.out.println(size);
		            try {
			            File file = new File("./source/temp.txt");
			            if (file.exists()) {
				            file.delete();
				            file.createNewFile();
			            }
		            } catch (IOException e1) {
			            e1.printStackTrace();
		            }
		            Checkerboard application = new Checkerboard(state, speed, color, method, size);
		            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            application.repaint(100, 0, 0, 800, 800);
		            flag[0] = false;
	            }
	            else {
		            Checkerboard application = new Checkerboard("./source/temp.txt",size);
		            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            application.repaint(100, 0, 0, 800, 800);
	            }
            }
        });
        panel_buttom.add(button_next);

        this.setTitle("设置界面");
        this.setSize(300, 200);
        this.setVisible(true);
        this.setLocation(600, 300);
    }
}
