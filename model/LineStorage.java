package model;

import java.util.ArrayList;

public class LineStorage extends ArrayList {

    private ArrayList<Line> lines = new ArrayList();

    // set character at a specific position of a word in a line
    public void setChar(char c, int pos, int linePos, int wordPos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        String word = (String) line.get(wordPos);
        char[] chars = word.toCharArray();
        chars[pos] = c;
        word = new String(chars);
        line.set(wordPos, word);
    }

    // get character at a specific position of a word in a line
    public char getChar(int pos, int linePos, int wordPos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        String word = (String) line.get(wordPos);
        return word.charAt(pos);
    }

    // add character at a specific position of a word in a line
    public void addChar(char c, int linePos, int wordPos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        String word = (String) line.get(wordPos);
        char[] chars = new char[word.length() + 1];

        word.getChars(0, chars.length - 1, chars, 0);
        chars[chars.length - 1] = c;
        word = new String(chars);
        line.set(wordPos, word);
    }

    // delete character at a specific position of a word in a line
    public void deleteChar(int pos, int linePos, int wordPos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        String word = (String) line.get(wordPos);
        char[] chars = new char[word.length() - 1];
        word.getChars(0, pos, chars, 0);
        word.getChars(pos + 1, chars.length, chars, pos);
        word = new String(chars);
        line.set(wordPos, word);
    }

    // get number of characters of a specific word in a line
    public int getCharCount(int linePos, int wordPos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        String word = (String) line.get(wordPos);
        return word.length();
    }

    // set value of a word by adding a string into a specific word in a line
    public void setWord(String s, int linePos, int wordPos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        line.set(wordPos, s);
    }

    // set value of a word by adding an array of characters into a specific word in
    // a line
    public void setWord(char[] chars, int linePos, int wordPos) {
        setWord(new String(chars), wordPos, linePos);
    }

    // get value of a specific word in a line
    public String getWord(int linePos, int wordPos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        return (String) line.get(wordPos);
    }

    // add value of a specific word by adding a string into a specific line
    public void addWord(String s, int linePos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        line.add(s);
    }

    // add value of a specific word by adding an array of characters into a specific
    // line
    public void addWord(char[] chars, int linePos) {
        addWord(new String(chars), linePos);
    }

    // add an empty string of word into a line
    public void addEmptyWord(int linePos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        line.add(new String());
    }

    // delete a word at a specific position in line
    public void deleteWord(int linePos, int wordPos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        line.remove(wordPos);
    }

    // get the number of words in a specific line
    public int getWordCount(int linePos) {
        return ((ArrayList) lines.get(linePos)).size();
    }

    // set new line of words into a specific line
    public void setLine(char[][] words, int linePos) {
        String[] temp = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            temp[i] = new String(words[i]);
        }

        setLine(temp, linePos);
    }

    // set new line of words by giving a string into a specific line
    public void setLine(String[] words, int linePos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        line.clear();
        for (int i = 0; i < words.length; i++) {
            line.add(words[i]);
        }
    }

    // get an array of string value of a line at a specific position
    public String[] getLine(int linePos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        String[] temp = new String[line.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (String) line.get(i);
        }

        return temp;
    }

    // get a string of line at a specific position
    public String getLineAsString(int linePos) {
        ArrayList line = (ArrayList) lines.get(linePos);
        int size = line.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += getWord(linePos, i).length();
        }

        length += size - 1;

        char[] temp = new char[length];

        int count = 0;
        for (int i = 0; i < size; i++) {
            getWord(linePos, i).getChars(0, getWord(linePos, i).length(), temp, count);
            count += getWord(linePos, i).length();
            if (i != size - 1) {
                temp[count++] = ' ';
            }
        }
        return new String(temp);
    }

    // add a line by adding an array of string of words
    public void addLine(String[] words) {
        Line line = new Line();

        for (int i = 0; i < words.length; i++) {
            line.add(words[i]);
        }

        lines.add(line);
    }

    // add an empty line into linestorage
    public void addEmptyLine() {
        Line line = new Line();
        lines.add(line);
    }

    // delete a line a specific position
    public void deleteLine(int linePos) {
        lines.remove(linePos);
    }

    // get the number of lines in linestorage
    public int getLineCount() {
        return lines.size();
    }

}