package InputStream;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileInputStream {
    public static void main(String[] args) {

    }

    /**
     * 用字节流进行文件的读取
     * 效率低
     */
    public void readFile01() {
        FileInputStream fileInputStream = null;
        String fileName = "E:\\hello1.txt";
        int i = 0;
        try {
            fileInputStream = new FileInputStream(fileName);
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 优化
     * 使用字节数组进行存入read（byte []）方法读取的字节流
     */
    public void readFile02() {
        FileInputStream fileInputStream = null;
        String fileName = "E:\\hello1.txt";//要操作的文件的路径和名称
        byte[] bytes = new byte[8];//创建大小为8的字节数组
        int length;
        //int i = 0;
        try {
            //创建文件输入流对象，用于操作文件
            fileInputStream = new FileInputStream(fileName);

            //从该输入流读取最多b.length字节的数 据到字节数组。
            //读入缓冲区的总字节数，如果没有更多的数据，因为文件的结尾已经到达， -1
            while ((length = fileInputStream.read(bytes)) != -1){
                //将字节数组转换成string
                String s = new String(bytes, 0, length);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
