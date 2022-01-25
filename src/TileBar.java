import java.awt.*;
import java.applet.Applet;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*; 

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

class TileBar extends JPanel{
    private JLabel status[] = new JLabel[4];

    private ImageIcon blue = new ImageIcon(this.getClass().getResource("blue.png"));
    private ImageIcon red = new ImageIcon(this.getClass().getResource("red.png"));
    private ImageIcon yellow = new ImageIcon(this.getClass().getResource("yellow.png"));
    private ImageIcon green = new ImageIcon(this.getClass().getResource("green.png"));
    private ImageIcon empty = new ImageIcon(this.getClass().getResource("empty.png"));


    public TileBar(){
        setPreferredSize(new Dimension(150, 37));
        setLayout(new GridLayout(1, 4));
        for(int i = 0; i < 4; i++){
            status[i] = new JLabel();
            status[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(status[i]);
        }
    }

    public void addColor(int c){
        c--;
        switch(c){
            case 0:{
                status[c].setIcon(blue);
                break;
            }
            case 1:{
                status[c].setIcon(red);
                break;
            }
            case 2:{
                status[c].setIcon(yellow);
                break;
            }
            case 3:{
                status[c].setIcon(green);
                break;
            }
        }
    }

    public void removeColor(int c){
        status[c].setIcon(empty);
    }
}