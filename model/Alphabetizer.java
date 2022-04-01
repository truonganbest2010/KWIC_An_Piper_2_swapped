package model;


public class Alphabetizer {

    public void readChar(SharedData sharedData) {
        int index;
        int i = 0;

        while(sharedData.index[i] != null) { // might have specify Index.first != null
                index = ((sharedData.index[i].first) +  (sharedData.index[i].offset));
                char a = sharedData.Characters[index];
                char b = sharedData.Characters[index++];

                //System.out.println(a);
                //System.out.println(b);

                // sort
                if(a < b) {
                    Index temp = sharedData.index[i];
                    sharedData.index[i] = sharedData.index[i+1];
                    sharedData.index[i+1] = temp;
                }

                
                i++;
        }
        

    }

    public void readIndex() {

    }

    public void alphabetize() {
        // i = first + offset : index of first char of each line

        // while next entry in index != null
        // read the char value of characters[first + offset of index]

        // sort entries alphabetically


    }
    
}