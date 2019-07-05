import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel
{
    public static final int TILE_WIDTH = 80, TILE_HEIGHT = 106;

    public static final Color BRIGHT_BLUE = new Color(30, 144, 255);
    public static final Color MEDIUM_PURPLE = new Color(122, 55, 139);
    public static final Color DARK_CREAM = new Color(216, 185, 139);
    public static final Color CREAM = new Color(246, 215, 169);
    public static final Color OFF_WHITE = new Color(250, 245, 245);
    public static final Color PINE_GREEN = new Color(51, 102, 0);
    public static final Color LIGHT_GREEN = new Color(20, 170, 20);
    public static final Color BLOOD_RED = new Color(170, 30 , 30);

    protected int xoo, yoo, zoo, xDim, yDim, zDim;

    // Primary tile face:
    private static GradientPaint grad0 = new GradientPaint(110, 23, OFF_WHITE , TILE_HEIGHT-5, TILE_HEIGHT+18, CREAM);
    // Side of tile:
    private static GradientPaint grad1 = new GradientPaint(TILE_WIDTH, 0, CREAM, TILE_WIDTH, TILE_HEIGHT+43, OFF_WHITE);
    private static Polygon p0 = drawPolygon(TILE_WIDTH, TILE_WIDTH, TILE_WIDTH+5,TILE_WIDTH+5,
            8,TILE_HEIGHT+7,TILE_HEIGHT+3, 4);
    // Colored Side:
    private static GradientPaint grad2 = new GradientPaint(TILE_WIDTH+5, 109, MEDIUM_PURPLE,90, 0, BRIGHT_BLUE);
    private static Polygon p1 = drawPolygon(TILE_WIDTH+5,TILE_WIDTH+5, TILE_WIDTH+10, TILE_WIDTH+10,4,
            TILE_HEIGHT+4,TILE_HEIGHT, 0);
    // Top of tile:
    private static GradientPaint grad3 = new GradientPaint(TILE_WIDTH, 10, OFF_WHITE,0, 0, CREAM);
    private static Polygon p2 = drawPolygon(0,TILE_WIDTH, TILE_WIDTH+5,5, 8, 8,4, 4);
    // Colored top:
    private static GradientPaint grad4 = new GradientPaint(16, 17, MEDIUM_PURPLE,TILE_HEIGHT+17, 11, BRIGHT_BLUE);
    private static Polygon p3 = drawPolygon(5,TILE_WIDTH+5, TILE_WIDTH+10,10, 4, 4,0, 0);
    // Sides together for borders:
    private static Polygon p4 = drawPolygon(0,TILE_WIDTH, TILE_WIDTH+10,10, 8, 8,0, 0);
    private static Polygon p5 = drawPolygon(TILE_WIDTH, TILE_WIDTH, TILE_WIDTH+10,TILE_WIDTH+10,
            8,TILE_HEIGHT+7,TILE_HEIGHT, 0);

    public Tile()
    {
        setPreferredSize(new Dimension(91,115));
        setSize(91, 115);
        setOpaque(false);
    }


    public boolean matches(Tile other)
    {
        if(other == this){return true;}              // Test for exact same
        if(other == null) {return false;}            // Test for null
        return getClass() == other.getClass();       // Tests if classes are the same
    }

    static Polygon drawPolygon(int a, int b, int c, int d, int e, int f, int g, int h)
    {
        Polygon	p0 = new Polygon();
        p0.addPoint(a, e);
        p0.addPoint(b, f);
        p0.addPoint(c, g);
        p0.addPoint(d, h);
        return p0;
    }

    @Override public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D	g2 = (Graphics2D)g;

        // Primary tile face:
        g2.setPaint(grad0);
        g2.fill(new Rectangle (0, 8, TILE_WIDTH, TILE_HEIGHT));

        // Side of tile:
        g2.setPaint(grad1);
        g2.fill(p0);

        // Colored Side:
        g2.setPaint(grad2);
        g2.fill(p1);

        // Top of tile:
        g2.setPaint(grad3);
        g2.fill(p2);

        // Colored top:
        g2.setPaint(grad4);
        g2.fill(p3);

        g.setColor(DARK_CREAM);
        g.drawRect(0, 8, TILE_WIDTH, TILE_HEIGHT);  // Border of face
        g.drawPolygon(p4);                                // Border of top
        g.drawPolygon(p5);                                // Border of side

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


