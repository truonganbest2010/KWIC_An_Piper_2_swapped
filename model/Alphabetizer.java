package model;

public class Alphabetizer {

    public void alphabetize(SharedData sharedData) {
        sharedData.alphabetizedIndex = sharedData.index;

        // sort(sharedData);
        test(sharedData);

    }

    public void sort(SharedData sharedData) {
        // LOOK AT TEST() FUNCTION

        /*
         * int index1;
         * int index2;
         * 
         * Index temp;
         * 
         * char a;
         * char b;
         * int i = 0;
         * int j = 1;
         * 
         * // sharedData.alphabetizedIndex[i] != null
         * while (sharedData.alphabetizedIndex[i] != null) {
         * while (sharedData.alphabetizedIndex[j + 1] != null) {
         * index1 = ((sharedData.alphabetizedIndex[j - 1].first) +
         * (sharedData.alphabetizedIndex[j - 1].offset));
         * index2 = ((sharedData.alphabetizedIndex[j].first) +
         * (sharedData.alphabetizedIndex[j].offset));
         * 
         * a = Character.toLowerCase(sharedData.Characters[index1]);
         * b = Character.toLowerCase(sharedData.Characters[index2]);
         * 
         * // System.out.println(a);
         * // System.out.println(b);
         * 
         * if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
         * 
         * }
         * 
         * if (a > b) {
         * System.out.println("SWAPPED " + a + " AND " + b);
         * 
         * temp = sharedData.alphabetizedIndex[j];
         * sharedData.alphabetizedIndex[j] = sharedData.alphabetizedIndex[j - 1];
         * sharedData.alphabetizedIndex[j - 1] = temp;
         * 
         * }
         * j++;
         * }
         * i++;
         * }
         */

    }

    public void test(SharedData sharedData) {
        int n = 1000;
        Index temp;

        int index1;
        int index2;

        char a;
        char b;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (sharedData.alphabetizedIndex[i] == null) {
                    return;
                }
                if (sharedData.alphabetizedIndex[j] == null) {
                    j = 1;
                    i++;
                }

                index1 = ((sharedData.alphabetizedIndex[j - 1].first)
                        + (sharedData.alphabetizedIndex[j - 1].offset));
                index2 = ((sharedData.alphabetizedIndex[j].first) + (sharedData.alphabetizedIndex[j].offset));

                a = sharedData.Characters[index1];
                b = sharedData.Characters[index2];

                // if one of two letters is uppercase
                if ((Character.toLowerCase(a) == Character.toLowerCase(b)) && (a != b)) {
                    // if b is lowercase
                    if (Character.toLowerCase(b) == b) {
                        // swap elements
                        temp = sharedData.alphabetizedIndex[j];
                        sharedData.alphabetizedIndex[j] = sharedData.alphabetizedIndex[j - 1];
                        sharedData.alphabetizedIndex[j - 1] = temp;
                    }

                }

                if (Character.toLowerCase(a) > Character.toLowerCase(b)) {
                    // swap elements
                    temp = sharedData.alphabetizedIndex[j];
                    sharedData.alphabetizedIndex[j] = sharedData.alphabetizedIndex[j - 1];
                    sharedData.alphabetizedIndex[j - 1] = temp;
                }

            }
        }
    }

}