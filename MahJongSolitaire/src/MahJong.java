import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


public class MahJong extends JFrame
{
    private final int SCREEN_WIDTH = 1242;
    public final int SCREEN_HEIGHT = 970;
    private Random seed = new Random();
    private JButton undoButton;
    private JButton restartButton;
    private JButton showRemovedButton;
    private MahJongBoard board = new MahJongBoard();

    protected static int gameNumber = (int)System.currentTimeMillis() % 100000;
    protected static UndoContainer undoPile = new UndoContainer();
    protected static boolean hasSound = true;


    public MahJong()
    {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { close();}});

        this.setTitle("MahJong Solitaire");

        makeMenu();
        add(undoPile);

        JPanel top = new JPanel();
        add(top, BorderLayout.NORTH);
        top.setLayout(new GridLayout());

        JPanel topLeft = new JPanel();
        top.add(topLeft, BorderLayout.NORTH);

        ButtonGroup	soundToggleGroup = new ButtonGroup();   // Toggle sound

        JRadioButtonMenuItem	soundOn = new JRadioButtonMenuItem("Sound on", true);
        soundToggleGroup.add(soundOn);
        topLeft.add(soundOn);
        soundOn.setToolTipText("Toggle sounds on");
        soundOn.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        soundOn.setMnemonic('O');
        soundOn.addActionListener(e -> toggleSound(true));

        JRadioButtonMenuItem	soundOff = new JRadioButtonMenuItem("Sound off", false);
        soundToggleGroup.add(soundOff);
        topLeft.add(soundOff);
        soundOff.setToolTipText("Toggle sounds off");
        soundOff.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        soundOff.setMnemonic('X');
        soundOff.addActionListener(e -> toggleSound(false));

        undoButton = new JButton("Undo");
        undoButton.setToolTipText("Undo last move");
        top.add(undoButton);
        undoButton.addActionListener(e -> board.undo());

        restartButton = new JButton("Restart");
        restartButton.setToolTipText("Restart this game");
        top.add(restartButton);
        restartButton.addActionListener(e -> board.restart());

        showRemovedButton = new JButton("Show Removed Tiles");
        showRemovedButton.setToolTipText("Show tiles removed from game");
        top.add(showRemovedButton);
        showRemovedButton.addActionListener(e -> showRemovedTiles());

        add(board);

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setVisible(true);
    }


    private void makeMenu()
    {
        JMenuBar	menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Game Menu:
        JMenu	gameMenu = new JMenu("Game");
        gameMenu.setMnemonic('G');
        menuBar.add(gameMenu);

        JMenuItem	play = new JMenuItem("New Game", 'N');
        play.setToolTipText("Start a new game");
        play.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        gameMenu.add(play);
        play.addActionListener(e -> newGame());

        JMenuItem	restart = new JMenuItem("Restart", 'R');
        restart.setToolTipText("Restart this game");
        restart.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        gameMenu.add(restart);
        restart.addActionListener(e -> board.restart());

        JMenuItem	numberedGame = new JMenuItem("Numbered Game", 'b');
        numberedGame.setToolTipText("Play a particular game.");
        numberedGame.setAccelerator(KeyStroke.getKeyStroke("ctrl B"));
        gameMenu.add(numberedGame);
        numberedGame.addActionListener(e -> playNumbered());

        // Help menu:
        JMenu	helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        menuBar.add(helpMenu);

        JMenuItem	operation = new JMenuItem("Operation", 'O');
        operation.setToolTipText("How the controls work");
        operation.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        helpMenu.add(operation);
        operation.addActionListener(e -> helpOperations());

        JMenuItem	rules = new JMenuItem("Game Rules", 'G');
        rules.setToolTipText("MahJong Solitaire Rules");
        rules.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
        helpMenu.add(rules);
        rules.addActionListener(e -> howToPlay());

    }


    public void toggleSound(boolean hasSound)
    {
        this.hasSound = hasSound;
    }

    public void newGame()
    {
        gameNumber = seed.nextInt(100000);
        this.setState(Frame.ICONIFIED);     // Hide previous game
        new MahJong();
    }

    public void playNumbered()
    {
        String userString = JOptionPane.showInputDialog("Please enter the game number you wish to play");
        gameNumber = Integer.parseInt(userString);
        this.setState(Frame.ICONIFIED);     // Hide previous game
        MahJong newGame = new MahJong();
        newGame.setTitle("MahJong Solitaire Game No." + gameNumber);
    }

    public void showRemovedTiles()
    {
        JFrame removedTilesFrame = new JFrame();
        removedTilesFrame.setTitle("Removed Tiles");
        removedTilesFrame.add(undoPile);

        removedTilesFrame.setSize(264, 290);
        removedTilesFrame.setVisible(true);
    }

    public void helpOperations()
    {
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 300px;'>Use the mouse to click two tiles to be compared. If " +
                        "they match, they will be removed. If you see that they match but they are not removed, " +
                        "try clicking the other tile first.</p></body></html>");
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 300px;'>To see the tiles that have been removed from the game" +
                        ", click the “Show Removed Tiles” button at the top of the game window.</p></body></html>");
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 300px;'>To undo or restart, click the corresponding buttons " +
                        "at the top of the window.</p></body></html>");
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 300px;'>You can toggle the sound off and on by clicking the " +
                        "radio buttons.</p></body></html>");
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 300px;'>Other game modes can be accessed using the drop-down " +
                        "menu to the top left of the game window.</p></body></html>");
    }

    public void howToPlay()
    {
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 300px;'>The goal is to remove every tile by matching pairs of " +
                        "identical MahJong tiles.</p></body></html>");
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 300px;'>Only ‘free’ tiles can be matched, meaning that there " +
                        "are no other tiles above it, and one of the sides is open.</p></body></html>");
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 300px;'>Matching tiles removes them, thus freeing other tiles " +
                        "that can be matched.</p></body></html>");
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 300px;'>You win the game by matching all the tiles. But be " +
                        "careful! If you do not match the tiles carefully, you can find yourself with no more free " +
                        "tiles available, and this is how you lose. Good luck!</p></body></html>");
    }

    public void close()
    {
        if(JOptionPane.showConfirmDialog(this, "Exit MahJong Solitaire?",
                "Confirm Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    public static void main(String[] args)
    {
        new MahJong();
    }
}

