package de.congrace.solar;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import de.congrace.solar.math.Vector2D;
import de.congrace.solar.objects.Planet;
import de.congrace.solar.objects.Sun;

public class SwingApp extends JFrame {

	private final SolarPanel solarPanel;

	public SwingApp() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("solar sim");
		this.solarPanel = new SolarPanel(createSolarSystem());
		this.setContentPane(solarPanel);
		this.setLocationRelativeTo(null);
	}

	private SolarSystem createSolarSystem() {
		Sun sun = new Sun("the sun", new Vector2D(0, 0), 1.9891E30d, 6.96E5d);
		Planet earth = new Planet("earth", new Vector2D(1210d, 120d), 5.9736E24d, 6371d);
		return new SolarSystem.Builder("the solar system").withSun(sun).withPlanet(earth).build();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SwingApp app = new SwingApp();
				app.setVisible(true);
			}
		});
	}
}
