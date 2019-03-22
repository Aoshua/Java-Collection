import javax.swing.*;
import java.awt.*;

public class PictureTile extends Tile
{
    private String name;
    private Image image;

    public PictureTile(String name)
    {
        this.name = name;

        this.name = name; // "Chrysanthemum", "Orchid", "Plumb", "Bamboo", "Spring", "Summer", "Fall", "Winter"
        setToolTipText(toString());

        //image = Toolkit.getDefaultToolkit().getImage("images/arches11.jpg");

        switch (name) {
            case "Bamboo":
                image = Toolkit.getDefaultToolkit().getImage("images/Bamboo.png");
                break;
            case "Chrysanthemum":
                image = Toolkit.getDefaultToolkit().getImage("images/Chrysanthemum.png");
                break;
            case "Fall":
                image = Toolkit.getDefaultToolkit().getImage("images/Fall.png");
                break;
            case "Orchid":
                image = Toolkit.getDefaultToolkit().getImage("images/Orchid.png");
                break;
            case "Plum":
                image = Toolkit.getDefaultToolkit().getImage("images/Plum.png");
                break;
            case "Spring":
                image = Toolkit.getDefaultToolkit().getImage("images/Spring.png");
                break;
            case "Summer":
                image = Toolkit.getDefaultToolkit().getImage("images/Summer.png");
                break;
            case "Winter":
                image = Toolkit.getDefaultToolkit().getImage("images/Winter.png");
                break;
            case "Sparrow":
                image = Toolkit.getDefaultToolkit().getImage("images/Sparrow.png");
                break;
            default:
                System.err.println("Faulty name: " + name);
                break;
        }

            // Ensure that the image is fully downloaded:
            MediaTracker tracker = new MediaTracker(this);                // "this" refers to an instance of GUIDemo class
            tracker.addImage(image, 0);                                    // Adds image to tracker

            try {
                tracker.waitForAll();                                           // Main thread waits until image is loaded
            } catch (InterruptedException ie) {
                JOptionPane.showMessageDialog(this, "Unable to load image.",
                        "Image Error", JOptionPane.ERROR_MESSAGE);
            }

            // 3rd parameter is slow but good for scaling. Increases width by 50% Height of -1 double dimension
            //image = image.getScaledInstance((int) (image.getWidth(this) * 1.5), -1, Image.SCALE_SMOOTH);
            //image = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);

            tracker.addImage(image, 0);        // Adds image to tracker

            try {
                tracker.waitForAll();               // Main thread waits until image is loaded
            } catch (InterruptedException ie) {
                JOptionPane.showMessageDialog(this, "Unable to load image.",
                        "Image Error", JOptionPane.ERROR_MESSAGE);
            }
    }

    public String toString()
    {
        return name;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //g.drawImage(image, 12, 30, this);
        g.drawImage(image, (getWidth() / 4) - 9, (getHeight() / 4) - 5, this);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Picture Tiles");
        frame.add(new Bamboo1Tile());

        frame.add(new FlowerTile("Chrysanthemum"));
        frame.add(new FlowerTile("Orchid"));
        frame.add(new FlowerTile("Plum"));
        frame.add(new FlowerTile("Bamboo"));

        frame.add(new SeasonTile("Spring"));
        frame.add(new SeasonTile("Summer"));
        frame.add(new SeasonTile("Fall"));
        frame.add(new SeasonTile("Winter"));

        frame.pack();
        frame.setVisible(true);
    }
}
