// -------------------------------------------------------
// Assignment 4
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.word;

import java.util.ArrayList;

import part1.exception.NotWordException;

/**
 * @author Ling Tan
 * @author Marzie Shafiee
 */
public class WordUtil {

    private static ArrayList<Word> orderedWordList;
    private static ArrayList<Word> stopWordList;
    private static ArrayList<Word> happaxList;
    private static int totalSize;
    private static int stopWordSize;
    private static int happaxSize;
    private static boolean isCategorized;

    static {
        orderedWordList = new ArrayList<Word>();
        stopWordList = new ArrayList<Word>();
        happaxList = new ArrayList<Word>();
        totalSize = 0;
        stopWordSize = 0;
        happaxSize = 0;
        isCategorized = false;
    }

    private WordUtil() {
    }

    /**
     * Add a string into the ArrayList with specific order.
     *
     * @param value the string to be added into the ArrayList
     * @throws NotWordException if the {@code value} is not a string
     */
    public static void addWord(String value) throws NotWordException {
        if (isWord(value)) {
            Word word = new Word(value);
            int index = orderedWordList.indexOf(word);
            int properIndex;
            if (index == -1) {//if the value was not found, compare the value to the word from the end of the ArrayList.
                properIndex = orderedWordList.size();
            } else {//if the value was found, compare the value to its previous word.
                word = orderedWordList.remove(index);
                word.increaseCount();
                properIndex = index;
            }
            properIndex = getIndexForNewWord(word, properIndex);
            orderedWordList.add(properIndex, word);
            totalSize++;
            isCategorized = false;
        } else {
            throw new NotWordException();
        }
    }

    /**
     * Get the ArrayList of all words
     *
     * @return ArrayList of all words
     */
    public static ArrayList<Word> getWordList() {
        if (!isCategorized) {
            categorized();
            isCategorized = true;
        }
        return orderedWordList;
    }

    /**
     * Get the ArrayList of all stopWords
     *
     * @return ArrayList of all stopWords
     */
    public static ArrayList<Word> getStopWordList() {
        if (!isCategorized) {
            categorized();
            isCategorized = true;
        }
        return stopWordList;
    }

    /**
     * Get the ArrayList of all happax
     *
     * @return ArrayList of all happax
     */
    public static ArrayList<Word> getHappaxList() {
        if (!isCategorized) {
            categorized();
            isCategorized = true;
        }
        return happaxList;
    }

    /**
     * Get the total number of words
     *
     * @return the total number of words
     */
    public static int getTotal() {
        return totalSize;
    }

    /**
     * Get the total number of all stopWords
     *
     * @return the total number of all stopWords
     */
    public static int getStopWordSize() {
        return stopWordSize;
    }

    /**
     * Get the total number of all happax
     *
     * @return the total number of all happax
     */
    public static int getHappaxSize() {
        return happaxSize;
    }

    /**
     * Get the index for {@code newWord}, at which it would keep the ArrayList ordered.
     * @param newWord
     * @param indexToInsert the position the {@code newWord} is excepted to be
     * @return
     */
    private static int getIndexForNewWord(Word newWord, int indexToInsert) {
        if (indexToInsert == 0) {//it is the first element
            return 0;
        }
        //otherwise, it should be compared to the previous word
        Word previousWord = orderedWordList.get(indexToInsert - 1);
        if (previousWord.getCount() > newWord.getCount()) {
            return indexToInsert;
        } else if (previousWord.getCount() < newWord.getCount()) {
            return getIndexForNewWord(newWord, --indexToInsert);
        } else {
            int result = newWord.compareTo(previousWord);
            if (result < 0) {
                return getIndexForNewWord(newWord, --indexToInsert);
            } else {
                return indexToInsert;
            }
        }
    }

    private static void categorized() {
        for (Word word : orderedWordList) {
            if (isStopWord(word)) {
                stopWordList.add(word);
                stopWordSize += word.getCount();
            } else if (isHappax(word)) {
                happaxList.add(word);
                happaxSize += word.getCount();
            }
        }
        isCategorized = true;
    }

    /**
     * a word only contains letters
     *
     * @param s
     * @return
     */
    private static boolean isWord(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        int begin = 'A';
        int end = 'z';
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c < begin || c > end) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check whether the given word have a length of 4 characters or less and
     * that appears at least 10 times in the text.
     *
     * @param word
     * @return
     */
    private static boolean isStopWord(Word word) {
        return word.getValue().length() <= 4 && word.getCount() >= 10;
    }

    /**
     * Check whether the given word only appear once.
     *
     * @param word
     * @return
     */
    private static boolean isHappax(Word word) {
        return word.getCount() == 1;
    }

}
