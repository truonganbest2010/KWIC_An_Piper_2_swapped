package view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.ButtonClickListener;

import java.awt.*;

public class KWIC {

    private JFrame window;

    /** textareas */
    private JTextArea textInputArea;
    private JTextArea textOutputArea;

    /** buttons */
    private JButton resetInputButton = new JButton("Reset Input");
    private JButton computeButton = new JButton("Compute");
    private JButton resetOutputButton = new JButton("Reset Output");

    public KWIC(JFrame window) { /** constructor */
        this.window = window;
    }

    public void init() { /** initialize program's GUI */
        Container cp = window.getContentPane();
        // ================//

        /** create top panel where program label locates */
        JPanel topPanel = new JPanel(new GridLayout(5, 1));

        /** program name label */
        JLabel pname = new JLabel("Key Word In Context System");
        pname.setFont(new Font("Courier New", Font.BOLD, 32));
        pname.setForeground(Color.blue);
        JPanel pnamePanel = new JPanel();
        pnamePanel.add(pname);
        topPanel.add(pnamePanel);

        /** school/university label */
        JLabel sname = new JLabel("University of Central Oklahoma");
        sname.setFont(new Font("Courier New", Font.BOLD, 32));
        JPanel snamePanel = new JPanel();
        snamePanel.add(sname);
        topPanel.add(snamePanel);

        /** group no. and members label */
        JLabel gname = new JLabel("Group 5: (An Truong & Piper Backer)");
        JPanel gnamePanel = new JPanel();
        gnamePanel.add(gname);
        topPanel.add(gnamePanel);

        /** input caution label */
        JTextArea cautionText = new JTextArea(
                "Please be aware only alphabet input is accepted. Any other input (e.g digits, symbol, etc.) will be ignored in processing");
        cautionText.setMargin(new Insets(10, 10, 10, 10));
        cautionText.setLineWrap(true);
        cautionText.setWrapStyleWord(true);
        cautionText.setEditable(false);
        cautionText.setBackground(Color.ORANGE);
        topPanel.add(cautionText);

        /** i/o label */
        JPanel ioPanel = new JPanel(new GridLayout(1, 2));
        ioPanel.add(new JLabel("Input", SwingConstants.CENTER));
        ioPanel.add(new JLabel("Output", SwingConstants.CENTER));
        topPanel.add(ioPanel);

        cp.add(BorderLayout.NORTH, topPanel);
        // ================//

        /** create i/o textarea where program input and output locate */

        /** text input area */
        Container cont = new Container();

        textInputArea = new JTextArea();
        textInputArea.setBounds(5, 5, 100, 200);

        JScrollPane scrollPane1 = new JScrollPane(textInputArea);
        scrollPane1.setBounds(3, 3, 400, 400);

        /** text output area */
        textOutputArea = new JTextArea();
        textOutputArea.setBounds(5, 5, 100, 200);

        JScrollPane scrollPane2 = new JScrollPane(textOutputArea);
        scrollPane2.setBounds(3, 3, 400, 400);

        cont.add(scrollPane1);
        cont.add(scrollPane2);
        cont.setLayout(new GridLayout(1, 2));

        window.add(cont);
        // ================//

        /** create button panel */
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetInputButton); /** reset input */
        buttonPanel.add(computeButton); /** compute */
        buttonPanel.add(resetOutputButton); /** reset output */
        cp.add(BorderLayout.SOUTH, buttonPanel);

        /** add action listeners for buttons */
        ButtonClickListener buttonClickListener = new ButtonClickListener(this);
        resetInputButton.addActionListener(buttonClickListener);
        computeButton.addActionListener(buttonClickListener);
        resetOutputButton.addActionListener(buttonClickListener);
    }

    public JButton getResetInputButton() {
        /** get input button */
        return resetInputButton;
    }

    public JButton getComputeButton() {
        /** get compute button */
        return computeButton;
    }

    public JButton getResetOutputButton() {
        /** get output button */
        return resetOutputButton;
    }

    public JTextArea getTextInputArea() {
        /** get text input area */
        return textInputArea;
    }

    public JTextArea getTextOutputArea() { /** get text ouput area */
        return textOutputArea;
    }

}