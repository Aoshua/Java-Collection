import javax.swing.*;
import java.awt.*;
import java.util.Stack;


public class UndoContainer extends JScrollPane
{
    private	JPanel[] discard = new JPanel[2];
    private	Stack<Tile>	undoStack = new Stack<>();
    private	int	width = 88 + 6;
    private	int	height = 114;
    private	int	count = 0;


    public UndoContainer()
    {
        setPreferredSize(new Dimension(0, 2 * height + 33));
        setBorder(BorderFactory.createRaisedBevelBorder());

        discard[0] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        discard[1] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        discard[0].setPreferredSize(new Dimension(0, height));
        discard[1].setPreferredSize(new Dimension(0, height));

        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel	panel = new JPanel(new BorderLayout());
        setViewportView(panel);

        panel.add(discard[0], BorderLayout.NORTH);
        panel.add(discard[1], BorderLayout.SOUTH);

        discard[0].setBackground(Color.BLUE);
        discard[1].setBackground(new Color(170, 30, 30));
        panel.setBackground(new Color(51, 102, 0));
    }


    public void addToUndo(Tile t1, Tile t2)
    {
        undoStack.push(t1);
        undoStack.push(t2);

        Dimension	size = new Dimension(++count * width, height + 6);
        discard[0].setPreferredSize(size);
        discard[1].setPreferredSize(size);

        Rectangle	r = new Rectangle(count * width, 0, width, height + 6);
        getViewport().scrollRectToVisible(r);

        discard[0].add(t1, 0);
        discard[1].add(t2, 0);

        revalidate();
        repaint();
    }

}
