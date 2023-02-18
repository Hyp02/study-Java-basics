package TankGame_02;

public class Tank {
    private int x;//坐标
    private int y;
    private String direct = "up";
    private int SelfQuantity ;
    private int enemyQuantity;
    private int selfSpeed;
    private int enemySpeed;

    public int getSelfSpeed() {
        return selfSpeed;
    }

    public void setSelfSpeed(int selfSpeed) {
        this.selfSpeed = selfSpeed;
    }

    public int getEnemySpeed() {
        return enemySpeed;
    }

    public void setEnemySpeed(int enemySpeed) {
        this.enemySpeed = enemySpeed;
    }

    public int getSelfQuantity() {
        return SelfQuantity;
    }

    public void setSelfQuantity(int selfQuantity) {
        SelfQuantity = selfQuantity;
    }

    public int getEnemyQuantity() {
        return enemyQuantity;
    }

    public void setEnemyQuantity(int enemyQuantity) {
        this.enemyQuantity = enemyQuantity;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }
    public String getDirect() {
        return direct;
    }


    //控制坦克走动的方向
    public void up(){
        y-=selfSpeed;
    }
    public void down(){
        y+=selfSpeed;
    }
    public void left(){
        x-=selfSpeed;
    }
    public void right(){
        x+=selfSpeed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

}
