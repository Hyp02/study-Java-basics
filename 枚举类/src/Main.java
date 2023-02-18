import java.time.DayOfWeek;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Week.show();
    }
}
enum Week {
    //定义几个枚举常量（有位置规定{从零开始拍序}）
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三");
    String Day;
    private Week(String Day) {
        this.Day  = Day;
    }
    public static void show(){
        //values（）方法  返回的是数组类型
        Week[] values = Week.values();
        for(Week day:values){//增强for,依次把枚举对象拿出 赋值给day
            System.out.println(day);
            //name（）方法  返回的是枚举对象的对象名（如：MONDAY.name().输出的是 MONDAY）
            System.out.println("name= "+day.name());
            //ordinal 方法返回当前对象的位置号(从零开始)
            System.out.println(day+"的位置在第 "+day.ordinal()+" 个");

        }
        //valueOf 方法 将字符串转换成枚举对象
        System.out.println("将MONDAY换成枚举对象"+valueOf("MONDAY"));
        //compareTo 方法 比较两个枚举常量，比较的是位置号
        // [返回的是位置号相减（调用方法的枚举常量-传入的方法的枚举常量）]
        System.out.println(WEDNESDAY.compareTo(MONDAY));
    }

    @Override
    public String toString() {//重写toString方法
        return Day;
    }
}