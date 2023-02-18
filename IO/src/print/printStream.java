package print;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class printStream {
    public static void main(String[] args) throws IOException {
        //默认位置是控制台
        PrintStream out = System.out;
        out.println("打印到控制台");
        out.write("打印到控制台方法2".getBytes());
        out.close();
        //改变打印位置，使用System.setOut（PrintStream）方法改变位置
        System.setOut(new PrintStream("E:\\printStream.txt"));
        System.out.println("打印到文件");
        System.out.write("打印到文件方法2".getBytes());
        out.close();
//        PrintStream printStream1 = new PrintStream(System.out);
//        printStream1.write("输出到控制台".getBytes());
//        printStream1.close();
//        String filePath = "E:\\printStream.txt";
//
//        PrintStream printStream2 = new PrintStream(new FileOutputStream(filePath));
//        printStream2.write("使用字节打印流输出到\"E:\\\\printStream.txt\"".getBytes());
//        printStream2.close();
//
//        System.out.println("你好控制台");
//        PrintStream out = System.out;
//        out.println("你好控制台");
//        out.close();
//        System.setOut(printStream2);
//
//        out.println("你好文件夹");
//        out.close();

    }
}
