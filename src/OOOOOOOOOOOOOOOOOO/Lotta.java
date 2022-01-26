
public class Lotta
{
    
    Dado D = new Dado();
    Dado D2 = new Dado();
    
    public void Lotta(Dado D, Dado D2)
    {
        this.D = D;
        this.D2 = D2;
    }
    
    public void Azione(Giocatore G1, Giocatore G2){
        
        int a, b, c, d, i;
        
        i = 0;
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        
        while(i < 3){
            
            while(a == b){
                
                D.lancia();
        
                a = D.punti();
                
                D2.lancia();
        
                b = D2.punti();
        
            }
            
            if(a > b){
                
                c++;
                
            }else{
                
                d++;
                
            }
            
            i++;
        
        }
        
        if( c > d ){
            
            G1.contaPunteggio(G2.getPunteggio());
            
            G2.setPunteggio(0);
            
        }else{
            
            G2.contaPunteggio(G1.getPunteggio());
            
            G1.setPunteggio(0);
            
        }
        
    }
}
