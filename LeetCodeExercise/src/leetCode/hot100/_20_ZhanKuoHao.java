package leetCode.hot100;

import java.util.Vector;

/**
 * LeetCode 上HOT100
 *  第二十题 有效的括号
 */
public class _20_ZhanKuoHao {
    public static void main(String[] args) {
        boolean judge = judge("((()");
        System.out.println(judge);
        Stack stack = new Stack(1000);
    }

    public static boolean judge(String s) {
        boolean b = false;
        Stack stack = new Stack(1000);
        int length = s.length();
        //如果括号的数量不配对的话，直接false
        if (length % 2 == 0) {
            //如果括号的数量符合规定
            char[] chars = s.toCharArray();//将输入的括号转换成char数组
            for (int i = 0; i < length; i++) {
                //遍历数组
                char c = chars[i];
                //如果是开口是左边的括号
                if(c=='('||c=='['||c=='{'){
                    //让他入栈
                    stack.putS(c);
                    //如果栈空间大小和字符串大小相同说明全都是开口向右的括号
                    if (stack.LengthS()==length){
                        return false;
                    }
                }else{//如果不是开口向右的括号
                    if (stack.LengthS()==0){
                        //如果栈的空间没有一个符号，说明第一个括号是开口向左的“ ）”
                        //这样的话不论怎么样都无法成功
                        return false;
                    }
                    String s3 = stack.pop();//取出栈顶元素
                    if (c==')'&&s3.equals('('+"")){//如果配对成功将元素赋值为true
                        b = true;
                    }
                    if (c==']'&&s3.equals('['+"")){
                        b = true;
                    }
                    if (c=='}'&&s3.equals('{'+"")){
                        b = true;
                    }
                }
            }
        } else {//数量不是双数
            return false;
        }
        if (stack.LengthS()!=0){//配对完成后，发现栈中还有元素说明开口向右的括号没有匹配
            //完，说明开口向右的括号多出来了
            b= false;//不成功
        }
        return b;
    }

}
//实现栈操作
class Stack {
    int max;
    int length;
    Vector vector = new Vector<Character>();
    char[] st = new char[max];
    char base;
    char top;

    //int size = vector.size();
    //可以限制空间大小的栈构造器
    public Stack(int max) {
        this.max = max;
    }

    public int LengthS() {
        return vector.size();
    }

    public void putS(char s) {
        //添加元素，并指定栈低和栈顶
        if (LengthS() < max) {
            vector.add(LengthS(), s);
            base = (char) vector.get(0);
        } else {
            System.out.println("栈空间已满~");
        }
    }

    public String pop() {
        //出栈，如果栈顶和栈低
        if (LengthS() == 0) {
            return "栈已空";
        } else {
            char top = (char) vector.get(LengthS() - 1);
            vector.remove(LengthS() - 1);
            return top + "";
        }
    }

}
