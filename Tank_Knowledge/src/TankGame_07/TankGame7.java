package TankGame_07;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class TankGame7 extends JFrame {
    int key;
    MyPanel mp;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        new TankGame7();

    }
    public TankGame7() throws IOException {
        System.out.println("输入1开始新游戏。输入2继续上局游戏");
        key = scanner.nextInt();
        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();//开启面板重绘线程
        this.setSize(1200,750);//初始化操作界面大小
        this.addKeyListener(mp);
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Recorder.saveEInformation();
                try {
                    Recorder.saveHInformation();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

}
