import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardPanelTest{
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Othello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        int rows = 5;
        int cols = 5;
        Tile tile[] = new Tile[rows*cols];
        Player p = new Player("lmao", 2);

        
        JPanel panel = new JPanel(new GridLayout(rows, cols));
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                tile[r*rows+c] = new Tile(r*rows+c, 14); 
                tile[r*rows+c].setPosition(r*rows+c);
                tile[r*rows+c].addPlayerPresence(p);
                panel.add(tile[r*rows+c]);
            }
        }
        
        frame.add(panel);
        frame.setVisible(true);
    
    }

}