package model;

import view.KWIC;

public class Output {

    public void readChars(SharedData sharedData, KWIC panel) {

        int i = 0;

        while (sharedData.alphabetizedIndex[i] != null) {
            i = filterNoise(sharedData, i);
            int index1 = ((sharedData.alphabetizedIndex[i].first) + (sharedData.alphabetizedIndex[i].offset));
            int index2 = (sharedData.alphabetizedIndex[i].first);

            int k = index1; // save value of initial index1

            while ((index1 < sharedData.Characters.length) && (sharedData.Characters[index1] != '\n')) {
                print(sharedData.Characters[index1]);
                index1++;
            }

            print(' ');

            while (index2 < k) {
                print(sharedData.Characters[index2]);
                index2++;
            }

            print('\n');
            i++;
        }

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

        //System.out.println("first word: " + firstWord);

        // check if first word is noise word, if yes, return the next index
        for (int k = 0; k < noise.length; k++) {
            if (firstWord.equalsIgnoreCase(noise[k])) {
                i++;
            }
        }

        return i;
    }

    public void print(char i) {
        // String outGUI = "";

        System.out.print(i);

        // panel.getTextOutputArea().setText("");
        // panel.getTextOutputArea().setText(outGUI);
    }

}
