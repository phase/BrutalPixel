package xyz.jadonfowler.brutalpixel.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.w3c.dom.css.Rect;

import xyz.jadonfowler.brutalpixel.game.Game;
import xyz.jadonfowler.brutalpixel.game.KeyInput;

public class Player extends Entity{

	private static final int MOVE_SPEED = 40;

	
	
	public Player(BufferedImage image){
		this.name = "Player";
		this.position = new Position((Game.WIDTH/2)-(image.getWidth()/2), (Game.HEIGHT/2)-(image.getHeight()/2));
		this.sprite = image;
		this.health = 20;
	}
	
	
	public void render(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(position.x, position.y, sprite.getWidth(), sprite.getHeight());
	}

	public void update() {
		move();
	}
	
	public void move(){
		if(KeyInput.up)
			position.y -= MOVE_SPEED;
		if(KeyInput.down)
			position.y += MOVE_SPEED;
		if(KeyInput.right)
			position.x += MOVE_SPEED;
		if(KeyInput.left)
			position.x -= MOVE_SPEED;
	}
	
	
}
