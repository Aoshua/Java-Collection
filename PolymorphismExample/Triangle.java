import java.awt.*;

public class Triangle extends Shape
{
    private Point vert0;
    private Point vert1;
    private Point vert2;

    public Triangle(Color color, int p0, int p1, int p2, int p3, int p4, int p5)
    {
        super(color);
        vert0 = new Point(p0, p1);
        vert1 = new Point(p2, p3);
        vert2 = new Point(p4, p5);
    }

    public void draw(Graphics g)
    {
        g.setColor(getColor());
        g.drawLine(vert0.x, vert0.y, vert1.x, vert1.y);
        g.drawLine(vert1.x, vert1.y, vert2.x, vert2.y);
        g.drawLine(vert2.x, vert2.y, vert0.x, vert0.y);
    }
}
