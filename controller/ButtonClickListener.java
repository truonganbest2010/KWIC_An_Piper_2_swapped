package controller;

import java.awt.event.*;
import java.time.Instant;

import model.MasterControl;
import view.KWIC;

public class ButtonClickListener implements ActionListener {

    private KWIC panel;
    private long timeStart, timeEnd, timeLapse;

    public ButtonClickListener(KWIC panel) { /** constructor */
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) { /** overriden action listeners */
        var button = e.getSource();
        if (button == panel.getComputeButton()) { /** compute button */
            timeStart = Instant.now().toEpochMilli();
            MasterControl mc = new MasterControl(this.panel);
            timeEnd = Instant.now().toEpochMilli();
            timeLapse = timeEnd - timeStart;
            System.out.println("Time of process: " + timeLapse);

        } else if (button == panel.getResetInputButton()) { /** reset input button */

            panel.getTextInputArea().setText("");
        } else if (button == panel.getResetOutputButton()) { /** reset output button */
            panel.getTextOutputArea().setText("");
        }
    }

}