import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

import java.lang.Math;   

class BoardPanel extends JPanel {
	
	private static final int FRAME_WIDTH = 750;   
	private static final int FRAME_HEIGHT = 750;

    private static final int ROWS = 5;
    private static final int COLS = 5;
	
	private Players players;
    private Tile tile[] = new Tile[ROWS*COLS];
    private Board board;


	BoardPanel (Players players, Board board) {
        this.board = board;
        setLayout(new GridLayout(ROWS, COLS));
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                tile[r*ROWS+c] = new Tile(r*ROWS+c, 14); 
                tile[r*ROWS+c].setSpecial((int)(Math.random() * 4 ));
                tile[r*ROWS+c].setPosition(r*ROWS+c);
                if(r == 0 && c == 0){
                    for(Player p : players.get()){
                        tile[r*ROWS+c].addPlayerPresence(p);
                    }
                }
                this.board.addTile(tile[r*ROWS+c], r*ROWS+c);
                add(tile[r*ROWS+c]);
            }
        }
    }

    public void refresh () {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                tile[r*ROWS+c].revalidate();
                tile[r*ROWS+c].repaint();
            }
        }

		revalidate();
		repaint();
		return;
    }
}

//SCRITTO DA LORENZO DEL FORNO