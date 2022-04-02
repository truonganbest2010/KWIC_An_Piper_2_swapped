package model;
public class Alphabetizer {

    public void alphabetize(SharedData sharedData) {
        sharedData.alphabetizedIndex =  sharedData.index;
        sort(sharedData);

    }

    public void sort(SharedData sharedData) {
        int index1;
        int index2;

        char a;
        char b;
        int i = 0;
        int j = 0;

        while(sharedData.alphabetizedIndex[i] != null) {
            while(sharedData.alphabetizedIndex[j+1] != null) {
                index1 = ((sharedData.alphabetizedIndex[j].first) +  (sharedData.alphabetizedIndex[j].offset));
                index2 = ((sharedData.alphabetizedIndex[j+1].first) +  (sharedData.alphabetizedIndex[j+1].offset));

                a = Character.toLowerCase(sharedData.Characters[index1]);
                b = Character.toLowerCase(sharedData.Characters[index2]);

                //System.out.println(a);
                //System.out.println(b);

                /*if(Character.toLowerCase(a) == Character.toLowerCase(b)) {

                }*/

                if(a > b) {
                    System.out.println("SWAPPED " + a + " AND " + b);
    
                    Index temp = sharedData.alphabetizedIndex[j];
                    sharedData.alphabetizedIndex[j] = sharedData.alphabetizedIndex[j+1];
                    sharedData.alphabetizedIndex[j+1] = temp;

                }
                j++;
            }
            i++;
        }

    }
    
}