import java.util.ArrayList;

class Players{
    public static final int MAX_NUM_PLAYERS = 4;
    private ArrayList<Player> players = new ArrayList<Player>();

    Players(){
        return;
    }

    Players(Players players){
        for(Player p : players.get()){
            this.players.add(p);
        }
        return;
    }

    public void add(Player player){
        players.add(player);
        return;
    }

    public ArrayList<Player> get(){
        return players;
    }

    public void clear () {
		players.clear();
		return;
	}

    public int indexOf (Player player) {
		return players.indexOf(player);
	}

    public boolean canAddPlayer () {
		return players.size() < MAX_NUM_PLAYERS;
	}

    public Player get (int playerId) {
		return players.get(playerId);
	}

    public void remove (Player player) {
		players.remove(player);
	}

    public int numPlayers () {
		return players.size();
	}

    public Player getNextPlayer (Player currPlayer) {
        Player nextPlayer = get((players.indexOf(currPlayer) + 1) % players.size());
        return nextPlayer;
    }        

}