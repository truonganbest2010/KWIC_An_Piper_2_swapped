package model;

import java.util.Arrays;
import java.util.List;

public class NoiseWordsFilter {

    private List<String> noiseWords = Arrays.asList("A", "AN", "THE", "AND", "OR", "OF", "TO", "BE", "IS", "IN", "OUT",
            "BY", "AS", "AT", "OFF");

    public boolean ignoreCase(String s) {
        return (noiseWords.contains(s.toUpperCase())) ? true : false;
    }
}