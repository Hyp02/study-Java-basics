package StreamReaderAndStreamWrite;

import java.io.*;

/**
 * 这里使用的BufferReader来读取文件
 * 文件中有中文，涉及到编码问题
 * 使用字符处理流读取不好
 * 优化===>>使用转换流InputStreamReader()/OutputStreamReader()
 */
public class codeQuestion {
    public static void main(String[] args) throws IOException {
        String path ="E:\\a.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String s = br.readLine();
        System.out.println("读取的内容是："+s);
        br.close();
    }
}
