package model;

import java.util.ArrayList;
import java.util.Arrays;

import view.KWIC;

public class MasterControl {

    private KWIC panel;

    private String[] lines;
    private ArrayList<String> linesList;

    public MasterControl(KWIC kwic) {
        this.panel = kwic;
        this.lines = new String[1000];
        this.linesList = new ArrayList<String>();

        var userInput = this.panel.getTextInputArea().getText();

        input(userInput);
        circularShift();
        alphabetizer();
        output();
    }

    private void input(String userInput) {
        // Filter out all symbols aside from alphabet characters and spaces
        userInput = userInput.replaceAll("[^a-zA-Z\\s]", "");

        // split input into array by new line
        lines = userInput.split("\\r?\\n|\\r");
    }

    private void circularShift() {
        // break down line into word array
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                // save word in first element to reassign
                String temp = words[0];

                // circular shift each word
                for (int c = 0; c < words.length - 1; c++) {
                    words[c] = words[c + 1];
                }
                // reassign first word to last element
                words[words.length - 1] = temp;

                // rebuild word array back into one line
                String wordString = "";
                for (int c = 0; c < words.length - 1; c++) {
                    wordString += words[c] + " ";
                }
                wordString += words[words.length - 1];

                // add rebuilt line to array list
                linesList.add(wordString);
            }
        }

        lines = new String[1000];
        lines = linesList.toArray(new String[0]);
    }

    private void alphabetizer() {
        Arrays.sort(lines, String.CASE_INSENSITIVE_ORDER);
    }

    private void output() {
        String outGUI = "";
        for (int i = 0; i < lines.length; i++) {
            // System.out.println(lines[i]);
            outGUI += (i + 1) + ". " + lines[i] + "\n\n";
        }
        panel.getTextOutputArea().setText("");
        panel.getTextOutputArea().setText(outGUI);
    }
}