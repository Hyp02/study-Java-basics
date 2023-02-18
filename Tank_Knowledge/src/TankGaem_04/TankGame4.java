package TankGaem_04;

import javax.swing.*;

public class TankGame4 extends JFrame {
    MyPanel mp;
    public static void main(String[] args) {
        new TankGame4();
    }
    public TankGame4(){

        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
