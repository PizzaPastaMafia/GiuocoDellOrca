public class Main {
    public static final int NUM_PLAYERS = 2;
	public static final int NUM_SQUARES = 16;

    private Players players = new Players();
	private Player currPlayer;
	private Dice dice = new Dice();
	private boolean rollDone;
    private UI ui;
	private boolean gameOver = false;
	private boolean turnFinished;

    Main (String[] args) {
		//setupBots(args);
		players.add(new Player("Player 1", 0));
		players.add(new Player("Player 2", 1));

		ui = new UI(players, board);
		ui.display();
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