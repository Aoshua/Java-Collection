import javax.swing.*;
import java.awt.*;

public class GradientDemo extends JFrame
{
    public GradientDemo()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);

        add(new Picture());
        setVisible(true);
    }


    public class Picture extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            g.drawRect(50, 50, 200, 200);

            Graphics2D	g2 = (Graphics2D)g;     // Graphics down-casted to Graphics2D

            final Color PURPLE = new Color (100, 0, 150);

//            GradientPaint	grad = new GradientPaint(50, 50, Color.WHITE,
//                    250, 250, Color.GREEN);
//            g2.setPaint(grad);
//            g.fillRect(50, 50, 200, 200);

            /*
			GradientPaint	grad0 =
				new GradientPaint(50, 250, Color.WHITE,
						150, 150, Color.GREEN);
			Polygon		p0 = new Polygon();
			p0.addPoint(50, 50);
			p0.addPoint(250, 250);
			p0.addPoint(50, 250);
			g2.setPaint(grad0);
			g2.fill(p0);

			GradientPaint	grad1 =
				new GradientPaint(250, 50, Color.WHITE,
						150, 150, Color.GREEN);
			Polygon		p1 = new Polygon();
			p1.addPoint(50, 50);
			p1.addPoint(250, 50);
			p1.addPoint(250, 250);
			g2.setPaint(grad1);
			g2.fill(p1);
			*/


			/**/
			GradientPaint	grad0 =
				new GradientPaint(150, 50, PURPLE ,
						150, 150, Color.ORANGE);
			Polygon		p0 = new Polygon();
			p0.addPoint(50, 50);
			p0.addPoint(150, 150);
			p0.addPoint(250, 50);
			g2.setPaint(grad0);
			g2.fill(p0);

			GradientPaint	grad1 =
				new GradientPaint(150, 250, PURPLE,
						150, 150, Color.ORANGE);
			Polygon		p1 = new Polygon();
			p1.addPoint(50, 250);
			p1.addPoint(150, 150);
			p1.addPoint(250, 250);
			g2.setPaint(grad1);
			g2.fill(p1);

			GradientPaint	grad2 =
				new GradientPaint(50, 150, PURPLE,
						150, 150, Color.ORANGE);
			Polygon		p2 = new Polygon();
			p2.addPoint(50, 50);
			p2.addPoint(150, 150);
			p2.addPoint(50, 250);
			g2.setPaint(grad2);
			g2.fill(p2);

			GradientPaint	grad3 =
				new GradientPaint(250, 150, PURPLE,
						150, 150, Color.ORANGE);
			Polygon		p3 = new Polygon();
			p3.addPoint(250, 50);
			p3.addPoint(150, 150);
			p3.addPoint(250, 250);
			g2.setPaint(grad3);
			g2.fill(p3);
			/**/
        }
    }


    public static void main(String[] args)
    {
        new GradientDemo();
    }
}
