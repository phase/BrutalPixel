package xyz.jadonfowler.brutalpixel.entities;

public class Vector2f {

	public float x, y;

	public Vector2f(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public static Vector2f c(int i, int j) {
		return new Vector2f(i, i);
	}

}
