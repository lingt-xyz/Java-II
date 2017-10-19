

/**
 * Ling Tan
 * COMP249 
 * Assignment 1 
 * Due Date: 2016/09/26
 * 
 * Define cell's position, type, and who owns it.
 * 
 * @author Ling Tan
 */
public class Cell {

	/**
	 * position of first dimension in the cell array
	 */
	private final int x;
	
	/**
	 * position of second dimension in the cell array
	 */
	private final int y;
	
	/**
	 * Define the type of the cell: a ship, a grenade, or nothing 
	 */
	private Type type;
	
	/**
	 * Define who owns the cell
	 */
	private Owner owner;
	
	/**
	 * whether the cell has be called
	 */
	private boolean beCalled;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = Type.NOTHING;
		this.owner = Owner.NONE;
		this.beCalled = false;
	}

	public Cell(int x, int y, Type type, Owner owner) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.owner = owner;
		this.beCalled = false;
	}

	/**
	 * Copy constructor
	 * 
	 * @param cell the cell to be copied
	 */
	public Cell(Cell cell) {
		this.x = cell.x;
		this.y = cell.y;
		this.type = cell.type;
		this.owner = cell.owner;
		this.beCalled = cell.beCalled;
	}

	public String toString() {
		return "This cell is at x:" + this.x + ", y:" + this.y + "; it's a " + this.type + "; it's owner is " + this.owner + "; it has " + (beCalled ? "" : "not ") + "been called.";

	}

	public boolean equals(Cell other) {
		if (this == other) {
			return true;
		}
		if (null == other) {
			return false;
		}

		if (this.beCalled != other.beCalled) {
			return false;
		}
		if (this.owner == null) {
			if (other.owner != null)
				return false;
		} else if (!this.owner.equals(other.owner))
			return false;
		if (this.type != other.type) {
			return false;
		}
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		return true;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public boolean isBeCalled() {
		return beCalled;
	}

	public void setBeCalled(boolean beCalled) {
		this.beCalled = beCalled;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
