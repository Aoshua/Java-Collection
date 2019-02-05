import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PolyControl extends JFrame     // JFrame provides graphical features
{
    private ArrayList<Shape>    shapeList = new ArrayList<Shape>();

    public PolyControl()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // Now clicking the x in the window closes the window
        // rather than hiding it.
        shapeList.add(new Circle(Color.RED, 50));
        shapeList.add(new Rectangle(Color.BLUE, 25, 100));
        shapeList.add(new Triangle(Color.GREEN, 10, 35, 50, 150, 200, 50));

        add(new Picture());
        setSize(400, 500);
        setVisible(true);
    }

    public class Picture extends JPanel   // Inner class, this class is basically the drawing surface.
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for(Shape s : shapeList)
                s.draw(g);
        }
    }

    public static void main(String[] args)
    {
        new PolyControl();  // Anonymous class
    }
}
