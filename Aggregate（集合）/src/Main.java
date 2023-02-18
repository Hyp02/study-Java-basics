import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

@SuppressWarnings({"all"})
public class Main {


    public static void main(String[] args) {
	// write your code here
        //创建集合对象
        Collection col = new ArrayList();
        //使用集合中的add方法将每一本书加起来
        col.add(new Book("西游记","罗贯中",30));
        col.add(new Book("红楼梦","曹雪芹",23));
        col.add(new Book("线性代数","数学教授",32));
        System.out.println(col);//全部一次性输出

        //下面使用迭代器遍历输出
        //快捷键输出迭代器循环 itit或者 ctrl+j

        Iterator iterator = col.iterator();//先将游标初始化
        while (iterator.hasNext()) {//循环条件是集合的下一个元素不是空
            Object book =  iterator.next();//这时将游标指向要拿出的数据，并将它赋给book
            System.out.println("书本："+book);
        }
        System.out.println("第二次使用迭代器遍历的集合");
        Iterator iterator2 = col.iterator();//在第二次遍历的话 “游标需要初始化”
        while(iterator2.hasNext()){
            Object book2 = iterator2.next();
            System.out.println("book2"+book2);
        }
    }
}
class Book{
    private String BookName;
    private String author;
    private double price;

    public Book(String bookName, String author, double price) {
        BookName = bookName;
        this.author = author;
        this.price = price;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookName='" + BookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
class add{
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
            System.out.println(arrayList);
        }
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        vector.add(0);
    }

}
