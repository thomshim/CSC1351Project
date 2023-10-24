package orderedList;

import java.util.Arrays;

/**
 * An array. Has methods such as add, remove, and a specifically formatted toString method.
 * CSC 1351 Programming Project No <1>
 * Section <002>
 *
 * @author THOMAS SHIMER
 * @since 10/23/2023
 */

public class aOrderedList {
    final int SIZEINCREMENTS = 20;
    private Comparable[] oList;
    private int listSize;
    private int numObjects;
    private int curr = 0;
    private int lastAccessed;

    public aOrderedList() {
        numObjects = 0;
        listSize = SIZEINCREMENTS;
        oList = new Car[SIZEINCREMENTS];
    }

    /**
     * Resizes the array if there is no room, and then adds an element (into it's sorted location).
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <THOMAS SHIMER>
     * @since <10/23/2023>
     */
    void add(Comparable newObject) {


        if (numObjects == listSize) {
            listSize += SIZEINCREMENTS;
            Comparable[] temp = new Comparable[listSize]; //creates larger temp array
            if (numObjects >= 0) System.arraycopy(oList, 0, temp, 0, numObjects);
            oList = temp;
        }

        int i = numObjects - 1; //the index of the array elements that are being compared

        while (i >= 0 && newObject.compareTo(oList[i]) < 0) {
            oList[i + 1] = oList[i];
            i--;
        }

        oList[i + 1] = newObject;
        numObjects++;
    }


    /**
     * Prints the array in the project's specified format.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */
    @Override
    public String toString() {
        String listString = String.format("Number of cars:%9d", numObjects);

        String space = ""; //the spaces between "Price: " and "$"price

        for (Comparable object : oList) {
            Car car = (Car) object;
            if (car != null) {
                for (int i = 0; i < 15 - String.valueOf(car.getPrice()).length(); i++) {
                    space += " ";
                }
                listString += String.format("\n\nMake:\t\t%12s\nYear:\t\t%12d\nPrice:  %s$%d",
                        car.getMake(), car.getYear(), space, car.getPrice());
                space = "";
            }
        }
        return listString;
    }

    int getSize() {
        return oList.length;
    }

    Comparable getIndex(int index) {
        return oList[index];
    }

    /**
     * Removes an object at a specific index in the array.
     * Shifts the rest down.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <THOMAS SHIMER>
     * @since <10/23/2023>
     */
    void remove(int index) {
        if (index < 0 || index >= numObjects) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        for (int i = index; i < numObjects - 1; i++) {
            oList[i] = oList[i + 1];
        }
        oList[numObjects - 1] = null;
        numObjects--;
    }

    /**
     * Checks to see if the array has contents beyond a given index.
     * Not yet used.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <THOMAS SHIMER>
     * @since <10/23/2023>
     */
    boolean isEmpty(int begin) {
        boolean empty = true;
        for (int i = begin; i < listSize; i++) {
            if (oList[i] != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    /**
     * Returns the next object in the array.
     * Not yet used.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */
    Comparable next() {
        lastAccessed = curr;
        curr++;
        return oList[lastAccessed];
    }

    /**
     * Returns true if there is an object to be accessed in the next index.
     * Not yet used.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */
    boolean hasNext() {
        return (!(oList[curr + 1] == null));
    }

    /**
     * Removes the last accessed index.
     * Not yet used.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */
    void remove() {
        remove(lastAccessed);
    }

    /**
     * Resets the index used by the next() method.
     * Not yet used.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */
    void reset() {
        this.curr = 0;
    }

    /**
     * Increases size of the array by SIZEINCREMENTS.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */
    void makeBigger() {
        Comparable[] newArr = Arrays.copyOf(oList, oList.length + SIZEINCREMENTS);
        oList = newArr;
    }
}
