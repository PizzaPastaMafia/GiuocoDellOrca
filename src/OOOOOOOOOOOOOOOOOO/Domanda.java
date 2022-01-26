
public class Domanda
{
    
    private String numeroDomanda;
    private String Titolo;
    private String[] Risposte = new String[5];
    private int NumRisposta;
    private int Punti;
    
    public void Domanda(String r1, String r2, String r3, String r4, String numeroDomanda, String Titolo, int NumRisposta, int Punti){
        this.numeroDomanda=numeroDomanda;
        this.Titolo=Titolo;
        this.Risposte = new String[]{r1, r2, r3, r4};
        this.NumRisposta=NumRisposta;
        this.Punti=Punti;
    }
    
    public void setnumeroDomanda(String numeroDomanda){
        this.numeroDomanda=numeroDomanda;
    }
    
    public void setTitolo(String Titolo){
        this.Titolo=Titolo;
    }
    
    public void setRisposte(int n, String Risposta){
        this.Risposte[n] = Risposta;
    }
    
    public void setNumRisposta(int NumRisposta){
        this.NumRisposta=NumRisposta;
    }
    
    public void setPunti(int Punti){
        this.Punti = Punti;
    }
    
    public String getnumeroDomanda(){
        return numeroDomanda;
    }
    
    public String getTitolo(){
        return Titolo;
    }
    
    public String Risposte(int n){
        return Risposte[n];
    }
    
    public int getNumRisposta(){
        return NumRisposta;
    }
    
    public int getPunti(){
        return Punti;
    }
    
    public String toString() {
        return numeroDomanda + " " + Titolo + "\n" + Risposte[1] + "\n" + Risposte[2] + "\n" + Risposte[3] + "\n" + Risposte[4];
    }
}