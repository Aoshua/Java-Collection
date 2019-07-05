import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CharacterTile extends Tile
{
    private 	static 	HashMap<Character, String> 	labels = new HashMap<>();
    private 	static 	HashMap<Character,Character> 	map = new HashMap<>();
    private 	char 	symbol;
    private     String  wan = "\u842c";

    public CharacterTile(char symbol)
    {
        this.symbol = symbol;
        setToolTipText(toString());
    }

    @Override public boolean matches(Tile other)
    {
        return super.matches(other) && symbol == ((CharacterTile)other).symbol;
    }

    @Override public String toString()
    {
        return labels.get(symbol);
    }

    public String toChinese()
    {
        return Character.toString(map.get(symbol));
    }

    static
    {
        // English to Chinese character map
        map.put('1', '\u4E00');
        map.put('2', '\u4E8C');
        map.put('3', '\u4E09');
        map.put('4', '\u56DB');
        map.put('5', '\u4E94');
        map.put('6', '\u516D');
        map.put('7', '\u4E03');
        map.put('8', '\u516B');
        map.put('9', '\u4E5D');
        map.put('N', '\u5317');
        map.put('E', '\u6771');
        map.put('W', '\u897F');
        map.put('S', '\u5357');
        map.put('C', '\u4E2D');
        map.put('F', '\u767C');

        // builds labels for the toString method
        labels.put('C', "Red Dragon");
        labels.put('F', "Green Dragon");
        labels.put('N', "North Wind");
        labels.put('E', "East Wind");
        labels.put('W', "West Wind");
        labels.put('S', "South Wind");
        for (char c = '1'; c <= '9'; c++)
            labels.put(c, "Character " + c);
    }

    @Override public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Establish fonts:
        Font topChar = g.getFont();
        topChar = topChar.deriveFont(Font.BOLD, 40);

        Font englishValue = g.getFont();
        englishValue = englishValue.deriveFont(20);

        Font chineseValue = g.getFont();
        chineseValue = chineseValue.deriveFont(Font.PLAIN, 32);

        Font mainChar = g.getFont();
        mainChar = mainChar.deriveFont(Font.BOLD, 60);

        // Draw English value
        g.setFont(englishValue);
        g.setColor(Color.RED);
        g.drawString("" + this.symbol, 67, 23);

        String caption = "" + map.get(this.symbol);                     // Determine top Chinese character

        if(this.symbol == 'F')
        {
            // Draw main Chinese character
            g.setFont(mainChar);
            FontMetrics fm = g.getFontMetrics();
            int wid = fm.stringWidth(caption);
            g.setColor(PINE_GREEN);
            g.drawString(caption, (TILE_WIDTH - wid) / 2, ((TILE_HEIGHT) / 2) + 30);
        }
        if(this.symbol == 'C')
        {
            // Draw main Chinese character
            g.setFont(mainChar);
            FontMetrics fm = g.getFontMetrics();
            int wid = fm.stringWidth(caption);
            g.setColor(BLOOD_RED);
            g.drawString(caption, (TILE_WIDTH - wid) / 2, ((TILE_HEIGHT) / 2) + 30);
        }
        if(this.symbol == 'N' || this.symbol == 'E' || this.symbol == 'W' || this.symbol == 'S')
        {
            // Draw main Chinese character
            g.setFont(mainChar);
            FontMetrics fm = g.getFontMetrics();
            int wid = fm.stringWidth(caption);
            g.setColor(Color.BLACK);
            g.drawString(caption, (TILE_WIDTH - wid) / 2, ((TILE_HEIGHT) / 2) + 30);
        }
        if((int)this.symbol > 48 && (int)this.symbol < 58)
        {
            // Draw top Chinese character
            g.setFont(topChar);
            FontMetrics fm = g.getFontMetrics();
            int wid = fm.stringWidth(caption);
            g.setColor(Color.BLACK);
            g.drawString(caption, (TILE_WIDTH - wid) / 2, 55);

            // Draw "wan"
            g.setFont(chineseValue);
            FontMetrics fm1 = g.getFontMetrics();
            int wid1 = fm1.stringWidth(wan);
            g.setColor(BLOOD_RED);
            g.drawString(wan, (TILE_WIDTH - wid1) / 2, (TILE_HEIGHT / 2) + 40);
        }

    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel tiles = new JPanel();
        JScrollPane scroller = new JScrollPane(tiles);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Character Tiles");
        frame.add(scroller);

        tiles.add(new CharacterTile('1'));
        tiles.add(new CharacterTile('2'));
        tiles.add(new CharacterTile('3'));
        tiles.add(new CharacterTile('4'));
        tiles.add(new CharacterTile('5'));
        tiles.add(new CharacterTile('6'));
        tiles.add(new CharacterTile('7'));
        tiles.add(new CharacterTile('8'));
        tiles.add(new CharacterTile('9'));
        tiles.add(new CharacterTile('N'));
        tiles.add(new CharacterTile('E'));
        tiles.add(new CharacterTile('W'));
        tiles.add(new CharacterTile('S'));
        tiles.add(new CharacterTile('C'));
        tiles.add(new CharacterTile('F'));

        frame.pack();
        frame.setVisible(true);
    }
}

