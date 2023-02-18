public class Main {

    public static void main(String[] args) {
	// write your code here
            int age = 180;

            if(!(age>=18&&age<=120)){
                throw new AagException("输入的年龄不在范围内（18~120）");
            }
            System.out.println("年龄输入正确");
        }
}
//一般情况下，继承RuntimeException，
//把自定义异常做成运行时异常。因为这样可以使用默认的处理机制，比较方便
class AagException extends RuntimeException {//自定义异常，继承运行时异常
    public AagException(String message) {
        super(message);
    }
}