package TankGame_05;

import javax.swing.*;

public class TankGame5 extends JFrame {
    MyPanel mp;
    public static void main(String[] args) {
        new TankGame5();
    }
    public TankGame5(){

        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();//开启面板重绘线程
        this.setSize(700,700);//初始化操作界面大小
        this.addKeyListener(mp);
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
