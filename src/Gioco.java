import java.io.IOException;

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
	private Board board = new Board();
	private int rightAnswer;

    Gioco () {
        for(int i = 0; i < MAX_NUM_PLAYERS; i++){
            players.add(new Player(i));
        }
		currPlayer = players.get(0);

		gui = new GUI(players, board);
		gui.display();
        
		return;
	}

	public void inputName(){
		gui.inputName();
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
		for(Player p : pintile.get()){
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
					if(currPlayer.getPoints()>=50){
						currPlayer.removePoints(50);
						gui.displayLostPoints(50);
					}
					break;
				}
			}
			gui.display();

		}

		if(currPlayer.getPosition() == 40){
			gameOver = true;
		}
	}

	public void askQuestion() throws java.io.IOException{
		Domanda d = new Domanda();
		
		Domandiere.InserisciValori(d, currPlayer);
		gui.displayString(d.toString());
		rightAnswer = d.getNumRisposta();
		
		if(gui.getInputNumber() == rightAnswer){
			gui.displayRightAnswer();
			currPlayer.addPoints(100);
		} else {
			gui.displayWrongAnswer();
			if(currPlayer.getPoints()>=50){
				currPlayer.removePoints(50);
				gui.displayLostPoints(50);
			} else{
				currPlayer.removePoints(currPlayer.getPoints());
				gui.displayString("you lost all your points");
			}
		}

	}

    private void rollCommand() {
        if(!rollDone) {
            int roll = dice.roll();
			gui.displayDice(currPlayer, roll);
            currPlayer.move(roll);
            gui.display();
			tileArrival();
			try{
				askQuestion();
			}	catch (IOException e){
				e.printStackTrace();
			}
            gui.display();
            rollDone = true;
        } else{
			gui.displayError(GUI.ERR_DOUBLE_ROLL);
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
					answerCommand();
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
			gui.displayError(GUI.ERR_NO_ROLL);
		}
	}

	public void answerCommand(){
		
	}

	public void decideWinner(){	
		Player winner = new Player(5);
		int points = 0;
		currPlayer.addPoints(500);
		
		for(Player p : players.get()){
			if(p.getPoints() > points){
				winner = p;
				points = p.getPoints();
			}	
		}
		gui.displayWinner(winner);
		
	}

	public boolean isGameOver(){
		return gameOver;
	}

	public void displayGameOver(){
		gui.displayGameOver();
	}

	public void nextPlayer () {
		currPlayer = players.getNextPlayer(currPlayer);
		return;
	}
}

//SCRITTO DA LORENZO DEL FORNO
//METODI fight() E fightRoll() SRITTI DA LORENZO DEL FORNO CON CONTRIBUTO DA RICCARDO CESARE