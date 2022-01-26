
public class Giocatore{
    
    private String nome;
    private int punteggio;
    private char carattere;
    private int numCasella;
    private boolean[] array = new boolean[40];
    
    //private Domande ris;
    
    public void Giocatore(String nome, char carattere) {
        this.nome = nome;
        this.carattere = carattere;
        this.numCasella = 0;
        this.punteggio = 0;
        this.array = new boolean[40];
    }
    
    public void AzzeraArray(){
        
        for(int i = 0; i < 40; i++){
        
            this.array[i] = false;
        
        }
        
    }
    
    public void contaPunteggio(int punteggio/*i punti asociati alla domanda*/) {

        //if(ris.PosRispostaCorretta() == ris.getRisposta()) {
            this.setPunteggio(this.getPunteggio() + punteggio);
        //}else {
            //this.setPunteggio(this.getPunteggio()/2);
        //}
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
    
    public char getCarattere(){
        return carattere;
    }
    
    public void setCarattere(char carattere){
        this.carattere = carattere;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getNumCasella() {
        return numCasella;
    }

    public void setNumCasella(int numCasella) {
        this.numCasella += numCasella;
    }
    
    public void setSicurezza(int b) {
        this.array[b] = true;
    }
    
    public boolean getSicurezza(int a) {
        return array[a];
    }

}

