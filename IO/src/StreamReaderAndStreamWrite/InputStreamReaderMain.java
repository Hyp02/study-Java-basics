package StreamReaderAndStreamWrite;

import java.io.*;

/**
 * 解决文件编码问题
 * 使用字节输入流【FileInputStream（ ）】读取，
 * 然后传入转换流【InputStreamReader（）】中转换成字符流（Reader）
 * 使用处理流 【BufferedReader（）】将转换后的流传入构造器中
 * 使用相关方法输出
 */
public class InputStreamReaderMain {
    public static void main(String[] args) throws IOException {
        String path = "E:\\a.txt";
        //将文件以字节形式读取，使用InputStreamReader()转换流转换为 Reader（字符流）形式
        //此方法可以设置文件编码格式，设置成和保存文件时相同的编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "gbk");
        //将转换成字符流的 isr 对象传入 字符处理流中 使用相关方法输出
        BufferedReader bis = new BufferedReader(isr);
        String s = bis.readLine();
        System.out.println("转化过后的结果："+s);
        //关闭外层流即可
        bis.close();


    }
}
