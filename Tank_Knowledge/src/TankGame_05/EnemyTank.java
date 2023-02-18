package TankGame_05;

import java.util.Random;
import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Random random = new Random();
    boolean Live = true;//敌人坦克最开始活着的
    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }
    @Override
    public void run() {
        while (true) {
            switch (getDirect()) {
                case "up":
                    //坦克移动循环
                    for (int i = 0; i < 30; i++) {
                        up();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //限制坦克行动范围
                        //坦克移动到这个范围外的时候，退出坦克移动循环（不再往这个方向运动）
                        if(!(getX()>0&&getX()<750&&getY()>0&&getY()<750)){
                            break;
                        }
                    }
                    break;
                case "down":
                    for (int i = 0; i < 30; i++) {
                        down();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(!(getX()>0&&getX()+60<750&&getY()>0&&getY()<750)){
                            break;
                        }
                    }
                    break;
                case "left":
                    for (int i = 0; i < 30; i++) {
                        left();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(!(getX()>0&&getX()<750&&getY()>0&&getY()<750)){
                            break;
                        }
                    }
                    break;
                case "right":
                    for (int i = 0; i < 30; i++) {
                        right();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(!(getX()>0&&getX()+60<750&&getY()>0&&getY()<750)){
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
            System.out.println(Thread.currentThread().getName()+"执行");
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
