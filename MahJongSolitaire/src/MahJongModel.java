public class MahJongModel // extends MahJongBoard
{
    // Separate array for special cases?
    // One way or another, need separate date structure to indicate starting point, ending point, & length

    private int[][][] booleanMap = { { {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},	// Layer 0
                                    {0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
                                    {0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
                                    {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                                    {1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
                                    {0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
                                    {0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
                                    {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0}},

                                    {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},	// Layer 1
                                    {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
                                    {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
                                    {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
                                    {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
                                    {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
                                    {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}},

                                    {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},	// Layer 2
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                                    {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                                    {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                                    {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}},

                                    {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},     // Layer 3
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}},

                                    {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},     // Layer 4
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}},
    }; // End of boolMap array

    protected int xDim = 15, yDim = 8, zDim = 5;                 // Number of: columns, rows, and layers
    protected Tile[][][] tiles = new Tile[zDim + 1][yDim + 1][xDim + 1];
    private TileDeck deck = new TileDeck();
    private MahJongBoard board;

    public MahJongModel(MahJongBoard board)
    {
        this.board = board;

        if(MahJong.gameNumber == 0){deck.shuffle();}    // Random game number
        else {deck.shuffle(MahJong.gameNumber);}        // User defined game number

        for(int layer = 0; layer < zDim; layer++)
        {
            for(int column = 0; column < yDim; column++)
            {
                for(int row = 0; row < xDim; row++)
                {
                    if(booleanMap[layer][column][row] == 1)    // Draw if tile belongs in position
                    {
                        Tile t = deck.deal();
                        t.xoo = row;
                        t.yoo = column;
                        t.zoo = layer;
                        tiles[layer][column][row] = t;
                        t.addMouseListener(board);             // assume board is a pointer to MahJongBoard
                    }
                    else
                        tiles[layer][column][row] = null;      // Else, place an empty piece
                }
            }
        }
    }


    public boolean isTileOpen(int x, int y, int z)
    {

        if(x == 0 || x == 14 || x == 4)
            return true;

        return tiles[z + 1][y][x] == null &&
                (tiles[z][y][x + 1] == null || tiles[z][y][x - 1] == null);

    }

    public Tile getTile(int z, int y, int x)
    {
        return tiles[z][y][x];
    }
}
