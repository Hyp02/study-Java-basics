import com.NotePad;
import com.PC;
import com.computer;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("=====商品管理系统======");
        System.out.println("请输入密码查看商品信息");
        System.out.println("=======computer信息=====");
        computer computer = new computer("sds", 10, 100);
        System.out.println(computer.getDetals());
        System.out.println("=======PC信息========");
        PC pc = new PC("M1", 16, 100, "apple");
        pc.showPC();
        System.out.println("=====平板信息=====");
        NotePad notePad = new NotePad("平板cpu", 16, 100, "黑色");
        notePad.showNotePad();
    }
}
