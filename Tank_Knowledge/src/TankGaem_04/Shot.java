package TankGaem_04;

public class Shot implements Runnable {
    int x;
    int y;
    String Direct = "up";
    boolean live = true;
    int speed = 15;

    public Shot(int x, int y, String direct) {
        this.x = x;
        this.y = y;
        this.Direct = direct;

    }

    @Override
    public void run() {
        System.out.println("子弹移动线程启动~~~");

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

            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 1000)) {
                live = false;
                System.out.println("子弹移动线程退出~~");
                break;
            }
            System.out.println("子弹 x= " + x + " y=" + y);
        }
    }
}
