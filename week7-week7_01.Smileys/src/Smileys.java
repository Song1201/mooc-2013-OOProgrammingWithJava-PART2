
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String s) {
        String SMILEY = ":)";
        if(s.length()%2==1) s += " ";
        int numSmiley = s.length()/2 + 3;
        printNStrings(numSmiley, SMILEY);
        System.out.println("");
        System.out.println(SMILEY+" "+s+" "+SMILEY);
        printNStrings(numSmiley, SMILEY);
        System.out.println("");    
    }
    
    private static void printNStrings(int n, String s) {
            for(int i = 0; i<n;i++) {
                System.out.print(s);
        }
    }

}
