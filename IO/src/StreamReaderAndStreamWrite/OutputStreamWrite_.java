package StreamReaderAndStreamWrite;

import java.io.*;

public class OutputStreamWrite_ {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\code.txt";
        File file = new File(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),"UTF8");
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        if(file.createNewFile()){
            System.out.println("文件本身不存在，创建新文件并将“你好”加入文件中");
            bw.write("你好");
        }
        bw.close();
    }

}
