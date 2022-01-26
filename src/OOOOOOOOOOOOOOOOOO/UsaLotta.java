
public class UsaLotta
{
    public static void main(String[] a) throws java.io.IOException {
        
        Giocatore G1 = new Giocatore();
        
        Giocatore G2 = new Giocatore();
        
        Lotta L = new Lotta();

        G1.setPunteggio(60);

        System.out.print(G1.getPunteggio() +"\n");
        
        G2.setPunteggio(80);
        
        System.out.print(G2.getPunteggio()+"\n");
        
        L.Azione(G1, G2);
        
        System.out.print(G1.getPunteggio()+"\n");
        
        System.out.print(G2.getPunteggio()+"\n");
        
    }
}    
     