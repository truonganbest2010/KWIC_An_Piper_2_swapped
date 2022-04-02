package model;

public class Alphabetizer {

    private CircularShifter circularShifter;

    private int sortedIndex[];

    public void init(CircularShifter cs) {
        circularShifter = cs;
        sortedIndex = new int[circularShifter.getLineCount()];

        // Initialize sortedIndex array
        for (int i = 0; i < sortedIndex.length; i++) {
            sortedIndex[i] = i;
        }

        // Heap sort to sort the shifts in alphabetically order and insensitive_case
        for (int i = (sortedIndex.length / 2 - 1); i >= 0; i--)
            shiftDown(i, sortedIndex.length);

        for (int i = (sortedIndex.length - 1); i >= 1; i--) {
            int tmp = sortedIndex[0];
            sortedIndex[0] = sortedIndex[i];
            sortedIndex[i] = tmp;
            shiftDown(0, i);
        }

    }

    // Heap Sort
    private void shiftDown(int root, int bottom) {

        int maxChild = root * 2 + 1;

        while (maxChild < bottom) {

            if ((maxChild + 1) < bottom && circularShifter.getLineAsString(sortedIndex[maxChild + 1]).toUpperCase()
                    .compareTo(circularShifter.getLineAsString(sortedIndex[maxChild]).toUpperCase()) > 0) {
                maxChild++;
            }

            if (circularShifter.getLineAsString(sortedIndex[root]).toUpperCase()
                    .compareTo(circularShifter.getLineAsString(sortedIndex[maxChild]).toUpperCase()) < 0) {
                int tmp = sortedIndex[root];
                sortedIndex[root] = sortedIndex[maxChild];
                sortedIndex[maxChild] = tmp;
                root = maxChild;
                maxChild = root * 2 + 1;
            } else {
                break;
            }

        }
    }

    // get an array of strings of line after alphabetically sorted
    public String[] getLine(int linePos) {
        return circularShifter.getLine(sortedIndex[linePos]);
    }

    // get a line as a string at a specific position after alphabetically sorted
    public String getLineAsString(int linePos) {
        return circularShifter.getLineAsString(sortedIndex[linePos]);
    }

    // get the number of lines in linestorage after alphabetically sorted
    public int getLineCount() {
        return circularShifter.getLineCount();
    }

}