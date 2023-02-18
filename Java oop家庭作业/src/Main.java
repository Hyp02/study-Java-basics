import java.util.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        A01 p1 = new A01();
        double []DoubleArray = {1.3,4.6,3.7,25.7};
        double maxnum = p1.max(DoubleArray);
        System.out.println("maxnum = "+ maxnum);
        String []StArray = {"你好","韩永鹏","崔秀锐","韩顺平"};
        A02 p2 = new A02();
        Scanner myscanner = new Scanner(System.in);
        String st;
        System.out.println("请输入你要找的字符串");
        st = myscanner.next();
        int StId = p2.find(StArray,st);
        System.out.println("你查找的字符串是："+ st+"在数组的索引是"+ StId);
        System.out.println("=======更改书的价钱=====");
        book p3 = new book();
        System.out.println("请输入书本更改前的价格");
        int price = myscanner.nextInt();
        int Afterprice = p3.updatePrice(price);
        System.out.println("书本价钱更改后的价钱是"+ Afterprice);

        System.out.println("======复制数组=====");
        int []arr = {1,4,456,543};
        A03 p4 = new A03();
        p4.copyarr(arr);
        //园
        Circle p5 = new Circle(5);
        p5.Clong();
        //狗的信息
        System.out.println("====狗的信息====");
        Dog p6 = new Dog();
        p6.show();
        passObject p7 = new passObject();
        Circle02 p8 = new Circle02();
        p7.printAreas(p8,5);

    }
}
class A01{
    public double max(double []arr){
        double max;
        max = arr[0];
        for(int i = 0; i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
class A02{
    public int find(String []arr1,String st){
        int id= 0;
        for(int i= 0;i < arr1.length;i++){
            if(st.equals(arr1[i])){
                System.out.println("你查找的字符串是："+ st+"在数组的索引是"+ id);
            }else{
                id = -1;
            }
        }
        return id;
    }
}
class book{
    public int updatePrice(int price){
        int AfterPrice = 0;
        if(price > 150 ){
            AfterPrice = 100;
        }else if(price > 100){
            AfterPrice = 100;
        }else{
            AfterPrice = price;
        }
        return AfterPrice;
    }
}
class A03{
    public void copyarr(int []arr){
        int []arr1 = new int [arr.length];
        for(int i = 0;i < arr.length;i++){
            arr1[i] = arr[i];
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }
}
class Circle{
    double r;
    public Circle(double r){
        this.r = r;
    }
    public void Clong(){
        double C = 2*r*3.14;
        System.out.println("半径是"+ r+"的周长是"+C);
    }
}
class Dog{
    String name = "王嘉豪";
    int age = 20;
    String color = "黑色";
    public void show(){

        System.out.println(name + age +color);
    }

}
class Circle02{
    double r;
    public double findArea(){
        return 3.14*r*r;
    }
}
class passObject{
    public void printAreas(Circle02 c,int times){
        Circle02 p = new Circle02();
        System.out.println("Radius         Area");
        for(int i =1; i <= times;i++ ){
            p.r = i;

            System.out.print(i + "              " + p.findArea());
            System.out.println();
        }
    }
}