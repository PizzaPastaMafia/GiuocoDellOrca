 


public class Dado {
    private static int punt;

    public void Dado() {        
        tira();
    }

    public void tira() {
        punt = (int)(Math.random()*6 + 1);
    }

    public int punti() {
        return punt;
    }
} 