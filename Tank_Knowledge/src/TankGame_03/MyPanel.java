package TankGame_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements  KeyListener {
    HeroTank heroTank = null;
    EnemyTank enemyTank;
    Vector<EnemyTank> enemyTanks = null;//使用Vector集合存放坦克
    int x = 100;
    int y = 100;
    int enemySize = 3;

    public MyPanel() {
        heroTank = new HeroTank(x, y);
        enemyTanks = new Vector<>();//创建集合对象
        heroTank.setSelfQuantity(1);//我方坦克数量
        heroTank.setSelfSpeed(50);//我方坦克速度;
        //使用集合存放三个敌人坦克对象
        for (int i = 0; i < enemySize; i++) {
            enemyTanks.add(new EnemyTank(x * (i + 1), y - 100));//为集合中添加坦克对象
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 1000);
        for (int i = 0; i < enemyTanks.size(); i++) {
            enemyTank = enemyTanks.get(i);//取出对应索引的坦克
            DrawTank(enemyTank.getX(), enemyTank.getY(), enemyTank.getDirect(), g, 1);
        }
        DrawTank(heroTank.getX(), heroTank.getY(), heroTank.getDirect(), g, 0);
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
            case "BY":
                g.fillOval(x + 8, y, 2, 2);
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            heroTank.setDirect("down");//按下相应的键后改变成相应方向的坦克
            heroTank.down();

            // hero.setY(y++);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            heroTank.setDirect("up");
            heroTank.up();

            //hero.setY(y--);

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            heroTank.setDirect("left");
            heroTank.left();

            //hero.setX(x--);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            heroTank.setDirect("right");
            heroTank.right();

            //hero.setX(x++);
        }

        this.repaint();//按下相应的键后重新绘制坦克

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
