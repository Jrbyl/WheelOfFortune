package hw2;

public class HiddenTextTest {

    public static void main(String[] args) {

        String hello = "hello";
        HiddenText test = new HiddenText(hello);

        System.out.println("");

        System.out.println(test.getHiddenText());
        System.out.println("Expected: HELLO");

        System.out.println("");

        System.out.println(test.getDisplayedText());
        System.out.println("Expected: *****");

        System.out.println("");

        System.out.println(test.countHiddenLetters());
        System.out.println("Expected: 5");

        System.out.println("");

        System.out.println(test.countHiddenConsonants());
        System.out.println("Expected: 3");

        System.out.println("");

        char letter = 'h';
        System.out.println(test.letterCount(letter));
        System.out.println("Expected: 1");

        System.out.println("");

        char letter2 = 'e';
        System.out.println(test.letterCount(letter2));
        System.out.println("Expected: 1");

        System.out.println("");

        char letter3 = 'l';
        System.out.println(test.letterCount(letter3));
        System.out.println("Expected: 2");

        System.out.println("");

        char letter4 = 'o';
        System.out.println(test.letterCount(letter4));
        System.out.println("Expected: 1");

        System.out.println("");

        test.update(letter3);

        System.out.println(test.getDisplayedText());
        System.out.println("Expected: **LL*");

        System.out.println("");

        System.out.println(test.countHiddenLetters());
        System.out.println("Expected: 3");

        System.out.println("");

        System.out.println(test.countHiddenConsonants());
        System.out.println("Expected: 1");

        System.out.println("");

        test.update(letter);

        System.out.println(test.getDisplayedText());
        System.out.println("Expected: H*LL*");

        System.out.println("");

        System.out.println(test.countHiddenLetters());
        System.out.println("Expected: 2");

        System.out.println("");

        System.out.println(test.countHiddenConsonants());
        System.out.println("Expected: 0");

        System.out.println("");

        test.update(letter4);

        System.out.println(test.getDisplayedText());
        System.out.println("Expected: H*LLO");

        System.out.println("");

        System.out.println(test.countHiddenLetters());
        System.out.println("Expected: 1");

        System.out.println("");

        System.out.println(test.countHiddenConsonants());
        System.out.println("Expected: 0");

        System.out.println("");

        test.update(letter2);

        System.out.println(test.getDisplayedText());
        System.out.println("Expected: HELLO");

        System.out.println("");

        System.out.println(test.countHiddenLetters());
        System.out.println("Expected: 0");

        System.out.println("");

        System.out.println(test.countHiddenConsonants());
        System.out.println("Expected: 0");


        String helloWorld = "hello world";
        HiddenText test2 = new HiddenText(helloWorld);

        System.out.println("");

        System.out.println(test2.getHiddenText());
        System.out.println("Expected: HELLO WORLD");

        System.out.println("");

        System.out.println(test2.getDisplayedText());
        System.out.println("Expected: ***** *****");

        System.out.println("");

        test2.updateAllRemaining();

        System.out.println(test2.getDisplayedText());
        System.out.println("Expected: HELLO WORLD");


        String guessFull = "Java is fun";
        HiddenText test3 = new HiddenText(guessFull);

        System.out.println("");

        System.out.println(test3.getDisplayedText());
        System.out.println("Expected: **** ** ***");

        System.out.println("");

        System.out.println(test3.updateString("Java is fun"));
        System.out.println("Expected: true");

        System.out.println("");

        System.out.println(test3.getDisplayedText());
        System.out.println("Expected: JAVA IS FUN");
    }
}
