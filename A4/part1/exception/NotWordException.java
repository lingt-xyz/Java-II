// -------------------------------------------------------
// Assignment 4
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.exception;

/**
 * If a string is not a word, this exception would be thrown
 *
 * @author Ling Tan
 * @author Marzie Shafiee
 */
public class NotWordException extends Exception {

    private static final long serialVersionUID = 3842551276993617951L;

    private static final String msg = "The given is not a word. A word can only contains letters.";

    /**
     * Default constructor
     */
    public NotWordException() {
        super(msg);
    }

    /**
     * Parameterized constructor
     *
     * @param msg
     */
    public NotWordException(String msg) {
        super(msg);
    }
}
