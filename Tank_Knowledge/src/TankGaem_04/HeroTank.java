package TankGaem_04;

public class HeroTank extends Tank {
    Shot shot;
    public HeroTank(int x, int y) {
        super(x, y);
    }
    public void TankShot(){

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
        new Thread(shot).start();
    }
}
