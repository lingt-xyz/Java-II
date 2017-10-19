// -------------------------------------------------------
// Assignment 4
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.word;

/**
 * A word object that contains its value and how many times it appeared.
 *
 * @author Ling Tan
 * @author Marzie Shafiee
 */
public class Word implements Comparable<Word> {
    private String value;
    private int count;

    /**
     * Parameterized constructor. Set the counting to 1
     *
     * @param value
     */
    public Word(String value) {
        this.value = value;
        this.count = 1;
    }

    /**
     * Increase the word counting.
     */
    public void increaseCount() {
        this.count++;
    }

    /**
     * Return how many times the word appeared
     *
     * @return How many times the word appeared
     */
    public int getCount() {
        return count;
    }

    /**
     * Return the value of the word
     *
     * @return The value of the word
     */
    public String getValue() {
        return value;
    }

    /*
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Word word) {
        if (word == null || word.value.equals("")) {
            return -1;
        }
        String v = word.getValue();
        int minSize = this.value.length() <= v.length() ? this.value.length() : v.length();
        for (int i = 0; i < minSize; i++) {
            if (this.value.charAt(i) == v.charAt(i)) {
                continue;
            } else if (this.value.charAt(i) > v.charAt(i)) {
                return 1;
            } else {
                return -1;
            }
        }
        if (this.value.length() == v.length()) {
            return 0;
        } else if (this.value.length() > v.length()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.toUpperCase().equals(other.value.toUpperCase()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Word [value=" + value + ", count=" + count + "]";
    }

}