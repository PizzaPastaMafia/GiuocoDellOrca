class Main{
    public static void main (String args[]) {	
		
		Gioco gioco = new Gioco();		
		gioco.inputName();
		do {
			gioco.processTurn();
			if (!gioco.isGameOver()) {
				gioco.nextPlayer();
			}
		} while (!gioco.isGameOver());
		gioco.decideWinner();
		gioco.displayGameOver();
		return;
	}
}