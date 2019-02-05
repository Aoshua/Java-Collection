import java.awt.*;      // For graphics

abstract public class Shape
{
    private Color color;

    public Shape(Color aColor)
    {
        color = aColor;
    }

    public Color getColor()
    {
        return color;
    }

    abstract public void draw(Graphics g);
}
