// Common technique

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Graphics;

// Event driven programming through interfaces
public class EventDemo1 extends JFrame implements WindowListener
{
    public EventDemo1()
    {
        setTitle("Hello");
        setSize(500, 300);

        // Pattern: sourceObject.Listener(listenerObject)
        this.addWindowListener(this);    // Must be before setVisible()
        add(new GraphicsPanel());           // Anonymous call to GraphicsPanel

        setVisible(true);                   // Otherwise not seen. Starts thread running. Must be last
    }

    @Override
    public void windowOpened(WindowEvent e)
    {

    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        // This method allows us to wrap-up before terminating the program.
        System.exit(0);             // Pressing the X on the GUI window closes window.
    }

    @Override
    public void windowClosed(WindowEvent e)
    {

    }

    @Override
    public void windowIconified(WindowEvent e)
    {

    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {

    }

    @Override
    public void windowActivated(WindowEvent e)
    {

    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {

    }

    public class GraphicsPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            // Is executed many times, so do not include things that
            // should only be instantiated once.
            super.paintComponent(g);        // Resets "canvas"
            g.drawString("Hello world!", 20, 40);
        }
    }

    public static void main(String[] args)
    {
        new EventDemo1();
    }
}
