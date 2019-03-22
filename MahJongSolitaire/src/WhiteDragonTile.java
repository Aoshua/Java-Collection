import javax.swing.*;
import java.awt.*;

public class WhiteDragonTile extends Tile
{
    public WhiteDragonTile()
    {
        setToolTipText("White Dragon");
    }

    public String toString()
    {
        return "White Dragon";
    }

    static Polygon drawRectangle(int a, int b, int c, int d, int e, int f, int g, int h)
    {
        Polygon		p0 = new Polygon();
        p0.addPoint(a, e);
        p0.addPoint(b, f);
        p0.addPoint(c, g);
        p0.addPoint(d, h);
        return p0;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D	gs = (Graphics2D)g;

        // Coordinates entered by circling counterclockwise starting with x-values.
        Polygon p0 = drawRectangle(8, 8, 24, 24, 29, 33, 33, 29);
        Polygon p1 = drawRectangle(24, 24, 40, 40, 29, 33, 33, 29);
        Polygon p2 = drawRectangle(40, 40, 57, 57, 29, 33, 33, 29 );
        Polygon p3 = drawRectangle(57, 57, 72, 72, 29, 33, 33, 29);
        Polygon p4 = drawRectangle(68, 68, 72, 72, 33, 45, 45, 33);
        Polygon p5 = drawRectangle(68, 68, 72, 72, 45, 61, 61, 45);
        Polygon p6 = drawRectangle(68, 68, 72, 72, 61, 77, 77, 61);
        Polygon p7 = drawRectangle(68, 68, 72, 72, 77, 93, 93, 77);
        Polygon p8 = drawRectangle(57, 57, 68, 68, 89, 93, 93, 89);
        Polygon p9 = drawRectangle(40, 40, 57, 57, 89, 93, 93, 89);
        Polygon p10 = drawRectangle(24, 24, 40, 40, 89, 93, 93, 89);
        Polygon p11 = drawRectangle(8, 8, 24, 24, 89, 93, 93, 89);
        Polygon p12 = drawRectangle(8, 8, 12, 12, 77, 89, 89, 77);
        Polygon p13 = drawRectangle(8, 8, 12, 12, 61, 77, 77, 61);
        Polygon p14 = drawRectangle(8, 8, 12, 12, 45, 61, 61, 45);
        Polygon p15 = drawRectangle(8, 8, 12, 12, 29, 45, 45, 29);

        gs.setPaint(Color.BLUE);
        gs.fill(p0);
        gs.fill(p2);
        gs.fill(p4);
        gs.fill(p6);
        gs.fill(p8);
        gs.fill(p10);
        gs.fill(p12);
        gs.fill(p14);

        gs.setPaint(Color.WHITE);
        gs.fill(p1);
        gs.fill(p3);
        gs.fill(p5);
        gs.fill(p7);
        gs.fill(p9);
        gs.fill(p11);
        gs.fill(p13);
        gs.fill(p15);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("White Dragon");

        frame.add(new WhiteDragonTile());

        frame.pack();
        frame.setVisible(true);
    }
}
