import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*; 

class Tile extends JPanel{
    Players players = new Players();
    private int position = 0;
    private JLabel pos = new JLabel();
    private TileBar bar = new TileBar();
    private int id = 0;
    private boolean special = false;

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

    public int getId(){
        return id;
    }

    public boolean isSpecial(){
        return special;
    }

    public void setSpecial(int n){
        if(n == 2){
            special = true;
            setBackground(new Color(252, 6, 2));

        }
    }
    

    public void addPlayerPresence(Player p){
        bar.addColor(p.getId());
        players.add(p);
    }

    public void removePlayerPresence(Player p){
        bar.removeColor(p.getId());
        players.remove(p);
    }

    public void setPosition(int position){
        this.position = position;
        pos.setText(String.valueOf(this.position));

    } 

    public Players getPlayers(){
        return players;
    }

}

//SCRITTO DA LORENZO DEL FORNO