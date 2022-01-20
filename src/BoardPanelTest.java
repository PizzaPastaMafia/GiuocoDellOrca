import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
//import javax.swing.SpringUtilities;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*; 

public class BoardPanelTest{
    public static void main(String[] args) {
        JPanel panel = new JPanel(new SpringLayout());
        
        int rows = 10;
        int cols = 10;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int anInt = (int) Math.pow(r, c);
                JTextField textField = new JTextField(Integer.toString(anInt));
                panel.add(textField);
            }
        }
        
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(panel, //parent
        rows, cols,
        3, 3,  //initX, initY
        3, 3); //xPad, yPad
        
        //Create and set up the window.
        JFrame frame = new JFrame("SpringCompactGrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //Set up the content pane.
        panel.setOpaque(true); //content panes must be opaque
        frame.setContentPane(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    
    }

}