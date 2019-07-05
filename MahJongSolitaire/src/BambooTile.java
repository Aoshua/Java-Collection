import javax.swing.*;
import java.awt.*;

public class BambooTile extends RankTile
{
    private Bamboo[] bamboos;
    private int width = 8;
    private int height = 20;

    public BambooTile(int rank)
    {
        // Ranks range from 2 - 9
        super(rank);
        setToolTipText(toString());
        bamboos = new Bamboo[rank];

        switch(rank)
        {
            case 1:
                // Call bamboo 1
                break;

            case 2:
                bamboos[0] = new Bamboo();
                bamboos[0].x = (TILE_WIDTH/2) - (width/2);
                bamboos[0].y = (TILE_HEIGHT/3) - (height/2);
                bamboos[0].color = LIGHT_GREEN;

                bamboos[1] = new Bamboo();
                bamboos[1].x = (TILE_WIDTH/2) - (width/2);
                bamboos[1].y = (TILE_HEIGHT/3) + (height - (height/2) + 16);
                bamboos[1].color = BLOOD_RED;
                break;

            case 3:
                bamboos[0] = new Bamboo();
                bamboos[0].x = (TILE_WIDTH/4) - (width/2);
                bamboos[0].y = (TILE_HEIGHT/4) - (height/2);
                bamboos[0].color = Color.BLUE;

                bamboos[1] = new Bamboo();
                bamboos[1].x = (TILE_WIDTH/2) - (width/2);
                bamboos[1].y = (TILE_HEIGHT/2) - (height/2);
                bamboos[1].color = BLOOD_RED;

                bamboos[2] = new Bamboo();
                bamboos[2].x = (TILE_WIDTH/4)*3 - (width/2);
                bamboos[2].y = (TILE_HEIGHT/4)*3 - (height/2);
                bamboos[2].color = LIGHT_GREEN;
                break;

            case 4:
                bamboos[0] = new Bamboo();
                bamboos[0].x = (TILE_WIDTH/3) - (width/2);
                bamboos[0].y = (TILE_HEIGHT/3) - (height/2);
                bamboos[0].color = Color.BLUE;

                bamboos[1] = new Bamboo();
                bamboos[1].x = (TILE_WIDTH/3)*2 - (width/2);
                bamboos[1].y = (TILE_HEIGHT/3)*2 - (height/2);
                bamboos[1].color = Color.BLUE;

                bamboos[2] = new Bamboo();
                bamboos[2].x = bamboos[0].x;
                bamboos[2].y = bamboos[1].y;
                bamboos[2].color = LIGHT_GREEN;

                bamboos[3] = new Bamboo();
                bamboos[3].x = bamboos[1].x;
                bamboos[3].y = bamboos[0].y;
                bamboos[3].color = LIGHT_GREEN;
                break;

            case 5:
                bamboos[0] = new Bamboo();
                bamboos[0].x = (TILE_WIDTH/4) - (width/2);
                bamboos[0].y = (TILE_HEIGHT/4) - (height/2);
                bamboos[0].color = Color.BLUE;

                bamboos[1] = new Bamboo();
                bamboos[1].x = (TILE_WIDTH/2) - (width/2);
                bamboos[1].y = (TILE_HEIGHT/2) - (height/2);
                bamboos[1].color = BLOOD_RED;

                bamboos[2] = new Bamboo();
                bamboos[2].x = (TILE_WIDTH/4)*3 - (width/2);
                bamboos[2].y = (TILE_HEIGHT/4)*3 - (height/2);
                bamboos[2].color = Color.BLUE;

                bamboos[3] = new Bamboo();
                bamboos[3].x = bamboos[2].x;
                bamboos[3].y = bamboos[0].y;
                bamboos[3].color = LIGHT_GREEN;

                bamboos[4] = new Bamboo();
                bamboos[4].x = bamboos[0].x;
                bamboos[4].y = bamboos[2].y;
                bamboos[4].color = LIGHT_GREEN;
                break;

            case 6:
                bamboos[0] = new Bamboo();
                bamboos[0].x = (TILE_WIDTH/4) - (width/2);
                bamboos[0].y = (TILE_HEIGHT/3) - (height/2);
                bamboos[0].color = LIGHT_GREEN;

                bamboos[1] = new Bamboo();
                bamboos[1].x = (TILE_WIDTH/2) - (width/2);
                bamboos[1].y = bamboos[0].y;
                bamboos[1].color = LIGHT_GREEN;

                bamboos[2] = new Bamboo();
                bamboos[2].x = (TILE_WIDTH/4)*3 - (width/2);
                bamboos[2].y = bamboos[0].y;
                bamboos[2].color = LIGHT_GREEN;

                bamboos[3] = new Bamboo();
                bamboos[3].x =  bamboos[0].x;
                bamboos[3].y = (TILE_HEIGHT/3)*2 - (height/2);
                bamboos[3].color = Color.BLUE;

                bamboos[4] = new Bamboo();
                bamboos[4].x = bamboos[1].x;
                bamboos[4].y = bamboos[3].y;
                bamboos[4].color = Color.BLUE;

                bamboos[5] = new Bamboo();
                bamboos[5].x = bamboos[2].x;
                bamboos[5].y = bamboos[3].y;
                bamboos[5].color = Color.BLUE;
                break;

            case 7:
                bamboos[0] = new Bamboo();
                bamboos[0].x = (TILE_WIDTH/4) - (width/2);
                bamboos[0].y = (TILE_HEIGHT/3) + 6;
                bamboos[0].color = LIGHT_GREEN;

                bamboos[1] = new Bamboo();
                bamboos[1].x = (TILE_WIDTH/2) - (width/2);
                bamboos[1].y = bamboos[0].y;
                bamboos[1].color = Color.BLUE;

                bamboos[2] = new Bamboo();
                bamboos[2].x = (TILE_WIDTH/4)*3 - (width/2);
                bamboos[2].y = bamboos[0].y;
                bamboos[2].color = LIGHT_GREEN;

                bamboos[3] = new Bamboo();
                bamboos[3].x =  bamboos[0].x;
                bamboos[3].y = (TILE_HEIGHT/3)*2 + 6;
                bamboos[3].color = LIGHT_GREEN;

                bamboos[4] = new Bamboo();
                bamboos[4].x = bamboos[1].x;
                bamboos[4].y = bamboos[3].y;
                bamboos[4].color = Color.BLUE;

                bamboos[5] = new Bamboo();
                bamboos[5].x = bamboos[2].x;
                bamboos[5].y = bamboos[3].y;
                bamboos[5].color = LIGHT_GREEN;

                bamboos[6] = new Bamboo();
                bamboos[6].x = (TILE_WIDTH/2) - (width/2);
                bamboos[6].y = (TILE_HEIGHT/3) - (height + 6);
                bamboos[6].color = BLOOD_RED;
                break;

            case 8:
                bamboos[0] = new Bamboo();
                bamboos[0].x = (TILE_WIDTH/4) - (width - 6);
                bamboos[0].y = (TILE_HEIGHT/4) - 18;
                bamboos[0].color = LIGHT_GREEN;

                bamboos[1] = new Bamboo();
                bamboos[1].x = (TILE_WIDTH/2) - (width - 8);
                bamboos[1].y = bamboos[0].y;
                bamboos[1].color = LIGHT_GREEN;

                bamboos[2] = new Bamboo();
                bamboos[2].x = (TILE_WIDTH/4)*3 - (width - 12);
                bamboos[2].y = bamboos[0].y;
                bamboos[2].color = LIGHT_GREEN;

                bamboos[3] = new Bamboo();
                bamboos[3].x = bamboos[0].x;
                bamboos[3].y = (TILE_HEIGHT/4) + height + 28;
                bamboos[3].color = Color.BLUE;

                bamboos[4] = new Bamboo();
                bamboos[4].x = bamboos[1].x;
                bamboos[4].y = bamboos[3].y;
                bamboos[4].color = Color.BLUE;

                bamboos[5] = new Bamboo();
                bamboos[5].x = bamboos[2].x;
                bamboos[5].y = bamboos[3].y;
                bamboos[5].color = Color.BLUE;

                bamboos[6] = new Bamboo();
                bamboos[6].x = (TILE_WIDTH/2) - (width/2) - 7;
                bamboos[6].y = (TILE_HEIGHT/3) + 6;
                bamboos[6].color = BLOOD_RED;

                bamboos[7] = new Bamboo();
                bamboos[7].x = (TILE_WIDTH/2) + (width/2) + 6;
                bamboos[7].y = bamboos[6].y;
                bamboos[7].color = BLOOD_RED;
                break;

            case 9:
                bamboos[0] = new Bamboo();
                bamboos[0].x = (TILE_WIDTH/4) - (width/2);
                bamboos[0].y = (TILE_HEIGHT/4) - 18;
                bamboos[0].color = BLOOD_RED;

                bamboos[1] = new Bamboo();
                bamboos[1].x = (TILE_WIDTH/2) - (width/2);
                bamboos[1].y = bamboos[0].y;
                bamboos[1].color = Color.BLUE;

                bamboos[2] = new Bamboo();
                bamboos[2].x = (TILE_WIDTH/4)*3 - (width/2);
                bamboos[2].y = bamboos[0].y;
                bamboos[2].color = LIGHT_GREEN;

                bamboos[3] = new Bamboo();
                bamboos[3].x = bamboos[0].x;
                bamboos[3].y = (TILE_HEIGHT/3) + 6;
                bamboos[3].color = BLOOD_RED;

                bamboos[4] = new Bamboo();
                bamboos[4].x = bamboos[1].x;
                bamboos[4].y = bamboos[3].y;
                bamboos[4].color = Color.BLUE;

                bamboos[5] = new Bamboo();
                bamboos[5].x = bamboos[2].x;
                bamboos[5].y = bamboos[3].y;
                bamboos[5].color = LIGHT_GREEN;

                bamboos[6] = new Bamboo();
                bamboos[6].x = bamboos[0].x;
                bamboos[6].y = (TILE_HEIGHT/4) + height + 28;
                bamboos[6].color = BLOOD_RED;

                bamboos[7] = new Bamboo();
                bamboos[7].x = bamboos[1].x;
                bamboos[7].y = bamboos[6].y;
                bamboos[7].color = Color.BLUE;

                bamboos[8] = new Bamboo();
                bamboos[8].x = bamboos[2].x;
                bamboos[8].y = bamboos[6].y;
                bamboos[8].color = LIGHT_GREEN;
                break;

            default: System.err.println("Value is out of bounds: " + rank);
                break;
        }

    }

    @Override public String toString()
    {
        // Should return something like "Bamboo 7"
        return "Bamboo " + rank;
    }

    public class Bamboo
    {
        private int x, y;
        private Color color;

        public void draw(Graphics g)
        {
            Graphics2D	gs = (Graphics2D)g;

            Polygon bambooShape = new Polygon();
            bambooShape.addPoint(x, y);
            bambooShape.addPoint(x - 5, y + 6);
            bambooShape.addPoint(x, y + 6);
            bambooShape.addPoint(x, y + 11);
            bambooShape.addPoint(x - 5, y + 17);
            bambooShape.addPoint(x, y + 17);
            bambooShape.addPoint(x, y + 22);
            bambooShape.addPoint(x - 5, y + 28);
            bambooShape.addPoint(x, y + 28);
            bambooShape.addPoint(x, y + 31);
            bambooShape.addPoint(x + 5, y + 31);
            bambooShape.addPoint(x + 5, y + 28);
            bambooShape.addPoint(x + 10, y + 28);
            bambooShape.addPoint(x + 5, y + 22);
            bambooShape.addPoint(x + 5, y + 17);
            bambooShape.addPoint(x + 10, y + 17);
            bambooShape.addPoint(x + 5, y + 11);
            bambooShape.addPoint(x + 5, y + 6);
            bambooShape.addPoint(x + 10, y + 6);
            bambooShape.addPoint(x + 5, y);

            gs.setPaint(color);
            gs.fill(bambooShape);

            g.setColor(Color.WHITE);
            g.drawLine(x + 3, y + 3, x + 3, y + 11);
            g.drawLine(x + 3, y + 15, x + 3, y + 22);
        }

    }

    @Override public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (Bamboo b : bamboos)
        {
            if(b != null)
                b.draw(g);
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bamboo Tiles");

        frame.add(new BambooTile(2));
        frame.add(new BambooTile(3));
        frame.add(new BambooTile(4));
        frame.add(new BambooTile(5));
        frame.add(new BambooTile(6));
        frame.add(new BambooTile(7));
        frame.add(new BambooTile(8));
        frame.add(new BambooTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}

