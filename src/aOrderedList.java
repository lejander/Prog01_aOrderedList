import java.util.Arrays;

//File name is called text.
public class aOrderedList {
    private static final int SIZE_INCREMENTS = 20;
    private Comparable[] oList;
    private int listSize;
    private int numObjects;

    public aOrderedList() {
        listSize = SIZE_INCREMENTS;
        oList = new Comparable[listSize];
        numObjects = 0;
    }

    public void add(Comparable newObject) {
        if (numObjects == listSize) {
            listSize += SIZE_INCREMENTS;
            oList = Arrays.copyOf(oList, listSize);
        }
        int index = Arrays.binarySearch(oList, 0, numObjects, newObject);
        if (index < 0) {
            index = -(index + 1);
        }
        System.arraycopy(oList, index, oList, index + 1, numObjects - index);
        oList[index] = newObject;
        numObjects++;
    }

    public String toString() {
        return Arrays.toString(oList);
    }

    public int size() {
        return numObjects;
    }

    public void remove(int index) {
        if (index >= 0 && index < numObjects) {
            // Shift elements to remove the object at the specified index
            System.arraycopy(oList, index + 1, oList, index, numObjects - index - 1);
            numObjects--;
            System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        }
    }

    public Comparable get(int i) {
        if (i >= 0 && i < numObjects) {
            return oList[i];
        }
        return null;
    }
}
