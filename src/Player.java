class Player {
    private String name;
    private int id;
    private int position;
    private int score = 0;
    private boolean[] array = new boolean[40];

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        position = 0;
        this.array = new boolean[40];
    }

    public Player(int id) {
        this.id = id;
        position = 0;
        this.array = new boolean[40];
    }

    public void setName(String name){
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void addPoints(int score){
        setScore(this.score + score);
    }

    public void removePoints(int score){
        setScore(this.score - score);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }  

    public int getPoints(){
        return score;
    }

    public int getPosition() {
        return position;
    }

    public void moveBack(int p){
        move(-p);
    }

    public void move(int squares) {
        position += squares;
        /*if (position >= Gioco.NUM_SQUARES) {
            position = position - Main.NUM_SQUARES;
        }
        if (position < 0) {
            position = position + Gioco.NUM_SQUARES;
        }*/
    }

    public void moveTo (int square) {
		position = square;
		return;
	}

    public void arrayInit(){
        
        for(int i = 0; i < Gioco.NUM_QUESTIONS; i++){
        
            this.array[i] = false;
        
        }
        
    }

    public void setSicurezza(int b) {
        this.array[b] = true;
    }
    
    public boolean getSicurezza(int a) {
        return array[a];
    }

    public String toString () {
		return name + " (" + id + ")";
	}
}

//SCRITTO DA LORENZO DEL FORNO CON CONTRIBUTI DA LEJILA BRKIC E RICCARDO CESARE