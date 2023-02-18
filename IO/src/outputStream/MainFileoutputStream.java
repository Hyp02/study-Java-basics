package outputStream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainFileoutputStream {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() {
        FileOutputStream fileOutputStream = null;
        String path = "E:\\a.txt";
        try {
            //这个构造器写入的内容每次运行时会将文件中的原内容覆盖
            //fileOutputStream = new FileOutputStream(path);\
            //这个构造器是每次运行将要写入的内容加到源文件内容的后面
            fileOutputStream = new FileOutputStream(path,true);
            String s = "hello,world";
            //方法write（byte[],int off,int length）从字节数组索引off开始写入长度为length的内容
            fileOutputStream.write(s.getBytes(),0,3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
