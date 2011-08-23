package de.congrace.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import de.congrace.solar.math.Vector2D;
import de.congrace.solar.objects.Planet;

public class SolarPanel extends JPanel {
	private static final double GRAVITATIONAL_CONSTANT = 6.67348E-11d;

	private final SolarSystem system;
	private AffineTransform transform;

	private MouseMotionListener coordListener = new MouseAdapter() {
		public void mouseMoved(MouseEvent e) {
			Point2D pos = new Point2D.Double(e.getX(), e.getY());
			Point2D translatedPos = new Point2D.Double();
			try {
				transform.createInverse().transform(pos, translatedPos);
				System.out.println(pos + ":" + translatedPos);
			} catch (NoninvertibleTransformException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		};
	};

	public SolarPanel(SolarSystem system) {
		this.system = system;
		this.setBackground(Color.BLACK);
		this.transform = new AffineTransform();
//		this.addMouseMotionListener(coordListener);
	}

	@Override
	public void paint(Graphics g) {
		transform.setToScale((double)this.getWidth()/600000000d, (double)this.getHeight()/600000000d);
		transform.translate(300000000d, 300000000d);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.YELLOW);
		g2d.fill(transform.createTransformedShape(new Ellipse2D.Double(system.getSun().getPosition().getX() - system.getSun().getRadius()*10/2, system.getSun().getPosition().getY() - system.getSun().getRadius()*10/2 , system.getSun().getRadius()*10, system.getSun().getRadius()*10)));
		for (Planet p : system.getPlanets()) {
			g2d.setColor(Color.BLUE);
			g2d.fill(transform.createTransformedShape(new Ellipse2D.Double(p.getPosition().getX() - (3e6d/2d), p.getPosition().getY() - (3e6d/2d), 3e6, 3e6)));
			Vector2D force = system.getForceVector(p);
			g2d.setColor(Color.WHITE);
			AffineTransform planetTransform = new AffineTransform(transform);
			planetTransform.translate(p.getPosition().getX(), p.getPosition().getY());
			Vector2D unitVector = force.copy().scale(1 / force.getMagnitude());
			Point2D tmp=new Point2D.Double(unitVector.getX(), unitVector.getY());
			Point2D forceEnd=new Point2D.Double();
			planetTransform.transform(tmp,forceEnd);
			Shape forceVector = planetTransform.createTransformedShape(new Line2D.Double(p.getPosition().getX(), p.getPosition().getY(),
			        forceEnd.getX(),forceEnd.getY()));
			 g2d.draw(forceVector);
			System.out.println("unit vector:" + unitVector);
			System.out.println("force mag:" + force.getMagnitude());
			System.out.println("force:" + force.getX() + "/" + force.getY());
			System.out.println("force end: " + forceEnd);
		}
	}

	private void updatePlanets() {
	}

	private double getYCenter() {
		return (double) this.getHeight() / 2d;
	}

	private double getXCenter() {
		return (double) this.getWidth() / 2d;
	}
}
