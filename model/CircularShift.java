package model;

public class CircularShift {

    public void prepare(SharedData sharedData) {

        int first = 0;  // update on newline to i
        int offset = 0; // update on space i-first, reset on newLine

        // first line, no circular shift
        sharedData.index[0] = new Index(first, offset);

        int index = 1;

        for(int i = 0; i < sharedData.Characters.length; i++) {

            if(sharedData.Characters[i] == ' ') {
                offset = (i+1) - first;

                sharedData.index[index] = new Index(first, offset);

                index ++;
            }

            if(sharedData.Characters[i] == '\n') {
                first = i+1;
                offset = 0;

                sharedData.index[index] = new Index(first, offset);; 

                index ++;
            }
        }

       /*for(int i=0; i < sharedData.index.length; i++) {
            System.out.println(sharedData.index[i].first);
            System.out.println(sharedData.index[i].offset);
        }*/
    }
}
