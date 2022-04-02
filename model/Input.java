package model;

import view.KWIC;

public class Input {

    public void read(KWIC kwic, LineStorage lineStorage) {

        String userInput = kwic.getTextInputArea().getText().replaceAll("[^a-zA-Z\\s]", "");

        for (var s : userInput.split("\\r?\\n|\\r")) {
            lineStorage.addLine(s.split(" "));
        }

    }
}