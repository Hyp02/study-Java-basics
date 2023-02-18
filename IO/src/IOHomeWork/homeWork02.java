package IOHomeWork;

import java.io.*;

/**
 *按行 读取文件
 *给每一行加上标记行号
 * 为了防止乱码，利用转换流设定输出的编码
 */
public class homeWork02 {
    public static void main(String[] args) throws IOException {
        //利用转换流将Stream流转换成Reader流
        InputStreamReader Isr = new InputStreamReader(
                new FileInputStream("E:\\a.txt" ),"gbk");
        BufferedReader bufferedReader = new BufferedReader(Isr);
        String s;
        int i = 1;//记录行号
        //按照行将文本输出
        while((s=bufferedReader.readLine())!=null){
            System.out.printf("这是%d行的内容  %s\n",i,s);
            i++;
        }
        bufferedReader.close();


    }

}
