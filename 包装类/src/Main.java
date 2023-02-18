public class Main {

    public static void main(String[] args) {
        // write your code here
        //int转Integer
        int n1 = 100;
        //方法1(手动装箱)
        Integer integer = new Integer(n1);
        Integer integer2 = Integer.valueOf(n1);
        //手动拆箱
        int n2 = integer2.intValue();

        //在jdk5以后 自动装拆箱
        //自动装箱
        Integer i = n1;//Integer.valueOf(n1)
        //自动拆箱
        int n3 = i;//integer2.intValue();

        //将Integer 转成String
        Integer a = 10;
        String s = a + "";
        String s1 = String.valueOf(a);
        String s3 = a.toString();

        //String 转 Integer
        String str = "1234";
        Integer a2 = Integer.parseInt(str);
        Integer a3 = new Integer(str);


    }
}

class A {
    public static void main(String[] args) {
        String s = "jfdsl";
        String f = "fjlsdd";
        String c = s + f;
/**
 * 说明：intern方法
 *当调用intern方法时，如果池中已经包含一个等于次String对象的字符串（用equals（object）方法确定）
 * 则返回池中的字符串，否则，将String添加到池中，并返回此String对象的引用（地址）
 * j.intern()最终返回的是常量池中的地址（对象）
 */
        //a直接指向常量池中的“j”，
        String a = "j";
        //j先在堆中创建对象（其中有value[]属性）然后指向常量池中的字符串”j“
        String j = new String("j");
        //T 因为a直接指向常量池中的字符串，j.intern()返回的是常量池中的地址
        System.out.println(a == j.intern());
        //F 因为j指向的是堆中含有value[]数组的那个对象地址
        System.out.println(j == j.intern());
        // 而j.intern()返回的是常量池中字符串的地址

    }

}

class StringFlip {
    public static void main(String[] args) {
        String s = "wsdfkr";
        s = StringFlip.flip(s, 1, 5);
        System.out.println("s反转后=" + s);
    }

    private static String flip(String str, int start, int end) {
        char[] chars = str.toCharArray();//将传入的字符串转换成数组
        char temp = ' ';
        //将最后一个第一个对调
        // 第二个和倒数第二个对调
        //……
        //直到中间的那个，从头往后的标记不能去从后往前的标记后面
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);//返回一个新的字符串
    }
}
