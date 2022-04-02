package model;

import java.util.ArrayList;

public class Line extends ArrayList {

    private ArrayList<String> words = this;

    // set a single character value of a specific word
    public void setChar(char c, int pos, int wordPos) {
        char[] word = words.get(wordPos).toCharArray();
        word[pos] = c;
        words.set(wordPos, String.valueOf(word));
    }

    // get a single character value of a specific word
    public char getChar(int pos, int wordPos) {
        char[] word = words.get(wordPos).toCharArray();
        return word[pos];
    }

    // add a single character into a specific word
    public void addChar(char c, int wordPos) {
        char[] word = words.get(wordPos).toCharArray();
        char[] newWord = new char[word.length + 1];
        System.arraycopy(word, 0, newWord, 0, word.length);
        newWord[word.length] = c;
        words.set(wordPos, String.valueOf(newWord));
    }

    // delete a character at a specific position of a word
    public void deleteChar(int pos, int wordPos) {
        char[] word = words.get(wordPos).toCharArray();
        char[] newWord = new char[word.length - 1];
        System.arraycopy(word, 0, newWord, 0, pos);
        System.arraycopy(word, pos + 1, newWord, pos, word.length - pos - 1);
        words.set(wordPos, String.valueOf(newWord));
    }

    // get the number of characters of a word
    public int getCharCount(int wordPos) {
        String word = words.get(wordPos);
        return word.length();
    }

    // set value of a word by adding an array of characters into a specific position
    public void setWord(char[] c, int wordPos) {
        words.set(wordPos, String.valueOf(c));
    }

    // set value of a word by adding a string into a specific position
    public void setWord(String s, int wordPos) {
        words.set(wordPos, s);
    }

    // add value of a word by adding an array of characters
    public void addWord(char[] c) {
        words.add(String.valueOf(c));
    }

    // add value of a word by adding a string
    public void addWord(String s) {
        words.add(s);
    }

    // add an empty word into word list
    public void addEmptyWord() {
        words.add(new String());
    }

    // delete a word at a specific position
    public void deleteWord(int wordPos) {
        words.remove(wordPos);
    }

    // get the number of words in word list
    public int getWordCount() {
        return words.size();
    }

}