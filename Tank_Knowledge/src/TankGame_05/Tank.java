package TankGame_05;

public class Tank {
    private int x;//坐标
    private int y;
    private String direct = "up";
    private int SelfQuantity ;
    private int enemyQuantity;
    private int Speed;


    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        this.Speed = speed;
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
        y-= Speed;

    }
    public void down(){
        y+= Speed;

    }
    public void left(){
        x-= Speed;

    }
    public void right(){
        x+= Speed;
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
