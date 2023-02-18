package TankGame_06;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankGame6 extends JFrame {
    MyPanel mp;
    public static void main(String[] args) {
        new TankGame6();
    }
    public TankGame6(){

        mp = new MyPanel();
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
                Recorder.saveScore();
                System.exit(0);
            }
        });
    }

}
