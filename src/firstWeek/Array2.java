package firstWeek;

import java.util.ArrayList;
import java.util.List;

/*
 *  "I am a boy"  문자열을 "boy a am I" 로 변환
 * */
public class Array2 {

    public String reverseStr(String input) {
        List<String> list = new ArrayList<>();
        String reverseStr = "";
        String centence = input;

        while (centence.length() > 0 && centence.indexOf(" ") > -1) {
            int idx = centence.indexOf(" ");
            String word = centence.substring(0, idx);
            centence = centence.substring(idx + 1);
            reverseStr = word + " " + reverseStr;
        }
        reverseStr = centence + " " + reverseStr;


        return reverseStr.substring(0, reverseStr.length() - 1);
    }

}
