import java.awt.Dimension;

import javax.swing.JFrame;

import view.KWIC;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("KWIC - An Truong & Piper Backer");
        window.setMinimumSize(new Dimension(640, 800));
        window.setPreferredSize(new Dimension(640, 800));
        // window.setResizable(false);
        var menu = new KWIC(window);
        menu.init();

        window.pack();
        window.setVisible(true);

    }
}