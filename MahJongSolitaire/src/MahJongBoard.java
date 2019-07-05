import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

public class MahJongBoard extends JPanel implements MouseListener
{
    private Image dragon;
    private MahJongModel model;
    private Tile firstTile;
    private boolean isOpen;
    private int tilesLeft = 144;

    protected static Stack<Tile> undoStack = new Stack<>();
    private static PlayClip removeSound = new PlayClip("audio/stone-scraping.wav", true);

    public MahJongBoard()
    {
        setLayout(null);    // Helps deliberately overlap the tiles
        this.model = new MahJongModel(this);
        this.setBackground(new Color(51, 102, 0));

        //int zOrder = 0;
        for(int z = model.zDim - 1; z >= 0; z--)
        {
            for (int x = model.xDim - 1; x >= 0; x--)
            {
                for (int y = 0; y < model.yDim; y++)
                {
                    if (model.tiles[z][y][x] != null )
                    {
                        final Tile t = model.tiles[z][y][x];

                        // Top tile:
                        if (x == 6 && y == 3 & z == 4) {
                            t.setLocation(1200/2 - Tile.TILE_WIDTH +8,840/2 - Tile.TILE_HEIGHT/2 +(z*8));
                            t.xDim = 1200/2 - Tile.TILE_WIDTH +8;
                            t.yDim = 840/2 - Tile.TILE_HEIGHT/2 +(z*8);
                        }

                        // Far left tile:
                        else if (x == 0 && y == 4 & z == 0) {
                            t.setLocation(8, (840/2) - (106/2) +8);
                            t.xDim = 8;
                            t.yDim = (840/2) - (106/2) +8;
                        }

                        // Second to right tile:
                        else if (x == 13 && y == 3 & z == 0) {
                            t.setLocation(1200 - Tile.TILE_WIDTH * 2 +8, 840 / 2 - Tile.TILE_WIDTH / 2);
                            t.xDim = 1200 - Tile.TILE_WIDTH * 2 +8;
                            t.yDim = 840 / 2 - Tile.TILE_WIDTH / 2;
                        }

                        // Far right tile
                        else if (x == 14 && y == 3 & z == 0) {
                            t.setLocation(1200 - Tile.TILE_WIDTH +8, 840/2 - Tile.TILE_WIDTH/2);
                            t.xDim = 1200 - Tile.TILE_WIDTH +8;
                            t.yDim = 840/2 - Tile.TILE_WIDTH/2;
                        }

                        // Remaining tiles:
                        else {
                            t.setLocation(x* (Tile.TILE_WIDTH)+8, y * (Tile.TILE_HEIGHT)+((z+1)*8));
                            t.xDim = x* (Tile.TILE_WIDTH)+8;
                            t.yDim = y * (Tile.TILE_HEIGHT)+((z+1)*8);
                        }

                        add(t);
                    }

                }
            }
        }
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        dragon = Toolkit.getDefaultToolkit().getImage("images/dragon_bg.png");
        ImageIcon dragon1 = new ImageIcon(dragon.getScaledInstance(1226/2, 962/2, Image.SCALE_FAST));

        // Ensure that the image is fully downloaded:
        MediaTracker tracker0 = new MediaTracker(this);
        tracker0.addImage(dragon,  0);

        try
        {
            tracker0.waitForAll();                               // Main thread waits until image is loaded
        }
        catch (InterruptedException ie)
        {
            JOptionPane.showMessageDialog(this, "Unable to load image.",
                    "Image Error", JOptionPane.ERROR_MESSAGE);
        }

        dragon1.paintIcon(this, g, 1226/3 - 1226/8, 962/3 - 962/8);
    }

    public void undo()
    {
        if(!undoStack.empty())
        {
            Tile temp1 = undoStack.pop();
            Tile temp2 = undoStack.pop();
            add(temp1, temp1.zDim);
            add(temp2, temp2.zDim);

            System.out.println(temp1.zDim + " " + temp2.zDim);    // Test

            temp1.setLocation(temp1.xDim, temp1.yDim);
            temp2.setLocation(temp2.xDim, temp2.yDim);
            repaint();

            tilesLeft += 2; // Add tiles back
        }
    }

    public void restart()
    {
        while(!undoStack.empty())
        {
            undo();
        }

        tilesLeft = 144; // Reset tiles
    }

    public void win()
    {
        JFrame		frame = new JFrame();
        Fireworks	fireworks = new Fireworks();

        frame.setBackground(Color.WHITE);
        frame.setSize(1242, 970);
        frame.add(fireworks.getPanel());
        frame.setVisible(true);

        if(!MahJong.hasSound) { fireworks.setSound(false); }

        fireworks.setExplosions(0, 1000);
        fireworks.fire();

        try
        {
            Thread.sleep(10000);
            fireworks.stop();
        }
        catch (InterruptedException ie) {}
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(firstTile == null)
        {
            firstTile = (Tile) e.getSource();
            isOpen = model.isTileOpen(firstTile.xoo, firstTile.yoo, firstTile.zoo);
            firstTile.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        }
        else
        {
            Tile tempTile = (Tile) e.getSource();
            if(model.isTileOpen(tempTile.xoo, tempTile.yoo, tempTile.zoo)
                    && firstTile != tempTile && firstTile.matches(tempTile))
            {
                if(MahJong.hasSound) { removeSound.play(); }

                firstTile.zDim = getComponentZOrder(firstTile);
                remove(firstTile);
                tempTile.zDim = getComponentZOrder(tempTile);
                remove(tempTile);

                MahJong.undoPile.addToUndo(firstTile, tempTile);

                repaint();

                tilesLeft -= 2;
                if(tilesLeft < 2){ win(); } // If win

                // Move:
                undoStack.add(firstTile);
                undoStack.add(tempTile);

                // Clean:
                firstTile.setBorder(null);
                firstTile = null;
            }
            else
            {
                firstTile.setBorder(null);
                firstTile = null;
                isOpen = false;
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
