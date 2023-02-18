package TankGame_06;

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
    Vector<HeroTank> heroTanks = new Vector<>();
    Vector<Blow> blows = new Vector();
    int x = 100;
    int y = 500;
    int enemySize = 3;
    int heroSize = 1;
    //定义三张爆炸效果图片
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    //为了敌人坦克可以出现在随机的任意地方
    Random random = new Random();

    //构造器
    public MyPanel() {
        //给Recorder类中的EnemyTanks 集合变量中添加敌人坦克集合号
        Recorder.setEnemyTanks(enemyTanks);
        // heroTank.setSelfQuantity(1);//我方坦克数量
        for (int i = 0; i < heroSize; i++) {
            heroTank = new HeroTank(x, y);
            heroTank.setSpeed(3);//我方坦克速度;
            heroTanks.add(heroTank);
        }

        //使用集合存放三个敌人坦克对象
        for (int i = 0; i < enemySize; i++) {

            //给画出的敌人坦克出现在随机地方
            enemyTank = new EnemyTank(100 * (i + 1), 5);
            //分别给敌人 我方 坦克类中的的EnemyTanks Vector集合中加入敌人坦克的对象
            //防重叠
            enemyTank.setEnemyTanks(enemyTanks);
            heroTank.setEnemyTanks(enemyTanks);
            //速度
            enemyTank.setSpeed(3);
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
//            for (int j = 0; j < enemyShotNums; j++) {
//
//            }
            Shot shots = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60,
                    enemyTank.getDirect());
            enemyTank.shots.add(shots);//将创建的子弹加入集合中

            //启动敌人发射子弹线程
            new Thread(shots).start();

        }

        //读取爆炸图片
        image1 = Toolkit.getDefaultToolkit()
                .getImage(Panel.class.getResource("/1.png"));
        image2 = Toolkit.getDefaultToolkit()
                .getImage(Panel.class.getResource("/2.png"));
        image3 = Toolkit.getDefaultToolkit()
                .getImage(Panel.class.getResource("/3.png"));

    }
    public void showScore(Graphics g){
        g.setColor(Color.black);
        Font font = new Font("宋体",Font.BOLD,25);
        g.setFont(font);
        g.drawString("您已成功击毁敌方坦克总数",780,30);
        DrawTank(800,60,"up",g,1);
        g.setColor(Color.black);
        //将int类型的摧毁敌人数量的数据转成String类型
        g.drawString(Integer.toString(Recorder.getAllDieEnemyTankNum()),860,100);
        if(Recorder.getAllDieEnemyTankNum()==enemySize){
            Font font1 = new Font("黑体", Font.BOLD, 35);
            g.setFont(font1);
            g.drawString("你已经击毁所有敌人坦克",760,200);
        }
        if(!heroTank.Live){
            Font font1 = new Font("黑体", Font.BOLD, 35);
            g.setColor(Color.red);
            g.setFont(font1);
            g.drawString("您已经死亡",760,400);

        }
    }

    //绘画面板
    public void paint(Graphics g) {
        super.paint(g);
        //面板大小
        //默认黑色
        g.fillRect(0, 0, 750, 750);
        showScore(g);
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
                        //enemyTank.ItTankShot();
                    }

                }
            } else {
                //如果这个坦克的生命已经成了false,就将这个坦克从集合中删除
                enemyTanks.remove(enemyTank);
                //增加死亡的坦克数量
                Recorder.addAllEnemyTankNum();
            }
        }
        //炸弹动画效果
        //如果blows中有炸弹，画出（有没有炸弹已经在blowEnemyTank中添加过了）
        for (int i = 0; i < blows.size(); i++) {
            Blow blow = blows.get(i);
            //根据炸弹的显示周期画出
            if (blow.left > 6) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
        for (int i = 0; i < heroTanks.size(); i++) {
            HeroTank heroTank = heroTanks.get(i);
            if (heroTank.Live == true) {

                DrawTank(this.heroTank.getX(), this.heroTank.getY(), this.heroTank.getDirect(), g, 0);
            } else {

                heroTanks.remove(heroTank);
                System.out.println("将我方坦克删除");
            }
        }
        ;
        //绘制我方坦克的子弹
//        if (heroTank.shot != null && heroTank.shot.live == true) {
//            System.out.println("子弹被重新绘制~~~");
//            g.draw3DRect(heroTank.shot.x, heroTank.shot.y,
//                    2, 2, false);
//        }
        //现在已经可以发射多个子弹了,所以要遍历子弹
        //并且保证子弹可以不停的连续发射
        for (int i = 0; i < heroTank.shots.size(); i++) {
            Shot shot = heroTank.shots.get(i);
            //如果这个子弹存在并且不为null
            if (shot != null && shot.live == true) {
                g.draw3DRect(shot.x, shot.y,
                        2, 2, false);
            } else {//子弹消亡后再集合中删除这个子弹
                heroTank.shots.remove(shot);
            }
        }
    }
    //开始摧毁我方坦克
    public void hitHeroTank() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                for (int k = 0; k < heroTanks.size(); k++) {
                    HeroTank heroTank = heroTanks.get(k);
                    blowHeroTank(shot, heroTank);
                }

            }
        }
    }
    //开始摧毁敌人坦克
    public void hitEnemyTank () {
        if (heroTank.shot != null && heroTank.shot.live) {
            //遍历敌人坦克
            for (int i = 0; i < enemyTanks.size(); i++) {
                //取出敌人坦克
                EnemyTank enemyTank1 = enemyTanks.get(i);
                //遍历我方子弹
                // 让每一颗子弹都可以让敌人爆炸
                for (int j = 0; j < heroTank.shots.size(); j++) {
                    //取出我方子弹
                    Shot shot = heroTank.shots.get(j);
                    //用子弹将相应坦克打爆(消失)
                    blowEnemyTank(shot, enemyTank1);
                }
            }
        }
    }
    //销毁敌人坦克的方法
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

    //销毁自己坦克的方法
    public void blowHeroTank(Shot shot, HeroTank heroTank) {
        switch (heroTank.getDirect()) {
            case "up":
            case "down"://炮口向下向上坦克所在范围是一样的
                if (shot.x > heroTank.getX() && shot.x < heroTank.getX() + 40
                        && shot.y > heroTank.getY() && shot.y < heroTank.getY() + 60) {
                    //遇到后，让敌人坦克的Live和发射的子弹的Live成为False
                    heroTank.Live = false;
                    shot.live = false;
                    //记录被炸的坦克坐标//让爆炸效果在被炸的坦克的位置显示
                    Blow blow = new Blow(heroTank.getX(), heroTank.getY());
                    blows.add(blow);
                }
                break;
            case "left":
            case "right"://炮口向左向右坦克所在范围是一样的
                if (shot.x > heroTank.getX() && shot.x < heroTank.getX() + 60
                        && shot.y > heroTank.getY() && shot.y < heroTank.getY() + 40) {
                    //遇到后，让敌人坦克的Live和发射的子弹的Live成为False
                    heroTank.Live = false;
                    shot.live = false;
                    //让爆炸效果在被炸的坦克的位置显示
                    Blow blow = new Blow(heroTank.getX(), heroTank.getY());
                    blows.add(blow);
                }
                break;

        }
    }

//    public void BLOW(Shot shot,Tank tank){
//        switch (enemyTank.getDirect()) {
//            case "up":
//            case "down"://炮口向下向上坦克所在范围是一样的
//                if (shot.x > tank.getX() && shot.x < tank.getX() + 40
//                        && shot.y > tank.getY() && shot.y < tank.getY() + 60) {
//                    //遇到后，让敌人坦克的Live和发射的子弹的Live成为False
//                    tank.Live = false;
//                    shot.live = false;
//                    //记录被炸的坦克坐标//让爆炸效果在被炸的坦克的位置显示
//                    Blow blow = new Blow(tank.getX(), tank.getY());
//                    blows.add(blow);
//                }
//                break;
//            case "left":
//            case "right"://炮口向左向右坦克所在范围是一样的
//                if (shot.x > enemyTank.getX() && shot.x < enemyTank.getX() + 60
//                        && shot.y > enemyTank.getY() && shot.y < enemyTank.getY() + 40) {
//                    //遇到后，让敌人坦克的Live和发射的子弹的Live成为False
//                    enemyTank.Live = false;
//                    shot.live = false;
//                    //让爆炸效果在被炸的坦克的位置显示
//                    Blow blow = new Blow(enemyTank.getX(), enemyTank.getY());
//                    blows.add(blow);
//                }
//                break;
//        }
//
//    }


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
     *
     * @param
     */
    @Override
    //次方法是用来监听键盘按键，来控制我方坦克移动方向的
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_S) {

            heroTank.setDirect("down");//按下相应的键后改变成相应方向的坦克
//          继续向下： 要保证不可以超出上边界
//          条件是 保证y坐标要小于下边界的y坐标9
            //并且不能碰撞到敌人坦克
            if (heroTank.getY() + 60 < 750&&!heroTank.isCrashHero()) {
                heroTank.down();
            }
            // hero.setY(y++);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {

            heroTank.setDirect("up");
            //能继续向上: 要保证不可以超出上边界
            //条件是 保证y坐标要大于0
            //并且不能碰撞到敌人坦克
            if (heroTank.getY() > 0&&!heroTank.isCrashHero()) {
                heroTank.up();
            }
            //hero.setY(y--);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {

            heroTank.setDirect("left");
            //继续向左：要保证不可以超出左边界
            // 条件是 保证x坐标要大于0
            //并且不能碰撞到敌人坦克
            if (heroTank.getX() > 0&&!heroTank.isCrashHero()) {
                heroTank.left();
            }

            //hero.setX(x--);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            //继续向右
            //条件是 保证x坐标小于页面的x的范围
            //并且不能和坦克发生碰撞
            heroTank.setDirect("right");
            if (heroTank.getX() + 60 <= 750&&!heroTank.isCrashHero()) {

                heroTank.right();
            }
            //hero.setX(x++);
        }
        //继续向右： 要保证不可以超出右边界
        //条件是 保证x坐标要小于右边界的x坐标
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //当一颗子弹销毁后才可以继续发射
//            if(heroTank.shot==null||!heroTank.shot.live){
//                heroTank.TankShot();
//            }
            heroTank.MyTankShot();
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
            {//这是只用一颗子弹的销毁逻辑
                //如果我方坦克子弹还存活
                //如果没有按下J发射我方坦克子弹，相当于我方坦克子弹是NULL所以要加一个判断条件
                //这里是断路且，必须先要保证子弹对象不是null，
                // 所以heroTank.shot!=null&&heroTank.shot.live判断条件的先后顺序必须是这样
                //重绘前将敌方坦克的live属性改变
//                if (heroTank.shot != null && heroTank.shot.live) {
//                    for (int i = 0; i < enemyTanks.size(); i++) {
//                        EnemyTank enemyTank1 = enemyTanks.get(i);
//                        //用子弹将相应坦克打爆(消失)
//                        blowEnemyTank(heroTank.shot, enemyTank1);
//                    }
//                }
//            }
                hitHeroTank();
                hitEnemyTank();
                this.repaint();
            }

        }
    }
}
