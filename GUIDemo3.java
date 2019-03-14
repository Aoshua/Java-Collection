// This demo uses the ImageIcon class. It demonstrates font and string manipulation.

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIDemo3 extends JFrame
{
    private ImageIcon image;        // using swing

    public GUIDemo3()
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

        image = new ImageIcon("images/arches11.jpg");

        add(new Display());
        pack();                    // Packs size of JFrame around objects within it.

        // Center image object:
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Saves  height and width
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        setVisible(true);         // Always last
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
            setPreferredSize(new Dimension(image.getIconWidth(),
                    image.getIconHeight() + 25));
                  //  image.getIconHeight()));
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            image.paintIcon(this, g,0, 0);
            //g.drawImage(image.getImage(), 0, 0, this);

            String caption = "Park Avenue";

            //Font f = g.getFont().deriveFont(20F);
            Font f = g.getFont();
            f = f.deriveFont(f.getSize2D() *0.8F);               // Resizes to 80% of previous size
            g.setFont(f);

            FontMetrics fm = g.getFontMetrics();
            int wid = fm.stringWidth(caption);
            g.setColor(Color.GRAY);
            g.drawString(caption, (getWidth() - wid) / 2, getHeight() - 7);
        }
    }

    public static void main(String[] args)
    {
        new GUIDemo3();                                         // Simplification prior to java 6
    }
}

