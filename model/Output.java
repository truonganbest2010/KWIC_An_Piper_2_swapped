package model;

import view.KWIC;

public class Output {

    public void print(Alphabetizer alphabetizer, KWIC kwic) {
        String outGUI = "";
        for (int i = 0; i < alphabetizer.getLineCount(); i++) {
            outGUI += (i + 1) + ". " + alphabetizer.getLineAsString(i) + "\n\n";
        }

        kwic.getTextOutputArea().setText("");
        kwic.getTextOutputArea().setText(outGUI);
    }
}