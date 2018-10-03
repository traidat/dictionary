import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class DictionaryCommandline {
    DictionaryManagement manager = new DictionaryManagement();
    public void showAllWords(){
        Set<String> keySet = manager.dictionary.map.keySet();
        for (String i : keySet){
            System.out.println(i + "\t\t" + manager.dictionary.map.get(i));
        }
    }

    public void dictionarySearcher() {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int n = s.length();
        Set<String> keySet = manager.dictionary.map.keySet();
        for (String i : keySet) {
            if (i.length() >= n)
                if (s.equals(i.substring(0,n))) {
                System.out.println(i);
            }
        }
    }

    public void dictionaryBasic() {
        manager.insertFromFile();
        showAllWords();
        Scanner input = new Scanner(System.in);
        String s = input.next();
        manager.dictionaryLookup(s);
    }

    public static void main(String[] args) {

            DictionaryCommandline Command = new DictionaryCommandline();
            Command.dictionaryBasic();
            Command.dictionarySearcher();
            Command.manager.insertFromCommandline();

    }
}
