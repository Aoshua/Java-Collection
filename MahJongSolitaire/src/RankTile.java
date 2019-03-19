public class RankTile extends Tile
{
    protected int rank;

    public RankTile(int rank)
    {
        this.rank = rank;
    }

    public boolean matches(Tile other)
    {
        // Tests with superclass & tests fields
        return super.matches(other) && rank == ((RankTile)other).rank;
    }
}
