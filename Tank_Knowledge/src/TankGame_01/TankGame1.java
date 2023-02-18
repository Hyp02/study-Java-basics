package TankGame_01;

import javax.swing.*;

public class TankGame1 extends JFrame {
    MyPanel mp;
    public static void main(String[] args) {
        new TankGame1();
    }
    public TankGame1(){
        mp = new MyPanel();
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
