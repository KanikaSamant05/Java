public class backtrackKeypad {
        // final keyword is used when there is fixed object here letters are fixed, final is not necessary to type it depicts there will be no change later in te program.
        final static char[][] keypad={
            // 0 index
            {},
            // 1 index
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
         };
         public static void letterCombinations(String givenString) {
            int len=givenString.length();
            if(len==0){
                System.out.println("null");
                return;
            }
            // pos determines index
            recursiveFunc(0, len, "", givenString);
         }
    
    public static void recursiveFunc(int pos, int len, String outputString, String givenString){
        if(pos==len){
            System.out.println(outputString);
        }else{;
            char[] letters=keypad[givenString.charAt(pos)-'0'];
            for(int i=0;i<letters.length;i++)
                recursiveFunc(pos+1, len, outputString+letters[i], givenString);
        }
    }

    public static void main(String args[]) {
        letterCombinations("237");
    }
}
