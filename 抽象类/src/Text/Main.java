package Text;

public class Main {
    public static void main(String[] args) {
        Temp bb = new BB();//多态的向上转型
        Temp cc = new CC();
        bb.time();
        cc.time();

    }
}

/**
 * 模板设计模式
 * 计算程序运行时间
 */
abstract class Temp{//定义一个模板类
    public abstract void job();//抽象job方法，用于该类计算时间方法时调用
    // 不同子类可以重写job方法
    public void time(){//计算时间的方法
        /**
         * 这就是一个模板
         * 将工作方法放在时间开始和结束中间
         */
        long start = System.currentTimeMillis();
        job();//因多态的动态绑定机制，运行对象是谁就调用该对象的job方法
        long end = System.currentTimeMillis();
        System.out.println("执行时间"+(end - start));
    }

}
class BB extends Temp{
    @Override
    public void job(){//子类重写父类job方法
        long sum  = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
    }
}
class CC extends Temp{
    @Override
    public void job(){//子类重写父类job方法
        long sum = 0;
        for (int i = 0; i < 10000000; i++) {
            sum += i;
        }
    }
}