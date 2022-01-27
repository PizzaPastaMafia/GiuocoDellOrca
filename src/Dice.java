public class Dice {
    private static int punt;

    public Dice() {        
        return;
    }
    
    public int roll(int n) {
        return (int)(Math.random()*n + 1);
    }

    public int roll() {
        return roll(6);
    }
}
