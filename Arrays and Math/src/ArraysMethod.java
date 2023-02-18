import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethod {
    public static void main(String[] args) {
        Book[] book = new Book[4];
        book[0] = new Book("红楼梦", 100);
        book[1] = new Book("西游记", 90);
        book[2] = new Book("青年文摘", 5);
        book[3] = new Book("java丛入门到放弃", 300);
        int[] arr = {1, 3, 5, -56, 45};
        Arrays.sort(arr);
        /**
         * 定制排序
         * 接口的匿名内部类返回的值是灵魂
         * return 的值决定了排序怎样进行
         */
        Arrayss.sort(book, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                double i1 = (double) o1;
                double i2 = (double) o2;
                return  (int)(i1 - i2);//这里决定了排怎么（从大到小还是……）
            }
        });
        System.out.println("=====排序后的数=====");
        for (int i = 0; i < book.length; i++) {
            System.out.println(book[i]);
        }


    }

    static class Arrayss {
        public static void sort(Book[] arr, Comparator comp) {
            Book temp = null;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    //按照书的价钱排
                    if (comp.compare(arr[j].getPrice(), arr[j + 1].getPrice()) > 0) {//这里将数组中的值
                        // 传递给上面的匿名内部类中，返回值来确排序怎样进行
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }

            }
        }
    }

}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}


