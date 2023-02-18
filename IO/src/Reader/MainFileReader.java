package Reader;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class MainFileReader {
    public static void main(String[] args) {

    }

    @Test
    public void reader() {
        //字符输入流
        FileReader fileReader = null;
        //规定访问流的地址
        String filePath = "E:\\a.txt";
        int i =0;
        //创建字符数组
        char[] chars = new char[1024];
        int length = 0;
        try {
            fileReader = new FileReader(filePath);
            //两种获取方式<< 单个字符访问 >>
//            while((i=fileReader.read()) != -1) {
//                System.out.println((char) i);
//            }
            //<< 字符数组访问 >>
            while((length = fileReader.read(chars)) != -1) {
                String  s = new String(chars,0, length);
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
