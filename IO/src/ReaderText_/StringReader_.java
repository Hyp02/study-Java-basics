package ReaderText_;

import org.junit.jupiter.api.Test;

public class StringReader_ extends Reader_ {
    int x = 1;
    @Test
    @Override
    public void StringReader_() {

        String s = "jfjls";
        s.concat(s);
        s.substring(0,1);
        int j = Math.floorMod(-3,4);
        System.out.printf("读取字符串 j = %d",j);
    }
}

