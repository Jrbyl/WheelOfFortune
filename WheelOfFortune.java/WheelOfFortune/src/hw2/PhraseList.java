package hw2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class encapsulates a list of strings representing phrases or words for use in a
 * letter-guessing game. The list is initialized from a file.
 *
 * @author Jon Beltzhoover
 */
public class PhraseList {
    /**
     * Holds the total number of phrases in the list.
     */
    private int numberOfPhrases;
    /**
     * Holds the list of phrases.
     */
    private String[] phrases;


    /**
     * Constructs the list of phrases that will choose phrases from the given file.
     *
     * @param givenFilename
     */
    public PhraseList(String givenFilename) throws FileNotFoundException {
        File phraseFile = new File(givenFilename);
        Scanner inFS = new Scanner(phraseFile);
        numberOfPhrases = 0;
        int i;

        while (inFS.hasNextLine()) {
            inFS.nextLine();
            numberOfPhrases++;
        }
        inFS.close();
        phrases = new String[numberOfPhrases];

        Scanner inFS2 = new Scanner(phraseFile);

        for (i = 0; inFS2.hasNextLine(); i++) {
            phrases[i] = inFS2.nextLine();
        }
        inFS2.close();
    }


    /**
     * Returns the phrase at the given index.
     *
     * @param n
     * @return
     */
    public String getPhrase(int n) {
        if (n < 0) {
            return "Error getting phrase";
        }
        else if (n > (phrases.length) - 1) {
            return "Error getting phrase";
        }
        else {
            return phrases[n];
        }
    }

    /**
     * Returns the number of phrases in the array.
     *
     * @return
     */
    public int getSize() {
        return numberOfPhrases;
    }


}
