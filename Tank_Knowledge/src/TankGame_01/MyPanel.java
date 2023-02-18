package TankGame_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    int x = 100;
    int y = 100;
    String direct = "up";//方向初始化为上。方向为变量
    public void paint(Graphics g) {
        hero = new Hero(x, y);
        super.paint(g);
        g.fillRect(0, 0, 1000, 1000);
        DrawTank(hero.getX(), hero.getY(), "up", g, 0);
//        DrawTank(hero.getX() + 100, hero.getY() + 100, "down", g, 1);
//        DrawTank(hero.getX() + 200, hero.getY() + 200, "right", g, 1);
//        DrawTank(hero.getX() + 300, hero.getY(), "left", g, 1);
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
            direct = "down";
            y++;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            direct = "up";
            y--;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            direct = "left";
            x--;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direct = "right";
            x++;
        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
