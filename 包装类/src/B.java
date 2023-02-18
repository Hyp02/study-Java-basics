import java.util.Locale;

public class B {
    public static void main(String[] args) {
        //1、equals 方法 比较内容是否相同 区分大小写
        String str1 = "hello";
        String str2 = "Hello";
        System.out.println(str1.equals(str2));//F

        //2、equalsIgnoreCase  忽略大小写的判断内容是否相同
        String username = "HHH";
        String name = "hhh";
        System.out.println(username.equalsIgnoreCase(name));//T

        //3、length() 获取字符串字符的个数，字符串的长度
        System.out.println("qwer".length());

        //4\indexOf 获取字符在字符串对象中第一次出现的索引，索引从零开始。如果找不到返回-1；
        String s1 = "werterweg";
        System.out.println(s1.indexOf('#'));//-1
        System.out.println(s1.indexOf('r'));//2
        //5、lastIndexOf  获取字符在字符串对象中最后一次出现的索引。从零开始
        String s2 = "qweef";
        System.out.println(s2.lastIndexOf('e'));//3
        System.out.println(s2.lastIndexOf("we"));//1
        //6、substring 截取指定范围的字符串
        String ss = "hello.张三";
        //ss.substring(6),从索引6开始截取后面的字符串（包含6）
        System.out.println(ss.substring(6));
        //ss.substring(a,b),表示从索引a开始截取（包含a），截取到索引b-a的位置（不包含b-a）
        //就是截取[a,b)集合范围内的字符串
        System.out.println(ss.substring(1,3));//el

        //toUpperCase()将字符串中的字符全部转换为大写
        String a = "Hello";
        System.out.println(a.toUpperCase());//HELLO
        //toLowerCase()将字符串中的字母全部转换为小写
        String b = "UIUI";
        System.out.println(b.toLowerCase());//uiui
        //concat（）拼接字符串
        String c = "你好";
        c = c.concat("李焕英").concat("的朋友");
        System.out.println(c);
        //replace（）将字符串中的字符或字符串替换为指定字符（字符串）
        String d = "宝玉 and 林黛玉 林黛玉 林黛玉";
        d= d.replace("林黛玉","宝玉");
        d = d.replace('a','h');
        System.out.println(d);//宝玉 hnd 宝玉 宝玉 宝玉
        /**
         * 注意：
         * d.replace()执行后的返回结果才是替换过的，对原本字符串没有任何影响
         */
        //split  分割字符串。，对于某些字符我们需要转义
        String f = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        String []ff = f.split(",");
        for (int i = 0; i < ff.length; i++) {
            System.out.println(ff[i]);
        }
        f = "E\\aaa\\bbb";
        ff = f.split("\\\\");
        for (int i = 0; i < ff.length; i++) {
            System.out.println(ff[i]);
        }
        //toCharArray() 转换成字符数组
        f = "happy";
        char []cc = f.toCharArray();
        for(char i : cc){//增强for
            System.out.println(i);
        }
        //compareTo 比较两个字符串的大小，
        // 如果前者大 返回正数 后者大 返回负数 相等返回0‘
        //Ctrl + B 看源码；
        String q = "jac";//len = 3；
        String w = "jack";//len = 4
        System.out.println(q.compareTo(w));//-1;
    }


}
