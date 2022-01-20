import java.awt.BorderLayout;

import javax.swing.JFrame;

import java.util.ArrayList;

public class GUI {

	private static final int FRAME_WIDTH = 1200;
	private static final int FRAME_HEIGHT = 800;

	public static final String CURRENCY = " pounds";
	public static final String CURRENCY_SYMBOL = "£";
	
	public static final int CMD_QUIT = 0;
	public static final int CMD_DONE = 1;
	public static final int CMD_ROLL = 2;
	public static final int CMD_HELP = 3;
	public static final int CMD_CARD = 4;
	
	public static final int ERR_SYNTAX = 0;
	public static final int ERR_DOUBLE_ROLL = 1;
	public static final int ERR_NO_ROLL = 2;
	public static final int ERR_TOO_LOW = 9;

	
	private final String[] errorMessages = {
	};
	
	private JFrame frame = new JFrame();
	private BoardPanel boardPanel;	
	private InfoPanel infoPanel = new InfoPanel();
	private CommandPanel commandPanel = new CommandPanel();
	private String string;
	private boolean done;
	private int commandId;
	private Board board;
	private Players players;
	private int inputNumber;
	private Player inputPlayer;

	GUI (Players players, Board board) {
		this.players = players;
		this.board = board;
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

//  METHODS DEALING WITH USER INPUT
	
	public void inputName (int numPlayer) {
		if (numPlayer == 0) {
			infoPanel.displayString("Enter new player name (" + boardPanel.getTokenName(numPlayer) + "):");			
		} else {
			infoPanel.displayString("Enter new player name (" + boardPanel.getTokenName(numPlayer)  +  ") or done:");
		}
		if (numPlayer < Monopoly.NUM_PLAYERS) {
			done = false;
		} else if (numPlayer == Monopoly.NUM_PLAYERS) {
			string = "DONE";
			done = true;
		}
		infoPanel.displayString("> " + string);
		return;
	}
	
	private boolean hasNoArgument (String[] words) {
		return (words.length == 1);
	}
	
	private boolean hasOneArgument (String[] words) {
		return (words.length == 2);
	}	

	private boolean hasTwoArguments (String[] words) {
		return (words.length==3);
	}

	private boolean hasThreeArguments (String[] words) {
		return (words.length==4);
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
				case "card":
					commandId = CMD_CARD;
					inputValid = true;
					break;
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
	
	public String getTokenName (int tokenId) {
		return boardPanel.getTokenName(tokenId);
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
		infoPanel.displayString("Comandi disponibili: roll, buy, pay rent, build, demolish, mortgage, redeem, bankrupt, property, balance, done, loan, quit. ");
		return;
	}
	
	public void displayError (int errorId) {
		infoPanel.displayString(errorMessages[errorId]);
		return;
	}
	
	public void displayPassedGo (Player player) {
		infoPanel.displayString(player + " passed Go.");
		return;
	}
	
	public void displaySquare (Player player) {
		Square square = board.getSquare(player.getPosition());
		infoPanel.displayString(player + " arrives at " + square.getName() + ".");
		if (square instanceof Property) {
			Property property = (Property) square;
			if (property.isOwned()) {
				infoPanel.displayString("The property is owned by " + property.getOwner() + ".");				
			} else {
				infoPanel.displayString("The property is not owned.");								
			}
		}
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
	
	public void displayCard (Card card) {
		infoPanel.displayString("The card says: " + card);
		return;
	}
	
	public void displayThreeDoubles (Player player) {
		infoPanel.displayString(player + " rolled three doubles. Go to Jail.");
		return;
	}
}
