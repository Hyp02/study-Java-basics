package TankGame_03;

import javax.swing.*;

public class TankGame3 extends JFrame {
    MyPanel mp;
    public static void main(String[] args) {
        new TankGame3();
    }
    public TankGame3(){
        mp = new MyPanel();
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
