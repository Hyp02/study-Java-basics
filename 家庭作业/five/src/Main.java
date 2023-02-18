public class Main {

    public static void main(String[] args) {
        // write your code here
        Color.SwitchShow();
    }
}

interface IA {
    void show();
}

enum Color implements IA {
    RED(255, 0, 0), BLUE(0, 0, 255), BLACK(0, 0, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0);
    int redValue, greenValue, blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(toString());
    }
    public static void SwitchShow(){
        Color[] values = Color.values();
        for (Color color : values) {
            switch (color) {
                case RED:
                    color.show();
                    System.out.println("匹配到红色");
                    break;
                case BLUE:
                    color.show();
                    System.out.println("匹配到蓝色");
                    break;
                case YELLOW:
                    color.show();
                    System.out.println("匹配到黄色");
                    break;
                case BLACK:
                    color.show();
                    System.out.println("匹配到黑色");
                    break;
                case GREEN:
                    color.show();
                    System.out.println("匹配到绿色");
                    break;
                default:
                    System.out.println("MULL");
                    break;
            }
        }
    }

    @Override
    public String toString() {

        return "颜色数字为"+redValue + ","
                + greenValue + ","
                + blueValue;
    }
}
