package model;

import view.KWIC;

public class Output {

    public void print(CircularShifter circularShifter, KWIC kwic) {
        String outGUI = "";
        for (int i = 0; i < circularShifter.getLineCount(); i++) {
            outGUI += (i + 1) + ". " + circularShifter.getLineAsString(i) + "\n\n";
        }

        kwic.getTextOutputArea().setText("");
        kwic.getTextOutputArea().setText(outGUI);
    }
}
