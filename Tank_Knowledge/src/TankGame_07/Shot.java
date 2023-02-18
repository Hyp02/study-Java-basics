package TankGame_07;

public class Shot implements Runnable {
    int x;
    int y;
    String Direct = "up";
    boolean live = true;
    int speed = 35;

    public Shot(int x, int y, String direct) {
        this.x = x;
        this.y = y;
        this.Direct = direct;

    }

    @Override
    public void run() {
        //System.out.println("子弹移动线程启动~~~");

        while (true) {
            try {
            Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (Direct) {
                case "up":
                    y -= speed;
                    break;
                case "down":
                    y += speed;
                    break;
                case "left":
                    x -= speed;
                    break;
                case "right":
                    x += speed;
                    break;
            }
            //这里是子弹遇到游戏边界后才退出线程（后面优化）
            //子弹将敌人坦克打爆以后，子弹就要立即消失
            if (!(x >= 0 && x <= 750 && y >= 0 && y <= 750&&live)) {
                live = false;
                System.out.println("子弹移动线程退出~~");
                break;
            }
            System.out.println("子弹 x= " + x + " y=" + y);
        }
    }
}
