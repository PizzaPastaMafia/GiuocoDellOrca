public class Gioco {
    public static final int MAX_NUM_PLAYERS = 4;
	public static final int NUM_SQUARES = 25;

    private Players players = new Players();
	private Player currPlayer;
	private Dice dice = new Dice();
	private boolean rollDone;
    private GUI gui;
	private boolean gameOver = false;
	private boolean turnFinished;

    Gioco (String[] args) {
        for(int i = 0; i < NUM_PLAYERS; i++){
            players.add(new Player(i));
        }

		gui = new GUI();
		gui.display();
        
		return;
	}

    private void rollCommand() {
        if(!rollDone) {
            int roll = dice.roll();
            currPlayer.move(roll);
            ui.display();
            rollDone = true;
        }
        
    }

    public void processTurn () {
		turnFinished = false;
		rollDone = false;
		doubleCount = 0;
		do {
			ui.inputCommand(currPlayer);
			switch (ui.getCommandId()) {
				case UI.CMD_ROLL :
					rollCommand();
					break;
				case UI.CMD_CARD :
					cardCommand();
					break;
				case UI.CMD_HELP :
					ui.displayCommandHelp();
					break;
				case UI.CMD_DONE :
					doneCommand();
					break;
				case UI.CMD_QUIT : 
					turnFinished = true;
					gameOver = true;
					break;
			}
		} while (!turnFinished);
		return;
	}

	public void nextPlayer () {
		currPlayer = players.getNextPlayer(currPlayer);
		return;
	}

	public void prevPlayer () {
		currPlayer = players.getPrevPlayer(currPlayer);
		return;
	}
}