package firstWeek;

public class ReverseSentence {
    private static final String SEPARATOR = " ";
    private String reverseStr = "";
    private String sentence;

    public ReverseSentence(String sentence) {
        this.sentence = sentence;
    }

    private int blankIndex() {
        return sentence.indexOf(SEPARATOR);
    }

    private boolean hasSeparator() {
        return sentence.length() > 0 && blankIndex() > -1;
    }

    private boolean hasSeparator(int blankIndex) {
        return sentence.length() > 0 && blankIndex > -1;
    }

    private String firstWord() {
        return sentence.substring(0, blankIndex());
    }

    private String firstWord(int blankIndex) {
        return sentence.substring(0, blankIndex);
    }

    private String removeFirstWord() {
        return sentence.substring(blankIndex() + 1);
    }

    private String removeFirstWord(int blankIndex) {
        return sentence.substring(blankIndex + 1);
    }

    private String delLastSeparator() {
        return reverseStr.substring(0, reverseStr.length() - 1);
    }

    public String reverse() {
        int blankIndex = blankIndex();
        while (hasSeparator(blankIndex)) {
            reverseStr = firstWord(blankIndex) + SEPARATOR + reverseStr;
            sentence = removeFirstWord(blankIndex);
            blankIndex = blankIndex();
        }
        reverseStr = sentence + SEPARATOR + reverseStr;
        return delLastSeparator();
    }


}
