public class BambooTile extends RankTile
{
    public BambooTile(int rank)
    {
        // Ranks range from 2 - 9
        super(rank);

    }

    public String toString()
    {
        // Should return something like "Bamboo 7"
        return "Bamboo " + rank;
    }
}
