package model;

import view.KWIC;

public class MasterControl {

    public MasterControl(KWIC kwic) {

        LineStorage lineStorage = new LineStorage();
        NoiseWordsFilter noiseWordsFilter = new NoiseWordsFilter();
        Input input = new Input();
        CircularShifter circularShifter = new CircularShifter();
        Alphabetizer alphabetizer = new Alphabetizer();
        Output output = new Output();

        input.read(kwic, lineStorage);
        // circularShifter.init(lineStorage, noiseWordsFilter);
        alphabetizer.init(lineStorage);
        // alphabetizer.init(circularShifter);
        circularShifter.init(alphabetizer, noiseWordsFilter);
        output.print(circularShifter, kwic);

    }

}