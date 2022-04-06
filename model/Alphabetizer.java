package model;

public class Alphabetizer {

    private LineStorage lineStorage;

    private int[] sortedIndex;

    public void init(LineStorage ls) {
        lineStorage = ls;
        sortedIndex = new int[ls.getLineCount()];

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
            if ((maxChild + 1) < bottom && lineStorage.getLineAsString(sortedIndex[maxChild + 1]).toUpperCase()
                    .compareTo(lineStorage.getLineAsString(sortedIndex[maxChild]).toUpperCase()) > 0) {
                maxChild++;
            }
            if (lineStorage.getLineAsString(sortedIndex[root]).toUpperCase()
                    .compareTo(lineStorage.getLineAsString(sortedIndex[maxChild]).toUpperCase()) < 0) {
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
        return lineStorage.getLine(sortedIndex[linePos]);
    }

    // get a line as a string at a specific position after alphabetically sorted
    public String getLineAsString(int linePos) {
        return lineStorage.getLineAsString(sortedIndex[linePos]);
    }

    // get the number of lines in linestorage after alphabetically sorted
    public int getLineCount() {
        return lineStorage.getLineCount();
    }

}