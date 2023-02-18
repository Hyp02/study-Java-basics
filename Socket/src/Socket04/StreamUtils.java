package Socket04;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 将 文件转换成字节数组类型
 * 用一个字节数组将文件保存并返回
 * 将文件转换成字节数组
 */
public class StreamUtils {

    public static byte[] getByteArray(InputStream is) throws IOException {
        //创建字节数组转换流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int lean ;
        //将文件循环读取
        while((lean = is.read(bytes))!=-1){
            //保存到到数组
            baos.write(bytes,0,lean);
        }
        //将文件转换成字节数组
        byte[] arrayByte = baos.toByteArray();
        baos.close();
        return arrayByte;//返回保存好的字节数组
    }
}
