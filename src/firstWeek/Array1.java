package firstWeek;

import java.util.ArrayList;
import java.util.List;
/*
*  정수 123  문자열 123로 변화
* */
public class Array1 {


    public String int2Str(int input) {
        if(input ==0 ) {
            return 0+"";
        }
        return digitString(digitLIst(Math.abs(input)));
    }

    public List<Integer> digitLIst(int input) {
        List<Integer> list = new ArrayList<>();
        int remainder = input;

        while(remainder > 0 ) {
            int num = remainder%10;
            remainder = remainder/10;
            list.add(num);
        }
        return list;
    }

    public String digitString(List<Integer> list) {
        String digitString = "";
        for(int i =list.size()-1 ;  i >= 0 ; i--) {
            digitString += (list.get(i)+"");
        }
        return digitString;
    }
}
