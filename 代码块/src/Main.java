//父静->子静->（父普->父构）->（子普->子构）
public class Main {

    public static void main(String[] args) {
	// write your code here
        Movie movie = new Movie();
        Movie.show();//不创建父类对象，直接使用类名调用类中的静态成员（方法）父类的普通代码块不会被调用
        movie.shows();
        //我想应该是因为普通代码是每创建一个对象就会被调用一次，
        // 而静态成员可以直接使用类名调用，没有创建对象所以普通代码块不会被调用
      //  Movie movie1 = new Movie();
        B b = new B();//创建子类对象时，父类的普通代码块也会被调用
        B.hello();
        b.hi();
    }
}
class Movie{

    //普通代码块，每创建一个对象调用一次(调用顺序按照代码的书写顺序)
    //
    {
        System.out.println("这是父类中第一个普通代码块===");

    }
    //静态代码块，只在类加载时调用一次
    // （静态代码快优先于普通代码块，但同为静态代码快时，按照代码书写顺序调用
    // （运行完父类中调用的方法后再加载子类中的普通代码块））
    static{
        System.out.println("===这是父类中第二个静态代码块===");

    }
    static {
        System.out.println("===这是父类中第一个静态代码块===");
    }
    public static void  show(){
        System.out.println("电影开始（父类中的静态方法~~）被调用");
    }
    public  Movie() {
        System.out.println("Movie构造器被调用~~");
    }
    public void shows(){
        System.out.println("这是父类的普通方法");
    }
}
class B extends Movie{

    static {//子类中静态代码块的调用顺序优先于父类中的普通代码块，
        // （总结：先调用完父类和子类中的所有静态代码块，再调用父类中普通代码块，后调用子类中的普通代码块）
        System.out.println("子类中第一个静态代码块被调用~~~");
    }
    static {
        System.out.println("子类中第二个静态代码块被调用~~~");
    }

    {
        System.out.println("子类中的普通代码块");
    }
    public B() {
        System.out.println("子类的构造器被调用~~");
    }
    public void hi(){
        System.out.println("这是子类的普通方法");
    }
    public static void hello(){
        System.out.println("这是子类中的静态方法");
    }
}