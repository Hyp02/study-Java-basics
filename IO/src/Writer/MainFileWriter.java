package Writer;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class MainFileWriter {
    public static void main(String[] args) {

    }

    @Test
    public void writer() {
        FileWriter fileWriter = null;
        String path = "E:\\story.txt";

        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(path, true);
            fileWriter.write("小故事");
            fileWriter.write(chars, 0, 1);
            fileWriter.write(chars);
            fileWriter.write("你好世界", 0, 2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
