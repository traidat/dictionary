import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Words {
    public String word_target, word_explain;

}

class Dictionary {
    HashMap<String, String> map = new HashMap<String, String>();
}

public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();

    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);

        int numberWord = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < numberWord; i++){
            Words word = new Words();
            word.word_target = scanner.next();
            word.word_explain = scanner.next();
            dictionaryExportToFile(word.word_target + "\t" + word.word_explain + "\n");
            dictionary.map.put(word.word_target, word.word_explain);
        }
    }
    public void insertFromFile() {
        try{
            FileReader fr = new FileReader("dictionaries.txt");
            BufferedReader read = new BufferedReader(fr);
            String line = new String();
            String[] split = new String[2];

            while((line = read.readLine()) != null){
                Words words = new Words();
                split = line.split("\\s",2);
                words.word_target = split[0];
                words.word_explain = split[1];
                dictionary.map.put(words.word_target, words.word_explain);
            }
            read.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void dictionaryLookup(String s) {
        Set<String> keySet = dictionary.map.keySet();
        for(String i : keySet){
            if(s.equals(i)){
                System.out.println(i + "\t" + dictionary.map.get(i));
                break;
            }
        }
    }

    public void dictionaryExportToFile(String s) {
        File file = new File("dictionaries.txt");
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
