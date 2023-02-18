package outputStream;



import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainCopy {
    public static void main(String[] args) {

    }

    @Test
    /**
     *将文件拷贝到指定位置；
     * **/
    public void copy() {
        //分别创建输入输出流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        //源文件路径和新文件路径
        String OldPath = "E:\\1.jpg";
        String NewPath = "E:\\2.pdf";
        //创建字节数组
        byte[] bytes = new byte[1024];
        int length = 0;
        try {
            fileInputStream = new FileInputStream(OldPath);
            fileOutputStream = new FileOutputStream(NewPath);
            //循环将原文件中的内容取出，并且用输出流方法输出到指定路径
            while ((length = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //如果两个文件都不为null
            //关闭这两个文件
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("拷贝成功");
        }
    }
}
