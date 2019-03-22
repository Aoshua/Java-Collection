import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel
{
    private final Color BRIGHT_BLUE = new Color(30, 144, 255);
    private final Color MEDIUM_PURPLE = new Color(122, 55, 139);
    private final Color CREAM = new Color(246, 215, 169);
    private final Color OFF_WHITE = new Color(250, 245, 245);
    final Color PINE_GREEN = new Color(51, 102, 0);
    final Color LIGHT_GREEN = new Color(20, 170, 20);
    final Color BLOOD_RED = new Color(170, 30 , 30);

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

    static Polygon drawPolygon(int a, int b, int c, int d, int e, int f, int g, int h)
    {
        Polygon		p0 = new Polygon();
        p0.addPoint(a, e);
        p0.addPoint(b, f);
        p0.addPoint(c, g);
        p0.addPoint(d, h);
        return p0;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        /*final Color BRIGHT_BLUE = new Color(30, 144, 255);
        final Color MEDIUM_PURPLE = new Color(122, 55, 139);
        final Color CREAM = new Color(246, 215, 169);
        final Color OFF_WHITE = new Color(250, 245, 245);*/

        Graphics2D	g2 = (Graphics2D)g;

        // Primary tile face:
        GradientPaint grad0 = new GradientPaint(110, 23, OFF_WHITE , 100, 123, CREAM);
        g2.setPaint(grad0);
        g2.fill(new Rectangle (0, 8, 80, 105));

        // Side of tile:
        GradientPaint grad1 = new GradientPaint(80, 0, CREAM,80, 148, OFF_WHITE);
        Polygon p0 = drawPolygon(80,80, 85,85, 8, 113,109, 4);
        g2.setPaint(grad1);
        g2.fill(p0);

        // Colored Side:
        GradientPaint grad2 = new GradientPaint(85, 109, MEDIUM_PURPLE,90, 0, BRIGHT_BLUE);
        Polygon p1 = drawPolygon(85,85, 90,90, 4, 109,105, 0);
        g2.setPaint(grad2);
        g2.fill(p1);

        // Top of tile:
        GradientPaint grad3 = new GradientPaint(80, 10, OFF_WHITE,0, 0, CREAM);
        Polygon p2 = drawPolygon(0,80, 85,5, 8, 8,4, 4);
        g2.setPaint(grad3);
        g2.fill(p2);

        // Colored top:
        GradientPaint grad4 = new GradientPaint(16, 17, MEDIUM_PURPLE,122, 11, BRIGHT_BLUE);
        Polygon p3 = drawPolygon(5,85, 90,10, 4, 4,0, 0);
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


