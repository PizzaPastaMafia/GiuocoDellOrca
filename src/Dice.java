public class Dice {
    private static int punt;

    public void Dice() {        
        roll();
    }
    
    public int roll(int n) {
        return (int)(Math.random()*n + 1);
    }

    public void roll() {
        roll(6);
    }
} 
