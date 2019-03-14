// Demo description: This demo showcases more common event handling in Java. It also illustrates pulling an image from
// the internet, centering the window based on users' screen size, centering the image within the window, and changing
// default settings to close the window.

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class GUIDemo1 extends JFrame
{
    private Image image;

    public GUIDemo1()
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

        try
        {
            URL url = new URL("https://www.nps.gov/arch/learn/photosmultimedia/upload/arches11.jpg");
            image = Toolkit.getDefaultToolkit().getImage(url); // Saves image from URL into var "image"
        }
        catch(MalformedURLException murle)
        {
            JOptionPane.showMessageDialog(this, "Bad URL: " + murle,
                    "Image Error", JOptionPane.ERROR_MESSAGE);
        }

        // Ensure that the image is fully downloaded:
        MediaTracker tracker = new MediaTracker(this);              // "this" refers to an instance of GUIDemo class
        tracker.addImage(image,  0); // Adds image to tracker

        try
        {
            tracker.waitForAll();                 // Main thread waits until image is loaded
        }
        catch (InterruptedException ie)
        {
            JOptionPane.showMessageDialog(this, "Unable to load image.",
                    "Image Error", JOptionPane.ERROR_MESSAGE);
        }

        add(new Display());
        pack();                 // Packs size of JFrame around objects within it.

        // Center image object:
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Saves  height and width
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        setVisible(true);       // Always last
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
            setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);         // Upper left-hand corner
        }
    }

    public static void main(String[] args)
    {
        new GUIDemo1();       //Simplification prior to java 6
    }
}

