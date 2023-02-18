package print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 打印流
 * 打印流只有输出流没有输入流
 */
public class printWrite {
    public static void main(String[] args) throws IOException {

        //默认输出到控制台
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.write("输出到控制台");
        printWriter.close();
        String filePath = "E:\\printWrite.txt";
        //改变输出位置
        PrintWriter pW = new PrintWriter(new FileWriter(filePath));
        pW.write("这是使用输出流输出到文件中的");
        //
        pW.close();
    }
}