class Board{
    public static final int NUM_TILES = 25;
    private Tile[] tiles = new Tile[NUM_TILES];

    public Board(){
        return;
    }

    public void addTile(Tile t, int i){
        tiles[i] = t; 
    }

    public Tile getTile(int i){
        return tiles[i];
    }
}