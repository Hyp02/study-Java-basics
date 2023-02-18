package TankGame_07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * 用来保存上局游戏活着的坦克
 * 坐标
 * 数量
 */
public class Node {


    private  int x;
    private  int y;
    private  String direct;

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

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public Node(int x, int y, String direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }
}
