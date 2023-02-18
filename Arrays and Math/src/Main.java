import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Date d = new Date(0);//创建日期对象

//格式化日期（这里的格式转换字母是规定好的 不能乱写）
        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
//将日期转换成字符串
        System.out.println(stf.format(d));
        String format = stf.format(d);
    }
}
