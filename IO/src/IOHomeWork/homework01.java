package IOHomeWork;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class homework01 {
    public static void main(String[] args) throws IOException {
        judgeFileLive();
    }

    public static void judgeFileLive() throws IOException {
        String File = "E:\\MyTemp";
        File file =new File(File);
        if(file.exists()){
            System.out.println("文件已经存在~~");
        }else{

            if (file.mkdirs()) {
                System.out.println("创建成功~~");
            } else {
                System.out.println("创建失败~~");
            }
        }
        String filePath = File+"\\hello.txt";
        file = new File(filePath);
        if(!file.exists()){
            if(file.createNewFile()){
                System.out.println("创建成功");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
                bufferedWriter.write("你好~~~");
                bufferedWriter.close();
            }else{
                System.out.println("创建失败");
            }

        }else{
            System.out.println("文件已经存在");
        }

    }

}
