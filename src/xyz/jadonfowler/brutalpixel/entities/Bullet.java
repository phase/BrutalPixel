package xyz.jadonfowler.brutalpixel.entities;

import java.awt.Graphics2D;

public class Bullet extends Entity {

	private static final float SPEED = 5.0f;
	private float sx, sy;
	private float xv, yv;
	private Vector2f des;
	
	public Bullet(Vector2f start, Vector2f destination) {
		this.position = start;
		sx = start.x;
		sy = start.y;
		this.des = destination;
		determineVelocities();
	}
	
	private void determineVelocities(){
		float difx = des.x - sx;
		float dify = des.y - sy;
		
		double length = Math.sqrt((difx * difx) + (dify * dify));
		
		xv = (float) ((difx / length) * SPEED);
		yv = (float) ((dify / length) * SPEED);
	}

	public void render(Graphics2D g) {
		g.drawImage(sprite, (int)position.x, (int)position.y, null);
	}

	public void update() {
		position.x += xv;
		position.y += yv;
	}

}
