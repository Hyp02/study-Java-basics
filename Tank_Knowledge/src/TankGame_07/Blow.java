package TankGame_07;

public class Blow {
    //爆炸效果显示的地方（坐标）
    int x,y;

    //为炸弹提供爆炸的坦克的位置
    public Blow(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //定义爆炸效果的显示周期
    int left = 9;
    //生命存在与否
    boolean live = true;
    public void Bloow(){
        if(left>0){
            left--;
        }else{
            live = false;
        }
    }
}
