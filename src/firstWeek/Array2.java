package firstWeek;

/*
 *  "I am a boy"  문자열을 "boy a am I" 로 변환
 * */
public class Array2 {

    public String reverseStr(String input) {
        ReverseSentence sm = new ReverseSentence(input);
        return sm.reverse();
    }

}
