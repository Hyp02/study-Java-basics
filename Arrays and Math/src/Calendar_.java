import java.util.Calendar;
public class Calendar_{
    public static void main(String[] args) {
        /*
          Calendar是一个抽象类，并且构造器是private的
          可以通过getInstance来获取实例
          提供大量方法和字段给程序员
          Calendar没有提供对应格式化的类。需要程序员自己来组合
         */
        Calendar c = Calendar.getInstance();
        System.out.println("c="+c);
        System.out.println("年="+c.get(Calendar.YEAR));
        //这里加一是因为月份是从零开始返回的
        System.out.println("月="+(c.get(Calendar.MONTH)+1));
        System.out.println("日"+c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时"+c.get(Calendar.HOUR));
        System.out.println("分钟"+c.get(Calendar.MINUTE));
        System.out.println("秒"+c.get(Calendar.SECOND));

    }

}
