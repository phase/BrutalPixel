/**
 * BrutalPixel was made by Jadon Fowler.
 * This file is licensed under the MIT License.
 */
package xyz.jadonfowler.brutalpixel.game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import xyz.jadonfowler.brutalpixel.entities.Mob;
import xyz.jadonfowler.brutalpixel.entities.Player;
import xyz.jadonfowler.brutalpixel.entities.Vector2f;

/**
 * @author Jadon "Phase" Fowler on Feb 7, 2015
 */
public class Game extends JFrame implements Runnable {

	private static final long serialVersionUID = 7604034060268237675L;

	public static final int WIDTH = 1080;
	public static final int HEIGHT = 720;
	public static final Dimension gameDim = new Dimension(WIDTH, HEIGHT);

	// Graphics
	private Graphics2D graphics;
	public Canvas cs = new Canvas();
	private BufferedImage background = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	// Thread
	private Thread gameThread;
	private boolean running = false;
	private static final int FPS = 20;

	// Inputs
	KeyInput keyInput;

	Player player;

	public void run() {
		while (running) {
			// GameLoop
			update();
			render();

			try {
				Thread.sleep(1000 / FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void start() {
		gameThread = new Thread(this);
		running = true;
		gameThread.start();
	}

	public synchronized void stop() {
		try {
			running = false;
			graphics.dispose();
			gameThread.join();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Game() {
		init();
	}

	private void init() {
		this.setSize(gameDim);
		this.setLocationRelativeTo(null);
		this.setResizable(false); // TODO
		this.setTitle("BrutalPixel " + Constants.VERSION);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		cs.setPreferredSize(gameDim);
		cs.setMaximumSize(gameDim);
		cs.setMinimumSize(gameDim);
		this.add(cs, BorderLayout.CENTER);
		
		try {
			BufferedImage playerSprite = 
					ImageIO.read(getClass().getResourceAsStream("/player.png"));
			player = new Player(playerSprite);
			mob = new Mob(Vector2f.c(10, 10), ImageIO.read(getClass().getResourceAsStream("/mob.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		keyInput = new KeyInput();
		cs.addKeyListener(keyInput);
		new MouseInput(this);
		start();
	}

	//TODO
	Mob mob;
	
	private void render() {
		BufferStrategy bs = cs.getBufferStrategy();
		if (bs == null) {
			cs.createBufferStrategy(3);
			return;
		}

		if (graphics == null)
			graphics = (Graphics2D) bs.getDrawGraphics();
		graphics.drawImage(background, 0, 0, WIDTH, HEIGHT, null);

		player.render(graphics);
		mob.render(graphics);

		bs.show();
	}

	private void update() {
		player.update();
		mob.update();
	}

	private class Constants {
		private static final String VERSION = "0.0.1";
	}

}
