// This demo takes an image from local memory. Shows image dimension manipulation.

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIDemo2 extends JFrame
{
    private Image image;

    public GUIDemo2()
    {
        setTitle("GUI Demonstration");
        //setSize(600, 400);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);      // Do nothing rather than hide window.
        // The following uses an anonymous inner class
        addWindowListener(new WindowAdapter()
        { public void windowClosing(WindowEvent e)
        //{ System.exit(0);}
        { close();} // Best practice is to take helper method declaration out of here if complex.
        });

        image = Toolkit.getDefaultToolkit().getImage("images/arches11.jpg");

        // Ensure that the image is fully downloaded:
        MediaTracker tracker = new MediaTracker(this);                // "this" refers to an instance of GUIDemo class
        tracker.addImage(image,  0);                                    // Adds image to tracker

        try
        {
            tracker.waitForAll();                                           // Main thread waits until image is loaded
        }
        catch (InterruptedException ie)
        {
            JOptionPane.showMessageDialog(this, "Unable to load image.",
                    "Image Error", JOptionPane.ERROR_MESSAGE);
        }

        // 3rd parameter is slow but good for scaling. Increases width by 50% Height of -1 double dimension
        image = image.getScaledInstance((int)(image.getWidth(this) *1.5), -1, Image.SCALE_SMOOTH);
        //image = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);

        tracker.addImage(image,  0);        // Adds image to tracker

        try
        {
            tracker.waitForAll();               // Main thread waits until image is loaded
        }
        catch (InterruptedException ie)
        {
            JOptionPane.showMessageDialog(this, "Unable to load image.",
                    "Image Error", JOptionPane.ERROR_MESSAGE);
        }

        add(new Display());
        pack();                                 // Packs size of JFrame around objects within it.

        // Center image object:
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();         // Saves  height and width
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        setVisible(true);                       // Always last
    }

    private void close()
    {
        if(JOptionPane.showConfirmDialog(this, "Exit Program?",
                "Confirm Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    class Display extends JPanel
    {
        public Display()
        {
            setPreferredSize(new Dimension(image.getWidth(this),
                    image.getHeight(this)));
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);         // Upper left-hand corner
        }
    }

    public static void main(String[] args)
    {
        new GUIDemo2();                                           // Simplification prior to java 6
    }
}

