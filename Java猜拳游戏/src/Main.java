import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Computer p = new Computer();
        p.gess();
    }
}
class Computer{
    public void gess(){
        Random num = new Random();
        int pcnt = 0;
        int ccnt = 0;
        Scanner myscanner = new Scanner(System.in);
        while(ccnt < 2&&pcnt < 2){
            System.out.println("输入您要出的拳");
            int pom = myscanner.nextInt();
            if(pom < 3){
                int com = num.nextInt(3);
                if((com == 0&&pom == 1)||(com == 1&&pom == 2)
                        ||(com == 2&&pom == 0)){//电脑赢，人剪刀
                    ccnt++;
                }
                if((com == 1&&pom == 0)||(com == 0&&pom == 2)
                        ||(com ==2&&pom == 1)){
                    pcnt++;
                }
                show(pom,com,ccnt,pcnt);
            }else{
                System.out.println("您的输入有误，重新输入");
            }

        }
    }
    public void show(int pom,int com,int ccnt,int pcnt ){
        System.out.println("=======出拳=========5=====输赢总数");
        System.out.println("tom  "+pom+" =========   "+pcnt);
        System.out.println("电脑  "+com+" =========      "+ccnt);
        if(ccnt > pcnt){
            System.out.println("  电脑胜利 ！！！");
        }else if(ccnt != pcnt){
            System.out.println("  tom胜利 ！！！ ");
        }else{
            System.out.println("平局");
        }

    }

}