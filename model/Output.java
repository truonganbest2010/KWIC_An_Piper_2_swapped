package model;

import view.KWIC;

public class Output {

    String outGUI = "";

    public void readChars(SharedData sharedData, KWIC panel) {

        int i = 0;

        while (sharedData.alphabetizedIndex[i] != null) {
            //i = filterNoise(sharedData, i); // filter noise words
            int index1 = ((sharedData.alphabetizedIndex[i].first) + (sharedData.alphabetizedIndex[i].offset));
            int index2 = (sharedData.alphabetizedIndex[i].first);

            int k = index1; // save value of initial index1

            while ((index1 < sharedData.Characters.length) && (sharedData.Characters[index1] != '\n')) {
                buildString(sharedData.Characters[index1]);
                index1++;
            }

            buildString(' ');

            while (index2 < k) {
                buildString(sharedData.Characters[index2]);
                index2++;
            }

            buildString('\n');
            i++;
        }

        print(panel);

    }

    public int filterNoise(SharedData sharedData, int i) {

        String[] noise = { "a", "an", "the", "and", "or", "of", "to", "be", "is", "in", "out", "by", "as", "at",
                "off" };

        int index = ((sharedData.alphabetizedIndex[i].first) + (sharedData.alphabetizedIndex[i].offset));
        String firstWord = "";
        
        // build first word String
        while( (index < sharedData.Characters.length) && ((sharedData.Characters[index] != ' ') && (sharedData.Characters[index] != '\n'))) {
            firstWord += sharedData.Characters[index];
            index++;
        }

        // check if first word is noise word, if yes, return the next index
        for (int k = 0; k < noise.length; k++) {
            if (firstWord.equalsIgnoreCase(noise[k])) {
                i++;
            }
        }

        return i;
    }

    public void buildString(char i) {
        outGUI += i;
    }

    public void print(KWIC panel) {
        //outGUI += (i+1) + ". " + lines[i] + "\n\n";
        //System.out.print(outGUI);

        panel.getTextOutputArea().setText("");
        panel.getTextOutputArea().setText(outGUI);
    }

}
