package ReaderText_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Text {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_ = new BufferedReader_(new StringReader_());
        bufferedReader_.StringReader_();
        BufferedReader bufferedReader = null;
        int i =0;
        try {
            bufferedReader = new BufferedReader(new FileReader("E:\\a.txt"));
            while((i=bufferedReader.read())!=-1){
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
