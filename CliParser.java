import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class CliParser {
    public static void main(String[] args) {

        // Takes the cli argument and creates a simple string
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]);
            sb.append(" ");
        }
         
        String input = sb.toString();
     
        HashMap < String, ArrayList < Object >> dictionary = new HashMap < > ();
        ArrayList < String > arrayConsec = new ArrayList < String > ();
        ArrayList < String > array = new ArrayList < String > ();


        // The matcher uses the patterns to check if the input contains consecutive words or single words
        Pattern p = Pattern.compile("[a-zA-Z0-9]+(|(,)) [a-zA-Z0-9]+");
        Pattern p2 = Pattern.compile("[a-zA-Z0-9]+");
        Pattern p3 = Pattern.compile("(-)([a-zA-Z0-9]+)((, -)|(])|( -| +$))");


        Matcher m = p.matcher(input);
        Matcher m3 = p3.matcher(input);


        // If it finds a match then it adds it in the array of consecutive words or in the array of single words

        while (m.find()) {
            arrayConsec.add(m.group());
        }
        while (m3.find()) {
            array.add(m3.group());
        }


        /* Extracts the words of both arrays and add them to the dictionary
           Before it adds them to the dictionary it checks if the key has already been used, if yes it will add the value to the list if not
           it will create a new list */

        ArrayList < Object > list;

        for (String word: array) {

            Matcher m4 = p2.matcher(word);

            if (m4.find()) {

                if (dictionary.containsKey(m4.group())) {
                    list = dictionary.get(m4.group());
                    list.add(true);
                } else {
                    list = new ArrayList < Object > ();
                    list.add(true);
                    dictionary.put(m4.group(), list);
                }
            }
        }


        for (String word: arrayConsec) {

            Matcher m4 = p2.matcher(word);

            if (m4.find()) {

                String[] parts = word.split("(|(,)) ");

                if (dictionary.containsKey(m4.group())) {
                    list = dictionary.get(m4.group());
                    list.add(parts[1]);
                } else {
                    list = new ArrayList < Object > ();
                    list.add(parts[1]);
                    dictionary.put(parts[0], list);
                }
            }
        }

        // Prints the result
        System.out.println(dictionary);

    }
}