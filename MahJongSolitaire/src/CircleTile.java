import javax.swing.*;
import java.awt.*;

public class CircleTile extends RankTile
{
    private Circle[] circles;
    private int xDim = 80;
    private int yDim = 118;
    private int diameter = 20;

    public CircleTile(int rank)
    {
        // Ranks range from 1 - 9
        super(rank);
        setToolTipText(toString());
        circles = new Circle[rank];

        switch(rank)
        {
            case 1:
                circles[0] = new Pancake();
                circles[0].x = (xDim/2) - (diameter/2);
                circles[0].y = (yDim/2) - (diameter/2);
                circles[0].color = BLOOD_RED;
                break;

            case 2:
                diameter *= 2;
                circles[0] = new Circle();
                circles[0].x = (xDim/2) - (diameter/2);
                circles[0].y = (yDim/3) - (diameter/2);
                circles[0].color = LIGHT_GREEN;

                circles[1] = new Circle();
                circles[1].x = (xDim/2) - (diameter/2);
                circles[1].y = (yDim/3) + (diameter - (diameter/2) + 3);
                circles[1].color = BLOOD_RED;
                break;

            case 3:
                diameter = (diameter*2) - (rank*2);
                circles[0] = new Circle();
                circles[0].x = (xDim/4) - (diameter/2);
                circles[0].y = (yDim/4) - (diameter/2);
                circles[0].color = Color.BLUE;

                circles[1] = new Circle();
                circles[1].x = (xDim/2) - (diameter/2);
                circles[1].y = (yDim/2) - (diameter/2);
                circles[1].color = BLOOD_RED;

                circles[2] = new Circle();
                circles[2].x = (xDim/4)*3 - (diameter/2);
                circles[2].y = (yDim/4)*3 - (diameter/2);
                circles[2].color = LIGHT_GREEN;
                break;

            case 4:
                diameter = (diameter*2) - (rank*4);
                circles[0] = new Circle();
                circles[0].x = (xDim/3) - (diameter/2);
                circles[0].y = (yDim/3) - (diameter/2);
                circles[0].color = Color.BLUE;

                circles[1] = new Circle();
                circles[1].x = (xDim/3)*2 - (diameter/2);
                circles[1].y = (yDim/3)*2 - (diameter/2) - (diameter /4);
                circles[1].color = Color.BLUE;

                circles[2] = new Circle();
                circles[2].x = circles[0].x;
                circles[2].y = circles[1].y;
                circles[2].color = LIGHT_GREEN;

                circles[3] = new Circle();
                circles[3].x = circles[1].x;
                circles[3].y = circles[0].y;
                circles[3].color = LIGHT_GREEN;
                break;

            case 5:
                diameter = (diameter*2) - (rank*2);
                circles[0] = new Circle();
                circles[0].x = (xDim/4) - (diameter/2);
                circles[0].y = (yDim/4) - (diameter/2);
                circles[0].color = Color.BLUE;

                circles[1] = new Circle();
                circles[1].x = (xDim/2) - (diameter/2);
                circles[1].y = (yDim/2) - (diameter/2);
                circles[1].color = BLOOD_RED;

                circles[2] = new Circle();
                circles[2].x = (xDim/4)*3 - (diameter/2);
                circles[2].y = (yDim/4)*3 - (diameter/2);
                circles[2].color = Color.BLUE;

                circles[3] = new Circle();
                circles[3].x = circles[2].x;
                circles[3].y = circles[0].y;
                circles[3].color = LIGHT_GREEN;

                circles[4] = new Circle();
                circles[4].x = circles[0].x;
                circles[4].y = circles[2].y;
                circles[4].color = LIGHT_GREEN;
                break;

            case 6:
                diameter = (diameter*2) - (rank*3);
                circles[0] = new Circle();
                circles[0].x = (xDim/3) - (diameter/2);
                circles[0].y = (yDim/3) - (diameter);
                circles[0].color = LIGHT_GREEN;

                circles[1] = new Circle();
                circles[1].x = (xDim/3)*2 - (diameter/2);
                circles[1].y = (yDim/3)*2 - (diameter+8);
                circles[1].color = BLOOD_RED;

                circles[2] = new Circle();
                circles[2].x = circles[0].x;
                circles[2].y = circles[1].y;
                circles[2].color = BLOOD_RED;

                circles[3] = new Circle();
                circles[3].x = circles[1].x;
                circles[3].y = circles[0].y;
                circles[3].color = LIGHT_GREEN;

                circles[4] = new Circle();
                circles[4].x = circles[0].x;
                circles[4].y = (circles[1].y) + 30;
                circles[4].color = BLOOD_RED;

                circles[5] = new Circle();
                circles[5].x = circles[1].x;
                circles[5].y = (circles[1].y) + 30;
                circles[5].color = BLOOD_RED;
                break;

            case 7:
                diameter = (diameter*2) - (rank*3);
                circles[0] = new Circle();
                circles[0].x = (xDim/4) - (diameter/2);
                circles[0].y = (yDim/8) - (diameter/2 - 6);
                circles[0].color = LIGHT_GREEN;

                circles[1] = new Circle();
                circles[1].x = (xDim/2) - (diameter/2);
                circles[1].y = (yDim/4) - (diameter/2 - 4);
                circles[1].color = LIGHT_GREEN;

                circles[2] = new Circle();
                circles[2].x = (xDim/4)*3 - (diameter/2);
                circles[2].y = (yDim/8)*3 - (diameter/2 - 4);
                circles[2].color = LIGHT_GREEN;

                circles[3] = new Circle();
                circles[3].x = (xDim/3) - (diameter/2);
                circles[3].y = (circles[1].y) + 35;
                circles[3].color = BLOOD_RED;

                circles[4] = new Circle();
                circles[4].x = (xDim/3)*2 - (diameter/2);
                circles[4].y = circles[3].y;
                circles[4].color = BLOOD_RED;

                circles[5] = new Circle();
                circles[5].x = circles[3].x;
                circles[5].y = (circles[1].y) + 60;
                circles[5].color = BLOOD_RED;

                circles[6] = new Circle();
                circles[6].x = circles[4].x;
                circles[6].y = circles[5].y;
                circles[6].color = BLOOD_RED;
                break;

            case 8:
                diameter = (diameter*2) - (rank*2);
                circles[0] = new Circle();
                circles[0].x = (xDim/3) - (diameter/2);
                circles[0].y = (yDim/3) - (diameter+4);
                circles[0].color = Color.BLUE;

                circles[1] = new Circle();
                circles[1].x = (xDim/3)*2 - (diameter/2);
                circles[1].y = (yDim/3)*2 - (diameter+18);
                circles[1].color = Color.BLUE;

                circles[2] = new Circle();
                circles[2].x = circles[0].x;
                circles[2].y = circles[1].y;
                circles[2].color = Color.BLUE;

                circles[3] = new Circle();
                circles[3].x = circles[1].x;
                circles[3].y = circles[0].y;
                circles[3].color = Color.BLUE;

                circles[4] = new Circle();
                circles[4].x = circles[0].x;
                circles[4].y = (circles[1].y) + 26;
                circles[4].color = Color.BLUE;

                circles[5] = new Circle();
                circles[5].x = circles[1].x;
                circles[5].y = circles[4].y;
                circles[5].color = Color.BLUE;

                circles[6] = new Circle();
                circles[6].x = circles[0].x;
                circles[6].y = (circles[1].y) + 50;
                circles[6].color = Color.BLUE;

                circles[7] = new Circle();
                circles[7].x = circles[1].x;
                circles[7].y = circles[6].y;
                circles[7].color = Color.BLUE;
                break;

            case 9:
                diameter = (diameter*2) - (rank*2);
                circles[0] = new Circle();
                circles[0].x = (xDim/4) - (diameter/2) - 4;
                circles[0].y = (yDim/4) - (diameter/2);
                circles[0].color = LIGHT_GREEN;

                circles[1] = new Circle();
                circles[1].x = (xDim/2) - (diameter/2);
                circles[1].y = circles[0].y;
                circles[1].color = LIGHT_GREEN;

                circles[2] = new Circle();
                circles[2].x = (xDim/4)*3 - (diameter/2) + 4;
                circles[2].y = circles[0].y;
                circles[2].color = LIGHT_GREEN;

                circles[3] = new Circle();
                circles[3].x = circles[0].x;
                circles[3].y = (yDim/2) - (diameter/2);
                circles[3].color = BLOOD_RED;

                circles[4] = new Circle();
                circles[4].x = circles[1].x;
                circles[4].y = circles[3].y;
                circles[4].color = BLOOD_RED;

                circles[5] = new Circle();
                circles[5].x = circles[2].x;
                circles[5].y = circles[3].y;
                circles[5].color = BLOOD_RED;

                circles[6] = new Circle();
                circles[6].x = circles[0].x;
                circles[6].y = (yDim/4)*3 - (diameter/2);
                circles[6].color = Color.BLUE;

                circles[7] = new Circle();
                circles[7].x = circles[1].x;
                circles[7].y = circles[6].y;
                circles[7].color = Color.BLUE;

                circles[8] = new Circle();
                circles[8].x = circles[2].x;
                circles[8].y = circles[6].y;
                circles[8].color = Color.BLUE;
                break;

            default: System.err.println("Value is out of bounds: " + rank);
                break;
        }
    }

    public String toString()
    {
        // Returns something like "Circle 5"
        return "Circle " + rank;
    }


    public class Circle
    {
        private int x, y;
        private Color color;

        public void draw(Graphics g)
        {
            g.setColor(color);
            g.fillOval(x, y, diameter, diameter);

            // Shell design
            g.setColor(Color.WHITE);
            //g.drawOval(x+(diameter/4), y+(diameter/4), diameter/2, diameter/2);
            //g.drawOval(x+(diameter/2 - 2), y+(diameter/2 - 2), diameter/4, diameter/4);

            // Cross design
            g.drawLine(x + (diameter/2), y, x + (diameter/2), y + diameter);
            g.drawLine(x, y + (diameter/2), x + diameter, y + (diameter/2));

        }
    }

    public class Pancake extends Circle
    {
        // Do stuff
        public void draw(Graphics g)
        {
            int x = (xDim/2), y = (yDim/2);

            g.setColor(LIGHT_GREEN);
            g.fillOval(x - 30, y - 30, 60, 60);
            g.setColor(Color.WHITE);
            g.fillOval(x - 11, y - 11, 22, 22);
            super.draw(g);
        }

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (Circle c : circles)
        {
            if(c != null)
                c.draw(g);
        }

        //System.out.println("paintComponent");
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Circle Tiles");

        frame.add(new CircleTile(1));
        frame.add(new CircleTile(2));
        frame.add(new CircleTile(3));
        frame.add(new CircleTile(4));
        frame.add(new CircleTile(5));
        frame.add(new CircleTile(6));
        frame.add(new CircleTile(7));
        frame.add(new CircleTile(8));
        frame.add(new CircleTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}
