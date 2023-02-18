package TankGame_07;

import java.util.Vector;

public class HeroTank extends Tank {
    boolean Live = true;
    Shot shot;
    //发射多颗子弹的话，就要使用集合将子弹存起来
    Vector<Shot> shots = new Vector();
    Vector<EnemyTank> enemyTanks = new Vector<>();
    public HeroTank(int x, int y) {
        super(x, y);
    }

    public Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //我方坦克是否和敌人坦克发生碰撞
    public boolean isCrashHero(){
        switch (this.getDirect()) {
            case "up":
                //和剩下的所有坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                   EnemyTank enemyTank = enemyTanks.get(i);
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
                break;
            case "down":
                //和剩下的所有坦克进行比较

                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                        //左上角坐标
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
                break;
            //我方坦克向左边时候
            case "left":
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);

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
                break;
            case "right":
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);

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
                break;

        }
        return false;
    }
    //我方坦克发射子弹方法
    public void MyTankShot(){
        //限制坦克一次发射的数量.达到规定数量时就退出这个方法
        if(shots.size()==5){
            return;
        }
        switch (getDirect()){
            case "up":
                shot = new Shot(getX()+20,getY()-10,"up");
                break;
            case "down":
                shot = new Shot(getX()+20,getY()+70,"down");
                break;
            case "left":
                shot = new Shot(getX()-10,getY()+20,"left");
                break;
            case "right":
                shot = new Shot(getX()+70,getY()+20,"right");
                break;
        }
        //每次调用这个方法是，创建一个子弹
        //将这个子弹存放到集合中
        shots.add(shot);
        new Thread(shot).start();
    }
}
