import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel
{

    public Tile()
    {
        //setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setPreferredSize(new Dimension(90,140));
    }

    public boolean matches(Tile other)
    {
        if(other == this){return true;}              // Test for exact same
        if(other == null) {return false;}            // Test for null
        return getClass() == other.getClass();       // Tests if classes are the same
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        final Color BRIGHT_BLUE = new Color(30, 144, 255);
        final Color MEDIUM_PURPLE = new Color(122, 55, 139);
        final Color NAVAJO_WHITE3 = new Color(205, 179, 139);
        final Color NAVAJO_WHITE2 = new Color(238, 207, 161);

        Graphics2D	g2 = (Graphics2D)g;

        // Primary tile face:
        GradientPaint	grad0 =
                new GradientPaint(110, 23, NAVAJO_WHITE2 ,
                        100, 123, NAVAJO_WHITE3);
        g2.setPaint(grad0);
        g2.fill(new Rectangle (0, 8, 80, 105));

        // Side of tile:
        GradientPaint	grad1 =
                new GradientPaint(80, 148, NAVAJO_WHITE3,
                        80, 148, NAVAJO_WHITE2);
        Polygon		p0 = new Polygon();
        p0.addPoint(80, 8);
        p0.addPoint(80, 113);
        p0.addPoint(85, 109);
        p0.addPoint(85, 4);
        g2.setPaint(grad1);
        g2.fill(p0);

        // Colored Side:
        GradientPaint	grad2 =
                new GradientPaint(85, 109, MEDIUM_PURPLE,
                        90, 0, BRIGHT_BLUE);
        Polygon		p1 = new Polygon();
        p1.addPoint(85, 4);
        p1.addPoint(85, 109);
        p1.addPoint(90, 105);
        p1.addPoint(90, 0);
        g2.setPaint(grad2);
        g2.fill(p1);

        // Top of tile:
        GradientPaint	grad3 =
                new GradientPaint(80, 148, NAVAJO_WHITE2,
                        80, 123, NAVAJO_WHITE3);
        Polygon		p2 = new Polygon();
        p2.addPoint(0, 8);
        p2.addPoint(80, 8);
        p2.addPoint(85, 4);
        p2.addPoint(5, 4);
        g2.setPaint(grad3);
        g2.fill(p2);

        // Colored top:
        GradientPaint	grad4 =
                new GradientPaint(16, 17, MEDIUM_PURPLE,
                        122, 11, BRIGHT_BLUE);
        Polygon		p3 = new Polygon();
        p3.addPoint(5, 4);
        p3.addPoint(85, 4);
        p3.addPoint(90, 0);
        p3.addPoint(10, 0);
        g2.setPaint(grad4);
        g2.fill(p3);

    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tile");
        frame.add(new Tile());
        frame.pack();
        frame.setVisible(true);
    }
}


