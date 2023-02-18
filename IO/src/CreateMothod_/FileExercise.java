package CreateMothod_;



import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileExercise {
    public static void main(String[] args) {

    }
    @Test
    public void create01(){
        String filePath = "E:\\";
        String fileName = "hello1.txt";
        File file = new File(filePath, fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            System.out.println("创建失败");
            e.printStackTrace();
        }
    }
    @Test
    public void create02(){
//        String filePath = "E:\\";
//        String fileName = "hell.txt";
        File file = new File("E:\\hello2.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            System.out.println("创建失败");
            e.printStackTrace();
        }
    }
    @Test
    public void create03(){
        //String filePath = "E:\\";
        File file1 = new File("E:\\");
        String fileName = "hello3.txt";
        File file = new File(file1, fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            System.out.println("创建失败");
            e.printStackTrace();
        }
    }
}
