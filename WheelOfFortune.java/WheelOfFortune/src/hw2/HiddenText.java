package hw2;


/**
 * Class representing some hidden text for a letter-guessing game. The displayed text
 * is a character array in which all alphabetic characters are initially replaced by
 * the '*' character. (Spaces and punctuation, if any, are always shown normally. A
 * character ch is considered alphabetic if Character.isAlphabetic(ch) returns true.)
 * Whenever the update() method is called with a letter that actually occurs in the
 * hidden text, that character replaces the '*' character in the hidden text. All methods
 * are case-insensitive and internally, all text and characters are converted to upper-case.
 *
 * @author Jon Beltzhoover
 */
public class HiddenText {
    /**
     * Holds the displayed text.
     */
    private char[] displayedText;
    /**
     * Holds the hidden text. Cannot be changed.
     */
    private final String hidden;
    /**
     * Holds the size of the hidden phrase.
     */
    private final int phraseSize;
    /**
     * Holds the hidden text as a character array.
     */
    private char[] revealedPhrase;

    /**
     * Constructor that sets the hidden phrase. The phrase does not contain the "*"
     * character.
     *
     * @param phrase - the hidden phrase.
     */
    public HiddenText(String phrase) {
        this.hidden = phrase.toUpperCase();
        this.phraseSize = hidden.length();
        this.revealedPhrase = hidden.toCharArray();

        displayedText = new char[phraseSize];

        int i;
        for (i = 0; i < phraseSize; i++) {
            if (revealedPhrase[i] == ' ') {
                this.displayedText[i] = ' ';
            }
            else if (revealedPhrase[i] == ',') {
                this.displayedText[i] = ',';
            }
            else {
                this.displayedText[i] = '*';
            }
        }
    }


    /**
     * Counts and returns how many consonants are not yet displayed.
     *
     * @return - number of hidden consonants
     */
    public int countHiddenConsonants() {
        int numConsonantsHidden = 0;
        char asterisk = '*';
        int i;

        for (i = 0; i < phraseSize; i++) {
            if (displayedText[i] == asterisk) {
                if (revealedPhrase[i] != 'A' && revealedPhrase[i] != 'E' && revealedPhrase[i] != 'I' && revealedPhrase[i] != 'O' && revealedPhrase[i] != 'U') {
                    numConsonantsHidden++;
                }
            }
        }

        return numConsonantsHidden;
    }

    /**
     * Counts and returns how many letters are not yet displayed.
     *
     * @return - number of hidden letters
     */
    public int countHiddenLetters() {
        int hiddenLetters = 0;
        char asterisk = '*';
        int i;

        for (i = 0; i < phraseSize; i++) {
            if (displayedText[i] == asterisk) {
                hiddenLetters++;
            }
        }

        return hiddenLetters;
    }

    /**
     * Displays what the current puzzle looks like. It might include letters and "*."
     *
     * @return - the char[] displayedText as a string
     */
    public String getDisplayedText() {
        return String.valueOf(displayedText);
    }

    /**
     * Returns the hidden puzzle phrase stored in this object.
     *
     * @return - the hidden phrase
     */
    public String getHiddenText() {
        return hidden;
    }

    /**
     * Determines if a character is a vowel or not. Vowels include A, E, I, O, and U.
     *
     * @param ch - a character input
     * @return - true/false depending on if there is a vowel
     */
    private boolean isVowel(char ch) {
        char isVowel = Character.toUpperCase(ch);
        
        if (isVowel == 'A' || isVowel == 'E' || isVowel == 'I' || isVowel == 'O' || isVowel == 'U') {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Counts and returns how many times a certain letter appears in the hidden phrase.
     *
     * @param ch - a character input
     * @return - how many times a certain letter input appears in the phrase
     */
    public int letterCount(char ch) {
        int i;
        int letterCount = 0;
        char letter = Character.toUpperCase(ch);

        for (i = 0; i < phraseSize; i++) {
            if (revealedPhrase[i] == letter) {
                letterCount++;
            }
        }

        return letterCount;
    }

    /**
     * Updates the hidden text to reveal the guessed characters, if any.
     *
     * @param ch - a character input
     */
    public void update(char ch) {
        char letter = Character.toUpperCase(ch);
        int i;

        boolean isVowel = isVowel(ch);

        for (i = 0; i < phraseSize; i++) {
            if (revealedPhrase[i] == letter) {
                displayedText[i] = letter;
            }
        }

    }

    /**
     * Updates the hidden text to reveal the entire phrase, if guessed correctly
     *
     * @param ch - a string input
     * @return - true/false depending on if the input string matches the hidden phrase.
     */
    public boolean updateString(String ch) {
        String guess = ch.toUpperCase();

        if (hidden.equals(guess)) {
            updateAllRemaining();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Updates the hidden text to reveal the entire phrase.
     */
    public void updateAllRemaining() {
        int i;

        for (i = 0; i < phraseSize; i++) {
            displayedText[i] = revealedPhrase[i];
        }
    }


}
