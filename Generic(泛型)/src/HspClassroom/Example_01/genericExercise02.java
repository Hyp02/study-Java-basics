package HspClassroom.Example_01;

import java.util.ArrayList;
import java.util.List;

public class genericExercise02 {
    public static void main(String[] args) {
        ArrayList<Object> List1 = new ArrayList();
        ArrayList<String> List2 = new ArrayList();
        ArrayList<AA> List3 = new ArrayList();
        ArrayList<BB> List4 = new ArrayList();
        ArrayList<CC> List5 = new ArrayList();
        ArrayList<Object> List6 = new ArrayList();

        printCollection1(List1);
        //printCollection2(List2);//错误，因为List2的泛型是String，此方法需要AA或AA的子类


    }

    //编写几个方法
    //说明：List<?>表示 泛型可以是任意类型
    public static void printCollection1(List<?> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

    // ? extends AA表示上限，可接收AA或者AA的子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object o : c) {
            System.out.println(o);
        }

    }
    // ? super AA 说明：AA是表示下限，接受的类型可以是AA和AA的父类
    // （可以是但不限制是AA的直接父类）

    public static void printCollection3(List<? super AA> c) {
        for (Object o : c) {
            for (Object o1 : c) {
                System.out.println(o);
            }

        }

    }
}

class AA {
    public void m() {
        System.out.println("jfskl");
    }
}

class BB extends AA {

}

class CC extends BB {

}
