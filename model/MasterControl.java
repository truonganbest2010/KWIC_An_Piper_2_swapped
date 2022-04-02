package model;

import view.KWIC;
public class MasterControl {

    private KWIC panel;

    //private String[] lines;
    //private ArrayList<String> linesList;

    public SharedData sharedData = new SharedData();
    public Input input = new Input();
    public CircularShift circularShift = new CircularShift();
    public Alphabetizer alphabetizer = new Alphabetizer();
    public Output output = new Output();

    public MasterControl(KWIC kwic) {
        this.panel = kwic;

        var userInput = this.panel.getTextInputArea().getText();

        input.read(userInput, sharedData);
        circularShift.prepare(sharedData);
        alphabetizer.alphabetize(sharedData);
        output.readChars(sharedData, kwic);
    }

    /*private void input(String userInput) {
        // Filter out all symbols aside from alphabet characters and spaces
        userInput = userInput.replaceAll("[^a-zA-Z\\s]", "");

        // split input into array by new line
        //characters = userInput.split("\\r?\\n|\\r"); 
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
        // filter out lines that begin with noise words
        String[] noise = { "a", "an", "the", "and", "or", "of", "to", "be", "is", "in", "out", "by", "as", "at",
                "off" };

        // convert array to arrayList to more easily remove items 
        ArrayList<String> linesOut =  new ArrayList<String>(Arrays.asList(lines));

        // loop through each output line
        for (int index = 0; index < linesOut.size(); index++) {
            String[] words = linesOut.get(index).split(" ");
            String firstWord = words[0];

            // at each line, compare first word with each word in noise array
            for (int k = 0; k < noise.length; k++) {
                // if the first word is in the noise array, remove
                if (firstWord.equalsIgnoreCase(noise[k])) {
                    linesOut.remove(index);
                    index--; //move index back to compensate for array shift
                }
            }
        }

        String outGUI = "";
        for (int j = 0; j < linesOut.size(); j++) {
            outGUI += (j + 1) + ". " + linesOut.get(j) + "\n\n";
        }

        // old print loop
        for (int j = 0; j < lines.length; j++) {
            outGUI += (j + 1) + ". " + lines[j] + "\n\n";
        }
        
        panel.getTextOutputArea().setText("");
        panel.getTextOutputArea().setText(outGUI);
    }*/
}