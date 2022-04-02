package model;

import java.util.Arrays;

public class CircularShifter {

    private LineStorage shifts;

    // initialize the circular shifter
    public void init(LineStorage lineStorage, NoiseWordsFilter noiseWordsFilter) {
        shifts = new LineStorage();

        for (int i = 0; i < lineStorage.getLineCount(); i++) {
            String[] lines = lineStorage.getLine(i);
            for (int j = 0; j < lines.length; j++) {
                if (!noiseWordsFilter.ignoreCase(lines[j])) {
                    shifts.addEmptyLine();
                    for (int k = j; k < lines.length + j; k++) {
                        // System.out.print(k + lines[k % lines.length] + " ");
                        shifts.addWord(lines[k % lines.length], shifts.getLineCount() - 1);
                    }

                }
            }
        }

    }

    // get a character of a word in a specific line
    public char getChar(int pos, int linePos, int wordPos) {
        return shifts.getChar(pos, linePos, wordPos);
    }

    // get the number of characters of a word in a specific line
    public int getCharCount(int linePos, int wordPos) {
        return shifts.getCharCount(linePos, wordPos);
    }

    // get a specific word in a line
    public String getWord(int linePos, int wordPos) {
        return shifts.getWord(linePos, wordPos);
    }

    // get the number of words in a specific line
    public int getWordCount(int linePos) {
        return shifts.getWordCount(linePos);
    }

    // get an array of string of a specific line
    public String[] getLine(int linePos) {
        return shifts.getLine(linePos);
    }

    // get a string of a specific line
    public String getLineAsString(int linePos) {
        return shifts.getLineAsString(linePos);
    }

    // get the number of lines in shifts
    public int getLineCount() {
        return shifts.getLineCount();
    }

}