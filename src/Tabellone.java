
public class Tabellone{
   
	private Casella primo; // riferimento al primo nodo della lista
    private Casella ultimo; // riferimento all'ultimo nodo della lista
    private int lunghezza; // numero di elementi inseriti nella lista
    //private Dado numSpazio;
    
    public Tabellone() {
        primo = null;
        ultimo = null;
        lunghezza = 0;
    }
    
    public Tabellone(int numeroCaselle) {
    	for(int i=1; i<=numeroCaselle; i++) {
    		inserisciUltimo(i);
    	}    	
    }
    
    public boolean imprevisto() {
    	
    	double casuale = (int)(Math.random()*1);
    	
    	if(casuale == 1) {
    		return true;
    	}
    	return false;
    }
    
    // verifica se la lista e' vuota
    public boolean vuota(){
        return lunghezza == 0;
    }

    public int lunghezza(){
        return lunghezza;
    }

    public int getPrimoElemento(){
        return primo.getNumIdent();
    }

    public int getUltimoElemento(){
        return ultimo.getNumIdent();
    }
    
    // Inserisce un nuovo elemento nella lista al primo posto
    public void inserisciPrimo(int elemento){
        primo = new Casella(elemento, imprevisto());
        if (vuota())
            ultimo = primo;
        lunghezza++;
    }
    
    // Inserisce un nuovo elemento nella lista in ultima posizione
    public void inserisciUltimo(int elemento){
        if (vuota()) {
            inserisciPrimo(elemento);
        }
        else {
            Casella ultimaCasella = new Casella(elemento, imprevisto());
            ultimaCasella.setSuccessivo(null);
            ultimaCasella.setPrecedente(ultimo);
            
            ultimo.setSuccessivo(ultimaCasella);

            ultimo = ultimaCasella;
            lunghezza++;
        }
    }
    
	public void spostaGiocatore(Giocatore giocatore, int numSpazio) {
    	
    	// lo elimino da li
    	 cancella(giocatore.getNumCasella());
    	 Casella n = primo;
    	
    	 //trovo la nuova casella
    	for(int i=0; i<giocatore.getNumCasella() + numSpazio; i++) {
    		if(n.getNumIdent() != lunghezza && numSpazio > 0) {
    			n = n.getSuccessivo();
    		}
    		else if (n.getNumIdent() == lunghezza || numSpazio < 0) {
    			n = n.getPrecedente();
    		}
    	}
    	 
    	if(n.getGiocatore() == null) {
    		//lo vado a mettere nella nuova casella
    		n.setGiocatore(giocatore);
    		
    		// aviso G la sua nuova posizione 
        	giocatore.setNumCasella(numSpazio);
    	}
    	else {
    		//chiamo la funzione lotta 
    	}
    }
   
	public void spostaCasella(int numeroCasella/*numIdentificativo*/, int numSpazio, boolean avanti) {
    	
		// trovata la nuova posizione
		elementoIn(numeroCasella);
		
		//bisogna colegare la casella con il successivo e il precedente della nuova posizione
		nodoIn(numeroCasella+numSpazio);
		
		//eliminare il colegamento con la vechia
		pop();
		
		Tabellone t = new Tabellone(lunghezza);
		appendi(t);
    }
	
    private Casella nodoIn(int posizione) {
        Casella res = null;
        if(posizione>=1 && posizione<lunghezza) {
          Casella n = primo;
          for(int i=1; i<posizione; i++) {
             n = n.getSuccessivo(); 
          }
          res = n;
        }
        return res;
    }
    
    // il primo elemento ha posizione 1
    public int elementoIn(int posizione) {
        int res = -1;
        Casella n = nodoIn(posizione);
        if(n!=null) {
          res = n.getNumIdent();
        }
        return res;
    }
    
    
    public void appendi(Tabellone lista2) {
        for(int i=1; i<lista2.lunghezza; i++) {
            int val = lista2.elementoIn(i);
            inserisciUltimo(val);
        }
    }
    
    public void pop() {
        // Trovo il penultimo elemento
        Casella n = nodoIn(lunghezza-1);
        // Elimino il successivo
        n.setSuccessivo(null);
        // Aggiusto le variabili
        ultimo = n;
        lunghezza--;
    }
    
    public void cancella(int posizione) {
        // Prendo l'elemento precedente alla posizione da eliminare
        Casella precedente = nodoIn(posizione-1);
        // Trovo l'elemento successivo  alla posizione da eliminare
        Casella prossimo = precedente.getSuccessivo().getSuccessivo();
        // Li collego
        precedente.setSuccessivo(prossimo);
    }
    
    public String toString() {
        String s = "";
        Casella n = primo;
        while(n != null) {
            s += n.getNumIdent() + " ";
            n = n.getSuccessivo();
        }
        return s;
    }

}
