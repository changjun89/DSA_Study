package firstWeek;

public class ReverseSentence {
    private static final String SEPARATOR=" ";
    private String reverseStr = "";
    private String sentence;

    public ReverseSentence(String sentence) {
        this.sentence = sentence;
    }

    private int blankIdx() {
        return sentence.indexOf(SEPARATOR);
    }
    private boolean hasSeparator() {
        return sentence.length() > 0 && sentence.indexOf(SEPARATOR) > -1;
    }

    private String firstWord() {
        return sentence.substring(0, blankIdx());
    }
    private String removeFirstWord() {
        return sentence.substring(blankIdx()+1);
    }
    private String delLastSeparator() {
        return reverseStr.substring(0, reverseStr.length() - 1);
    }

    public String reverse() {
        while(hasSeparator()){
            reverseStr =firstWord()+SEPARATOR+reverseStr;
            sentence = removeFirstWord();
        }
        reverseStr = sentence +SEPARATOR+reverseStr;
        return delLastSeparator();
    }


}
