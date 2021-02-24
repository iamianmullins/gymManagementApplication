import java.util.Scanner;
import java.util.HashSet;

/**
 * @InputReader class
 * Responsible for reading in user input and returning hashset of Strings
 */
public class InputReader {
    private Scanner input;

    /**
     * InputReader constructor
     * takes no parameters, initialises new input variable of type Scanner
     */
    public InputReader() {
        input = new Scanner(System.in);
    }

    /**
     * getInput method prompts the user to input some text
     * trims user input and formats to lower case
     * input String is then split at each space and each words is stored in a primitive array
     * each word in the primitive array of Strings is then stored in a hashset of Strings, eliminating duplicate values
     * method then returns HashSet of Strings
     *
     * @return HashSet of strings derived from user input
     */
    public HashSet<String> getInput() {
        System.out.println("===>");
        String inputLine = input.nextLine().trim().toLowerCase();

        String wordArray[] = inputLine.split(" ");
        HashSet<String> words = new HashSet<String>();

        for (String word : wordArray) {
            words.add(word);
        }
        return words;
    }
}
