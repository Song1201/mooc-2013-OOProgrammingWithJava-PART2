package wordinspection;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        // test your code here

        File file = new File("src/wordList.txt");
        // all words are in file src/wordList.txt
        WordInspection a = new WordInspection(file);
        List<String> words = a.wordsContainingZ();
        System.out.println(words);

    }
}
