package xyz.jadonfowler.brutalpixel.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Entity {

	String name;
	Position position;
	double health;
	BufferedImage sprite;
	
	public abstract void render(Graphics2D g);

	public abstract void update();

}
