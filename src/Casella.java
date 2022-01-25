
public class Casella {
	
    private Giocatore giocatore;
    private Casella successivo;
    private Casella precedente;
    
    private boolean imprevisto;
    private int numIdent;
    private String titolo;
    
    public Casella(int numIdent, boolean imprevisto){
    	this.numIdent = numIdent;
    	this.titolo = "casella";
    	giocatore.getCarattere();
    	this.setImprevisto(imprevisto);
    }
    
	public Casella getSuccessivo(){
        return this.successivo;
    }
    
    public void setSuccessivo(Casella successivo){
        this.successivo = successivo;
    }
    
    public Casella getPrecedente(){
        return this.precedente;
    }
    
    public String toString() {
        return numIdent + "";
    }
    
    public void setPrecedente(Casella precedente){
        this.precedente = precedente;
    }

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public int getNumIdent() {
		return numIdent;
	}

	public String getTitolo() {
		return titolo;
	}

	public boolean isImprevisto() {
		return imprevisto;
	}

	public void setImprevisto(boolean imprevisto) {
		this.imprevisto = imprevisto;
	}
}
