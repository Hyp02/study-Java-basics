import javax.swing.*;
import java.awt.*;

public class Draw_ extends JFrame {
    //定义一个面板
    private Mypanel mp = null;

    public static void main(String[] args) {
        new Draw_();
    }

    public Draw_() {
        mp = new Mypanel();
        this.setSize(500, 466);
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


    }


}

@SuppressWarnings({"all"})
class Mypanel extends JPanel {
    int i = 0;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);

        //画一个圆
//        g .setColor(Color.BLUE);
//        g.drawOval(10, 10, 200, 200);
//        g.drawRect(10, 100, 100, 100);
        g.drawLine(120, 120, 0, 10);
//        g.fillOval(10, 109, 199, 200);
        g.setColor(Color.CYAN);
        g.fillRect(100, 100, 13, 55);
        g.fillRect(140, 100, 13, 55);
        g.setColor(Color.red);
        g.fillRect(108, 110, 36, 36);
        g.setColor(Color.BLUE);
        g.fillOval(108, 110, 36, 36);
//        Image image = Toolkit.getDefaultToolkit()
//                .getImage(Panel.class.getResource("/d.png"));
//        g.drawImage(image, 10, 10, 1368,361,this);
//        g.setColor(Color.blue);
//        g.setFont(new Font("楷体",Font.BOLD,60));
//        g.drawString("杜",100,100);
    }
}