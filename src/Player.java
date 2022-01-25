class Player {
    private String name;
    private int id;
    private int position;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        position = 0;
    }

    public Player(int id) {
        this.id = id;
        position = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }  

    public int getPosition() {
        return position;
    }

    public void moveBack(int p){
        move(-p);
    }

    public void move(int squares) {
        position += squares;
        /*if (position >= Main.NUM_SQUARES) {
            position = position - Main.NUM_SQUARES;
        }
        if (position < 0) {
            position = position + Main.NUM_SQUARES;
        }*/
    }

    public void moveTo (int square) {
		position = square;
		return;
	}

    public String toString () {
		return name + " (" + id + ")";
	}
}