package de.congrace.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import de.congrace.solar.math.Vector2D;
import de.congrace.solar.objects.Planet;

public class SolarPanel extends JPanel {
	private static final double GRAVITATIONAL_CONSTANT=6.67348E-11d;

	private final SolarSystem system;
	private AffineTransform transform;

	public SolarPanel(SolarSystem system) {
		this.system = system;
		this.setBackground(Color.BLACK);
		this.transform=new AffineTransform();
		transform.setToTranslation(getXCenter(), getYCenter());
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.transform(transform);
		g2d.setColor(Color.YELLOW);
		g2d.fill(new Ellipse2D.Double(system.getSun().getPosition().getX(), system.getSun().getPosition().getY() ,40, 40));
	}

	private void updatePlanets() {
	}

	private double getYCenter() {
		return (double)this.getHeight() / 2d;
	}

	private double getXCenter() {
		return (double)this.getWidth() / 2d;
	}
}
