import java.awt.BorderLayout;

import javax.swing.JFrame;

import java.util.ArrayList;

public class GUI {

	private static final int FRAME_WIDTH = 1200;
	private static final int FRAME_HEIGHT = 800;
	
	public static final int CMD_QUIT = 0;
	public static final int CMD_DONE = 1;
	public static final int CMD_ROLL = 2;
	public static final int CMD_HELP = 3;
	public static final int CMD_ANSW = 4;
	
	public static final int ERR_SYNTAX = 0;
	public static final int ERR_DOUBLE_ROLL = 1;
	public static final int ERR_NO_ROLL = 2;
	public static final int ERR_TOO_LOW = 3;

	
	private final String[] errorMessages = {
		"Error: Not a valid command.",
		"Error: Too many rolls this turn.",
		"Error: You have a roll to play.",
	};
	
	private JFrame frame = new JFrame();
	private BoardPanel boardPanel;	
	private InfoPanel infoPanel = new InfoPanel();
	private CommandPanel commandPanel = new CommandPanel();
	private String string;
	private boolean done;
	private int commandId;
	//private Board board;
	private Players players;
	private int inputNumber;
	private Player inputPlayer;

	GUI (/*Board board*/) {
	//	this.board = board;
		boardPanel = new BoardPanel(this.players);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Giuoco dell'Orca");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(boardPanel, BorderLayout.LINE_START);
		frame.add(infoPanel, BorderLayout.LINE_END);
		frame.add(commandPanel,BorderLayout.PAGE_END);
		frame.setResizable(false);
		frame.setVisible(true);
		return;
	}

	public void addPlayers(Players players){
		this.players = players;
	}

//  METHODS DEALING WITH USER INPUT
	
	public void inputName (int numPlayer) {
		for(Player p : players.get()){
			infoPanel.displayString("Enter new player name for player " + p.getId());
			commandPanel.inputString();
			p.setName(commandPanel.getString(););	
		}
	}
	
	private boolean hasNoArgument (String[] words) {
		return (words.length == 1);
	}
	
	private boolean hasOneArgument (String[] words) {
		return (words.length == 2);
	}
	
	public void inputCommand (Player player) {
		boolean inputValid = false;
		do {
			infoPanel.displayString(player + " type your command:");
			commandPanel.inputString();
			string = commandPanel.getString();
			infoPanel.displayString("> " + string);
			string = string.toLowerCase();
			string = string.trim();
			string = string.replaceAll("( )+", " ");
			String[] words = string.split(" ");
			switch (words[0]) {
				case "quit" :
					commandId = CMD_QUIT;
					inputValid = hasNoArgument(words);
					break;
				case "done" :
					commandId = CMD_DONE;
					inputValid = hasNoArgument(words);
					break;
				case "roll" :
					commandId = CMD_ROLL;
					inputValid = hasNoArgument(words);
					break;
				case "answer":
					commandId = CMD_ANSW;
					inputValid = hasOneArgument(words);
				case "help" :
					commandId = CMD_HELP;
					inputValid = hasOneArgument(words);
					inputValid = true;
					break;
				default:
					inputValid = false;
				}
			if (!inputValid) {
				displayError(ERR_SYNTAX);
			}
		} while (!inputValid);
		if (commandId == CMD_DONE) {
			done = true;
		} else {
			done = false;
		}		
		return;
	}
	
	public String getString () {
		return string; 
	}
	
	public int getCommandId () {
		return commandId;
	}
	
	public boolean isDone () {
		return done;
	}
	
	public Player getInputPlayer () {
		return inputPlayer;
	}
	
	public int getInputNumber () {
		return inputNumber;
	}
			
// DISPLAY METHODS
	
	public void display () {
		boardPanel.refresh();
		return;
	}
	
	public void displayString (String string) {
		infoPanel.displayString(string);
		return;
	}
	
	public void displayDice (Player player, Dice dice) {
		infoPanel.displayString(player + " rolls " + dice + ".");
		return;
	}
	
	public void displayRollDraw () {
		infoPanel.displayString("Draw");
		return;
	}
	
	public void displayRollWinner (Player player) {
		infoPanel.displayString(player + " wins the roll.");
		return;
	}
	
	public void displayGameOver () {
		infoPanel.displayString("GAME OVER");
		return;
	}
	
	public void displayCommandHelp () {
		infoPanel.displayString("Available commands: roll, done, quit. ");
		return;
	}
	
	public void displayError (int errorId) {
		infoPanel.displayString(errorMessages[errorId]);
		return;
	}
	
	public void displayWinner (Player player) {
		infoPanel.displayString("The winner is " + player + ".");
		return;
	}
	
	public void displayDraw (ArrayList<Player> players) {
		infoPanel.displayString("The following players drew the game " + players + ".");
		return;
	}
	
	public void rightAnswer () {
		infoPanel.displayString("The answer is correct!");
		return;
	}

	public void wrongAnswer () {
		infoPanel.displayString("The answer is wrong!");
		return;
	}
}
