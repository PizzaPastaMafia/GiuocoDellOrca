
public class UsaDomanda
{
    public static void main(String[] a) throws java.io.IOException {
        
        Domanda D = new Domanda();
        
        Giocatore G1 = new Giocatore();
        
        G1.AzzeraArray();
        
        int i = 1;
        
        while(i != 0){
            
            i = Leggi.unInt();
            
            Domandiere.InserisciValori(D, G1);
        
            System.out.print(D.toString());

        }
        
    }
}    
        