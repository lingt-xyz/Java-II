// -------------------------------------------------------
// Assignment 3
// Part: II
// Written by: Ling Tan 40014082, Marzie Shafiee 40016801
// -------------------------------------------------------
package part2;

/**
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class DuplicateSerialNumberException extends Exception {

	/**
	 * The position of the duplicate record was found
	 */
	private int index;
	/**
	 * The duplicate serial number
	 */
	private long serialNumber;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7091688732963633467L;

	/**
	 * Full-parameterized constructor
	 * 
	 * @param index
	 * @param serialNumber
	 */
	public DuplicateSerialNumberException(int index, long serialNumber) {
		this.index = index;
		this.serialNumber = serialNumber;
	}

	public DuplicateSerialNumberException(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		return "Attempt of duplicate entry to a previous record. Initial appearance of serial number " + this.serialNumber + " was found at record # " + this.index + ".\n"
				+ "Error.... Duplicate Entry of Serial Number. The entered serial number exists for another record.";
	}
}
