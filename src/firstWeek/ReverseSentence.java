package firstWeek;

public class ReverseSentence {
    private static final String SEPARATOR=" ";
    private String reverseStr = "";
    private String centence ;

    public ReverseSentence(String centence) {
        this.centence = centence;
    }

    private int blankIdx() {
        return centence.indexOf(SEPARATOR);
    }
    private boolean hasSeparator() {
        return centence.length() > 0 && centence.indexOf(SEPARATOR) > -1;
    }

    private String firstWord() {
        return centence.substring(0, blankIdx());
    }
    private String removeFirstWord() {
        return centence.substring(blankIdx()+1);
    }
    private String delLastSeparator() {
        return reverseStr.substring(0, reverseStr.length() - 1);
    }

    public String reverse() {
        while(hasSeparator()){
            reverseStr =firstWord()+SEPARATOR+reverseStr;
            centence= removeFirstWord();
        }
        reverseStr =centence+SEPARATOR+reverseStr;
        return delLastSeparator();
    }


}
