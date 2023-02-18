package TankGame_02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    int x = 100;
    int y = 100;
    String direct = "up";//方向初始化为上。方向为 变量
    public MyPanel(){
        hero = new Hero(x, y);
        hero.setSelfQuantity(1);
        hero.setEnemyQuantity(3);
        hero.setSelfSpeed(3);
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 1000);
        for (int i = 0; i < hero.getSelfQuantity(); i++) {
            DrawTank(hero.getX(), hero.getY(), hero.getDirect(), g, 0);
        }
//        for (int i = 0; i < hero.getEnemyQuantity(); i++) {
//            DrawTank(hero.getX()+50,hero.getY()+50, hero.getDirect(), g,1);
//        }
    }

    public void DrawTank(int x, int y, String direct, Graphics g, int type) {
        switch (type) {
            case 0://我方坦克颜色
                g.setColor(Color.yellow);
                break;
            default://敌人坦克颜色
                g.setColor(Color.CYAN);
                break;
        }
        switch (direct) {
            case "up":
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 8, y + 20, 22, 20);
                g.drawLine(x + 20, y + 30, x + 20, y - 10);
                break;
            case "down":
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 8, y + 20, 22, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 70);
                break;
            case "right":
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 8, 20, 22);
                g.drawLine(x + 30, y + 20, x + 70, y + 20);
                break;
            case "left":
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 8, 20, 22);
                g.drawLine(x + 30, y + 20, x - 10, y + 20);

                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDirect("down");//按下相应的键后改变成相应方向的坦克
            hero.down();
            // hero.setY(y++);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDirect("up");
            hero.up();
            //hero.setY(y--);

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirect("left");
            hero.left();
            //hero.setX(x--);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirect("right");
            hero.right();
            //hero.setX(x++);
        }
        this.repaint();//按下相应的键后重新绘制坦克

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
