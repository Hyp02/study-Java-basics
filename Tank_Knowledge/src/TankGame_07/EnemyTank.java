package TankGame_07;

import java.util.Random;
import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Random random = new Random();
    boolean Live = true;//敌人坦克最开始活着的
    //敌人子弹
    Vector<Shot> shots = new Vector<>();//坦克子弹集合
    Shot shot;
    Vector<EnemyTank> enemyTanks = new Vector<>();//坦克集合

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public void ItTankShot() {
        //限制坦克一次发射的数量.达到规定数量时就退出这个方法
        if (shots.size() == 5) {
            return;
        }
        switch (getDirect()) {

            case "up":
                shot = new Shot(getX() + 20, getY() - 10, "up");
                break;
            case "down":
                shot = new Shot(getX() + 20, getY() + 70, "down");
                break;
            case "left":
                shot = new Shot(getX() - 10, getY() + 20, "left");
                break;
            case "right":
                shot = new Shot(getX() + 70, getY() + 20, "right");
                break;
        }
        //每次调用这个方法是，创建一个子弹
        //将这个子弹存放到集合中
        shots.add(shot);
        new Thread(shot).start();
    }

    public boolean isEnemyTankCrash() {
        //获取当前坦克的方向
        switch (this.getDirect()) {
            case "up":
                //和剩下的所有坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //左上角坐标
                        //其他坦克方向下上下的时候
                        if (enemyTank.getDirect() == "up" || enemyTank.getDirect() == "down") {
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克反向向左右时
                        if (enemyTank.getDirect() == "right" || enemyTank.getDirect() == "left") {
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        //右上角坐标
                        if (enemyTank.getDirect() == "up" || enemyTank.getDirect() == "down") {
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克反向向左右时
                        if (enemyTank.getDirect() == "right" || enemyTank.getDirect() == "left") {
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case "down":
                //和剩下的所有坦克进行比较

                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //左下·角坐标
                        //其他坦克方向下上下的时候
                        if (enemyTank.getDirect() == "up" || enemyTank.getDirect() == "down") {
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() + 60 > enemyTank.getY()
                                    && this.getY() + 60 < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克反向向左右时
                        if (enemyTank.getDirect() == "right" || enemyTank.getDirect() == "left") {
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY() + 60 > enemyTank.getY()
                                    && this.getY() + 60 > enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        //右上角坐标
                        //其他坦克方向向上下时
                        if (enemyTank.getDirect() == "up" || enemyTank.getDirect() == "down") {
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 40
                                    && this.getY() + 60 > enemyTank.getY()
                                    && this.getY() + 60 < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克反向向左右时
                        if (enemyTank.getDirect() == "right" || enemyTank.getDirect() == "left") {
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 60
                                    && this.getY() + 60 > enemyTank.getY()
                                    && this.getY() + 60 < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            //我方坦克向左边时候
            case "left":
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //左上角坐标
                        //其他坦克方向下上下的时候
                        if (enemyTank.getDirect() == "up" || enemyTank.getDirect() == "down") {
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克反向向左右时
                        if (enemyTank.getDirect() == "right" || enemyTank.getDirect() == "left") {
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        //左下角坐标
                        if (enemyTank.getDirect() == "up" || enemyTank.getDirect() == "down") {
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() +40 > enemyTank.getY()
                                    && this.getY() +40< enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克反向向左右时
                        if (enemyTank.getDirect() == "right" || enemyTank.getDirect() == "left") {
                            if (this.getX()  > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY()+40 > enemyTank.getY()
                                    && this.getY()+40< enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case "right":
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //右上角坐标
                        //其他坦克方向下上下的时候
                        if (enemyTank.getDirect() == "up" || enemyTank.getDirect() == "down") {
                            if (this.getX() +60> enemyTank.getX()
                                    && this.getX() +60< enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克反向向左右时
                        if (enemyTank.getDirect() == "right" || enemyTank.getDirect() == "left") {
                            if (this.getX() +60> enemyTank.getX()
                                    && this.getX()+60 < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        //右下角坐标
                        if (enemyTank.getDirect() == "up" || enemyTank.getDirect() == "down") {
                            if (this.getX() +60> enemyTank.getX()
                                    && this.getX() +60< enemyTank.getX() + 40
                                    && this.getY() +40 > enemyTank.getY()
                                    && this.getY() +40< enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //其他坦克反向向左右时
                        if (enemyTank.getDirect() == "right" || enemyTank.getDirect() == "left") {
                            if (this.getX() +60 > enemyTank.getX()
                                    && this.getX() +60< enemyTank.getX() + 60
                                    && this.getY()+40 > enemyTank.getY()
                                    && this.getY()+40< enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;

        }
        return false;
    }

    @Override
    public void run() {
        //坦克显示范围
        int length = 350;
        int width = 350;

        while (true) {
            ItTankShot();
            switch (getDirect()) {
                case "up":
                    //坦克移动循环
                    for (int i = 0; i < 30; i++) {
                        if(!isEnemyTankCrash())
                        up();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //限制坦克行动范围
                        //坦克移动到这个范围外的时候，退出坦克移动循环（不再往这个方向运动）
                        if (!(getX() > 0 && getX() < length && getY() > 4 && getY() < width)) {
                            break;
                        }
                    }

                    break;
                case "down":
                    for (int i = 0; i < 30; i++) {
                        if(!isEnemyTankCrash())
                        down();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (!(getX() > 0 && getX() < length && getY() > 0 && getY() + 60 < width)) {
                            break;
                        }
                    }
                    break;
                case "left":
                    for (int i = 0; i < 30; i++) {
                        if(!isEnemyTankCrash())
                        left();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (!(getX() > 0 && getX() < length && getY() > 0 && getY() + 60 < width)) {
                            break;
                        }
                    }
                    break;
                case "right":
                    for (int i = 0; i < 30; i++) {
                        if(!isEnemyTankCrash())
                        right();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (!(getX() > 0 && getX() + 60 < length && getY() > 0 && getY() < width)) {
                            break;
                        }
                    }
                    break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = (int) (Math.random() * 4);
            System.out.println(Thread.currentThread().getName() + "执行");
            switch (i) {

                case 0:
                    setDirect("up");
                    break;
                case 1:
                    setDirect("down");
                    break;
                case 2:
                    setDirect("left");
                    break;
                case 3:
                    setDirect("right");
                    break;
            }
            if (!Live) {
                break;
            }
        }
    }

}
