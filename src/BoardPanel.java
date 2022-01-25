import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

class BoardPanel extends JPanel {
	
	private static final int FRAME_WIDTH = 750;   
	private static final int FRAME_HEIGHT = 750;

    private static final int ROWS = 5;
    private static final int COLS = 5;
	
	private Players players;
    private Tile tile[] = new Tile[ROWS*COLS];


	BoardPanel (Players players) {
        setLayout(new GridLayout(ROWS, COLS));
		for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                tile[r*ROWS+c] = new Tile(r*ROWS+c, 14); 
                tile[r*ROWS+c].setPosition(r*ROWS+c);
                if(r == 0 && c == 0){
                    for(Player p : players){
                        tile[r*ROWS+c].addPlayerPresence(p);
                    }
                }
                
                add(tile[r*ROWS+c]);
            }
        }
    }

    public void refresh () {
		revalidate();
		repaint();
		return;
    }
}