package BufferedInPutStream_;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;


public class MainBips {
    public static void main(String[] args) throws IOException {
        String path="E:\\a.txt";
        String newPath="E:\\a4.txt";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newPath,true));
        byte[] bytes = new byte[5];
        while((bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
