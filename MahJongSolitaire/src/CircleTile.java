public class CircleTile extends RankTile
{

    public CircleTile(int rank)
    {
        // Ranks range from 1 - 9
        super(rank);
    }

    public String toString()
    {
        // Returns something like "Circle 5"
        return "Circle " + rank;
    }
}
