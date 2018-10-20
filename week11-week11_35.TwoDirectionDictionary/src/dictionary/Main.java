package dictionary;

public class Main {
    public static void main(String[] args) {
        // Test your dictionary here
        MindfulDictionary s = new MindfulDictionary("src/words.txt");
        System.out.println(s.load());
    }
}
