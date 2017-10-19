// -------------------------------------------------------
// Assignment 4
// Part: II
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part2;

import java.util.NoSuchElementException;

/**
 * @author Ling Tan
 * @author Marzie Shafiee
 */
public class CellList {

    private CellNode head;
    private int size;

    public CellList() {
        head = null;
        size = 0;
    }

    public CellList(CellList cl) {
        if (cl.head == null) {
            head = null;
            size = 0;
        } else {
            this.head = cl.head.clone();//clone value
            CellNode originalNode = cl.head;
            CellNode newNode = this.head;
            while (originalNode.next != null) {
                newNode.next = originalNode.next.clone();
                originalNode = originalNode.next;
                newNode = newNode.next;
            }
            size = cl.size;
        }
    }

    /**
     * Creates a node with the passed object and inserts this node at the head
     * of the list;
     *
     * @param value an object from CellPhone class
     */
    public void addToStart(CellPhone value) {
        head = new CellNode(value, head);
        size++;
    }

    /**
     * If the index is valid, then the method creates a node with the passed
     * CellPhone object and inserts this node at the given index. The method
     * must properly handle all special cases.
     *
     * @param value an object from CellPhone class
     * @param index an integer representing an index
     * @throws NoSuchElementException If the index is not valid (a valid index must have a value
     *                                between 0 and size-1), the method must throw a
     *                                NoSuchElementException and terminate the program.
     */
    public void insertAtIndex(CellPhone value, int index) throws NoSuchElementException {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            addToStart(value);
            return;
        }
        CellNode t = head;
        for (int i = 0; i < index - 1; i++) {
            t = t.next;
        }
        t.next = new CellNode(value, t.next);
        size++;
    }

    /**
     * The node pointed by that index is deleted from the list. The method must
     * properly handle all special cases.
     *
     * @param index an integer representing an index
     * @throws NoSuchElementException if the index is not valid, the method must throw a
     *                                NoSuchElementException and terminate the program.
     */
    public void deleteFromIndex(int index) throws NoSuchElementException {// privacy
        // leak
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            deleteFromStart();
            return;
        }
        CellNode t = head;
        for (int i = 0; i < index - 1; i++) {
            t = t.next;
        }
        t.next = t.next.next;
        size--;
    }

    /**
     * deletes the first node in the list (the one pointed by head). All special
     * cases must be properly handled.
     */
    public void deleteFromStart() {// privacy leak
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

    /**
     * If the index is not valid, the method simply returns; otherwise the
     * object in the node at the passed index is to be replaced by the passed
     * object;
     *
     * @param value an object from CellPhone class
     * @param index an integer representing an index
     */
    public void replaceAtIndex(CellPhone value, int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0 && head == null) {
            return;
        }
        CellNode t = head;
        for (int i = 0; i < index; i++) {
            t = t.next;
        }
        t.value = value;
    }

    /**
     * searches the list for a node with a cell phone with that serial number.
     * If such an object is found, then the method returns a pointer to that
     * node where the object is found; otherwise, the method returns null. The
     * method must keep track of how many iterations were made before the search
     * finally finds the phone or concludes that it is not in the list;
     *
     * @param serialNumber
     */
    public CellNode find(long serialNumber) {
        if (head == null) {
            System.out.println("The list is empty. No iteration was made.");
            return null;
        } else {
            int counter = 1;
            CellNode node = head;
            while (node != null && node.value != null && node.value.getSerialNumber() != serialNumber) {
                node = node.next;
                counter++;
            }
            System.out.println(counter + " iterations were made.");
            if (node == null) {
                return null;
            } else {
                return node.clone();
            }
        }
    }

    /**
     * @param serialNumber
     * @return return true if the an object with that serial number is in the
     * list; otherwise, false.
     */
    public boolean contains(long serialNumber) {
        return find(serialNumber) == null ? false : true;
    }

    public int getSize() {
        return size;
    }

    /**
     * Displays the contents of the list, in a similar fashion to what is shown
     * in Figure 2 below.
     */
    public void showContents() {
        CellNode node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * @param cl
     * @return return true, if the two lists contain similar objects; otherwise
     * false.
     */
    public boolean equals(CellList cl) {
        if (cl == null) {
            return false;
        }
        if (this.size != cl.size) {
            return false;
        }
        CellNode thisNode = head;
        CellNode otherNode = cl.head;
        while (thisNode != null) {
            if (!thisNode.value.equals(otherNode.value)) {
                return false;
            }
            thisNode = thisNode.next;
            otherNode = otherNode.next;
        }
        return true;
    }

    public class CellNode implements Cloneable {
        private CellPhone value;
        private CellNode next;

        private CellNode() {
            this.value = null;
            this.next = null;
        }

        /**
         * This constructor should never been used, because we are not doing the deep copy.
         *
         * @param value
         * @param next
         */
        private CellNode(CellPhone value, CellNode next) {
            this.value = value;
            this.next = next;
        }

        /**
         * This constructor should never been used, because we are not doing the deep copy.
         *
         * @param node
         */
        private CellNode(CellNode node) {
            this.value = node.value;
            this.next = node.next;
        }

        @SuppressWarnings("unused")
        private CellPhone getValue() {
            return value;
        }

        @SuppressWarnings("unused")
        private void setValue(CellPhone value) {
            this.value = value;
        }

        @SuppressWarnings("unused")
        private CellNode getNext() {
            return next;
        }

        @SuppressWarnings("unused")
        private void setNext(CellNode next) {
            this.next = next;
        }

        @Override
        protected CellNode clone() {
            return new CellNode(this.value.clone(), null);
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }
}
