package xyz.jadonfowler.brutalpixel.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Mob extends Entity {

	public Mob(Vector2f p, BufferedImage sprite){
		this.position = p;
		this.sprite = sprite;
	}
	
	@Override
	public void render(Graphics2D g) {
		g.drawImage(sprite, (int)position.x, (int)position.y, null);
	}

	@Override
	public void update() {

	}

}
