import java.awt.*;
import java.applet.Applet;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*; 

import java.awt.GridLayout;

class Tile extends JPanel{
    private int position = 0;
    private JLabel pos = new JLabel();
    private TileBar bar = new TileBar();
    private int id = 0;

    public Tile(int position, int id){
        setLayout(new BorderLayout());
        pos.setHorizontalAlignment(SwingConstants.CENTER);
        pos.setVerticalAlignment(SwingConstants.CENTER);
        pos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pos, BorderLayout.CENTER);
        add(bar, BorderLayout.SOUTH);
        setBackground(new Color(0, 188, 140));

        setPosition(position);
        this.id = id;
    }
    

    public void addPlayerPresence(Player p){
        bar.addColor(p.getId());
    }

    public void removePlayerPresence(Player p){
        bar.removeColor(p.getId());

    }

    public void setPosition(int position){
        this.position = position;
        pos.setText(String.valueOf(this.position));

    } 

}