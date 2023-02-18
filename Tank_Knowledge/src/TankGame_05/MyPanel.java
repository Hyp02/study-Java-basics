package TankGame_05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    HeroTank heroTank = null;
    EnemyTank enemyTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();//使用Vector集合存放坦克
    Vector<Blow> blows = new Vector();
    int x = 100;
    int y = 100;
    int enemySize = 3;
    //定义三张爆炸效果图片
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    //为了敌人坦克可以出现在随机的任意地方
    Random random = new Random();

    //构造器
    public MyPanel() {
        heroTank = new HeroTank(x, y);
        heroTank.setSelfQuantity(1);//我方坦克数量
        heroTank.setSpeed(20);//我方坦克速度;

        //使用集合存放三个敌人坦克对象
        for (int i = 0; i < enemySize; i++) {
            //给画出的敌人坦克出现在随机地方
            enemyTank = new EnemyTank(random.nextInt(700), random.nextInt(300));
            //速度
            enemyTank.setSpeed(5);
            enemyTank.setDirect("down");

            // 为集合中添加坦克对象
            enemyTanks.add(enemyTank);
            //开人敌启坦克移动线程
            {
                Thread thread = new Thread(enemyTank);
                thread.start();
                thread.setName(i + "移动线程");
            }
            //创建几个坦克就创建几个子弹所以要放到for循环中
            Shot shots = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60,
                    enemyTank.getDirect());
            enemyTank.shots.add(shots);//将创建的子弹加入集合中

            //启动发射子弹线程
            new Thread(shots).start();
            //创建好了敌人坦克对象后，启动敌人坦克移动线程；

        }
        image1 = Toolkit.getDefaultToolkit()
                .getImage(Panel.class.getResource("/1.png"));
        image2 = Toolkit.getDefaultToolkit()
                .getImage(Panel.class.getResource("/2.png"));
        image3 = Toolkit.getDefaultToolkit()
                .getImage(Panel.class.getResource("/3.png"));

    }

    //绘画面板
    public void paint(Graphics g) {
        super.paint(g);
        //面板大小
        g.fillRect(0, 0, 750, 750);
        //画出敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出对应索引的坦克
            enemyTank = enemyTanks.get(i);

            //如果取出的敌人的坦克的Live是true的话画出来
            if (enemyTank.Live) {

                DrawTank(enemyTank.getX(), enemyTank.getY(), enemyTank.getDirect(), g, 1);
                //这里为什么嵌套，（一个坦克可以发射多颗子弹）
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.live) {//子弹还在
                        //发射子弹
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }

                }
            } else {
                //如果这个坦克的生命已经成了false,就将这个坦克从集合中删除
                enemyTanks.remove(enemyTank);
            }
        }

        //如果blows中有炸弹，画出（有没有炸弹已经在blowEnemyTank中添加过了）
        for (int i = 0; i < blows.size(); i++) {
            Blow blow = blows.get(i);
            //根据炸弹的显示周期画出
            if (blow.left > 6) {
                g.drawImage(image1, blow.x, blow.y, 60, 60, this);
            } else if (blow.left > 3) {
                g.drawImage(image2, blow.x, blow.y, 60, 60, this);
            } else {
                g.drawImage(image3, blow.x, blow.y, 60, 60, this);
            }
            blow.Bloow();
            if (blow.left == 0) {
                blows.remove(blow);
            }
        }
        //绘制我方坦克
        DrawTank(heroTank.getX(), heroTank.getY(), heroTank.getDirect(), g, 0);
        //绘制我方坦克的子弹
        if (heroTank.shot != null && heroTank.shot.live == true) {
            System.out.println("子弹被重新绘制~~~");
            g.draw3DRect(heroTank.shot.x, heroTank.shot.y, 2, 2, false);
        }
    }

    public void blowEnemyTank(Shot shot, EnemyTank enemyTank) {
        switch (enemyTank.getDirect()) {
            case "up":
            case "down"://炮口向下向上坦克所在范围是一样的
                if (shot.x > enemyTank.getX() && shot.x < enemyTank.getX() + 40
                        && shot.y > enemyTank.getY() && shot.y < enemyTank.getY() + 60) {
                    //遇到后，让敌人坦克的Live和发射的子弹的Live成为False
                    enemyTank.Live = false;
                    shot.live = false;
                    //记录被炸的坦克坐标//让爆炸效果在被炸的坦克的位置显示
                    Blow blow = new Blow(enemyTank.getX(), enemyTank.getY());
                    blows.add(blow);
                }
                break;
            case "left":
            case "right"://炮口向左向右坦克所在范围是一样的
                if (shot.x > enemyTank.getX() && shot.x < enemyTank.getX() + 60
                        && shot.y > enemyTank.getY() && shot.y < enemyTank.getY() + 40) {
                    //遇到后，让敌人坦克的Live和发射的子弹的Live成为False
                    enemyTank.Live = false;
                    shot.live = false;
                    //让爆炸效果在被炸的坦克的位置显示
                    Blow blow = new Blow(enemyTank.getX(), enemyTank.getY());
                    blows.add(blow);
                }
                break;

        }
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

    /**
     * 键盘控制坦克左右移动
     * 限制坦克活动范围
     * @param
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            heroTank.setDirect("down");//按下相应的键后改变成相应方向的坦克
//          继续向下： 要保证不可以超出上边界
//          条件是 保证y坐标要小于下边界的y坐标
            if (heroTank.getY()+60 < 750) {
                heroTank.down();
            }
            // hero.setY(y++);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {

            heroTank.setDirect("up");
            //能继续向上: 要保证不可以超出上边界
            //条件是 保证y坐标要大于0
            if (heroTank.getY() > 0) {
                heroTank.up();
            }
            //hero.setY(y--);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            heroTank.setDirect("left");
            //继续向左：要保证不可以超出左边界
            // 条件是 保证x坐标要大于0
            if (heroTank.getX() > 0) {
                heroTank.left();
            }

            //hero.setX(x--);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            heroTank.setDirect("right");
            if (heroTank.getX()+60 <= 750) {

                heroTank.right();
            }
            //hero.setX(x++);
        }
        //继续向右： 要保证不可以超出右边界
        //条件是 保证x坐标要小于右边界的x坐标
        if (e.getKeyCode() == KeyEvent.VK_J) {
            heroTank.TankShot();
        }

        this.repaint();//按下相应的键后重新绘制坦克

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void run() {//MyPaint类实现了Runnable接口，重写run方法，让面板作为一个线程不停重新绘制

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //如果我方坦克子弹还存活
            //如果没有按下J发射我方坦克子弹，相当于我方坦克子弹是NULL所以要加一个判断条件
            //这里是断路且，必须先要保证子弹对象不是null，
            // 所以heroTank.shot!=null&&heroTank.shot.live判断条件的先后顺序必须是这样
            //重绘前将敌方坦克的live属性改变
            if (heroTank.shot != null && heroTank.shot.live) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank1 = enemyTanks.get(i);
                    //用子弹将相应坦克打爆(消失)
                    blowEnemyTank(heroTank.shot, enemyTank1);
                }
            }

            this.repaint();
        }

    }
}
