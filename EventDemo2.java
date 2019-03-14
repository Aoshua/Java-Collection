// Least common technique

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Event driven programming through interfaces
public class EventDemo2 extends JFrame //implements WindowListener
{
    public EventDemo2()
    {
        setTitle("Hello");
        setSize(500, 300);

        addWindowListener(new WindowCloser());
        add(new GraphicsPanel());           // Anonymous call to GraphicsPanel

        setVisible(true);                   // Otherwise not seen. Starts thread running. Must be last
    }


    public class GraphicsPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            // Is executed many times, so do not include things that
            // should only be instantiated once.
            super.paintComponent(g);         // Resets "canvas"
            g.drawString("Hello world!", 20, 40);
        }
    }

    public class WindowCloser extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }

    }

    public static void main(String[] args)
    {
        new EventDemo2();
    }
}
