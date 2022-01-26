public class Gioco {
    public static final int MAX_NUM_PLAYERS = 4;
	public static final int NUM_SQUARES = 25;

	public static final int NUM_QUESTIONS = 40;

    private Players players = new Players();
	private Player currPlayer;
	private Dice dice = new Dice();
	private boolean rollDone;
    private GUI gui;
	private boolean gameOver = false;
	private boolean turnFinished;

    Gioco (String[] args) {
        for(int i = 0; i < MAX_NUM_PLAYERS; i++){
            players.add(new Player(i));
        }

		gui = new GUI();
		gui.display();
        
		return;
	}

	private int fightRoll(Player p){
		boolean valid = false;
		int roll;
		int tot = 0;
		gui.displayString(p + " , is your turn to roll");
		
		do{
			gui.inputCommand(p);
			if(gui.getCommandId() != GUI.CMD_ROLL){
				gui.displayString("It's not the right time to do that. C'mon, roll");
			} else{
				for(int i = 0; i < 3; i++){
					roll = dice.roll();
					tot += roll;
					gui.displayDice(p, roll);
				}
				valid = true;
			}
		}while(!valid);
		return tot;
	}

	private void fight(Player p){
		boolean draw = false;
		int playerTot = 0;
		int playerTot1 = 0;

		
		gui.displayString("Fight!");
		

		playerTot = fightRoll(currPlayer);
		playerTot1 = fightRoll(p);

		do{
			if(playerTot > playerTot1){
				gui.displayRollWinner(currPlayer);
				currPlayer.addPoints((int)(p.getPoints() / 2));
				p.removePoints((int)(p.getPoints() / 2));

				draw = false;
			} else if(playerTot1 > playerTot){
				gui.displayRollWinner(p);
				p.addPoints((int)(currPlayer.getPoints() / 2));
				currPlayer.removePoints((int)(currPlayer.getPoints() / 2));
				draw = false;
			} else {
				gui.displayRollDraw();
				draw = true;
			}
		}while(!draw);
	}

	private void tileArrival () {
		Players pintile;
		Tile tile = board.getTile(currPlayer.getPosition());
		tile.addPlayerPresence(currPlayer);
		pintile = tile.getPlayers();
		for(Player p : pintile){
			if(!(p == currPlayer)){
				fight(p);
			}

		}

		if(tile.isSpecial()){
			int rand =(int)(Math.random()*(1-4+1)+1);
			switch(rand){	
				case 1:{
					currPlayer.move(5);
					gui.displayString("You going forward 5 tiles");
					break;
				}
				case 2:{
					currPlayer.move(-5);
					gui.displayString("You going back 5 tiles");
					break;
				}
				case 3:{
					currPlayer.addPoints(100);
					gui.displayLostPoints(100);
					break;
				}
				case 4:{
					if(currPlayer.getScore()>=50){
						currPlayer.removePoints(50);
						gui.displayLostPoints(50);
					}
					break;
				}
			}
			gui.display();

		}
	}

    private void rollCommand() {
        if(!rollDone) {
            int roll = dice.roll();
			gui.displayDice(currPlayer, roll);
            currPlayer.move(roll);
            gui.display();
			tileArrival();
			gui.displayQuestion(currPlayer);
            gui.display();
            rollDone = true;
        }
        
    }

    public void processTurn () {
		turnFinished = false;
		rollDone = false;
		do {
			gui.inputCommand(currPlayer);
			switch (gui.getCommandId()) {
				case GUI.CMD_ROLL :{
					rollCommand();
					break;
				}
				case GUI.CMD_ANSW :{
					
					break;
				}
				case GUI.CMD_HELP :{
					gui.displayCommandHelp();
					break;
				}
				case GUI.CMD_DONE :{
					doneCommand();
					break;
				}
				case GUI.CMD_QUIT :{ 
					turnFinished = true;
					gameOver = true;
					break;
				}
			}
		} while (!turnFinished);
		return;
	}

	private void doneCommand(){
		if(rollDone){
			turnFinished = true;
		} else {
			gui.displayError(UI.ERR_NO_ROLL);
		}
	}

	public void askQuestion(){
		
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

//SCRITTO DA LORENZO DEL FORNO
//METODI fight() E fightRoll() SRITTI DA LORENZO DEL FORNO CON CONTRIBUTO DA RICCARDO CESARE