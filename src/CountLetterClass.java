public class CountLetterClass {
//ou CountHelper

    public int countWordWithoutSpacesOrSpecialCaracter(String word,int letterCounter) {
        letterCounter = word.length();

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetterOrDigit(word.charAt(i))) {
                letterCounter--;
            }
        }
        return letterCounter;
    }

}
