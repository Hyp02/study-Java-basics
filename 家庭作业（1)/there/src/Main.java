public class Main {

    public static void main(String[] args) {
        // write your code here
        new A().f1();//创建外部类对象，并调用f1方法

    }
}

class A {
    int[] arr = new int[26];
    private String name = "A";
    public void f1(){

        class B {//在外部类的方法中是局部内部类
            private String name = "B";
            public void show() {
                System.out.println("B name = " + name + " \nA name = " + A.this.name);
            }
        }
        B b = new B();//创建局部内部类对象
        b.show();//调用局部内部类中的show方法
    }

}
