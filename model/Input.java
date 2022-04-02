package model;

public class Input {

    public void read(String userInput, SharedData sharedData) {
        // Filter out all symbols aside from alphabet characters and spaces
        userInput = userInput.replaceAll("[^a-zA-Z\\s]", "");

        // eliminate input 

        store(userInput, sharedData);
    }

    public void store(String userInput, SharedData sharedData) {
        sharedData.Characters = userInput.toCharArray();
    }
    
}
