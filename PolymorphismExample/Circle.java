import java.awt.*;

public class Circle extends Shape
{
    private int radius;

    public Circle(Color aColor, int aRadius)
    {
        super(aColor);
        radius = aRadius;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        g.drawOval(100, 100, radius, radius);
    }
}
