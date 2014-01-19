package com.me.mygdxgame;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Airplane {
	static final float SPEED = 4f;
	static final float SIZE = 0.3f;
	
	private Vector2 position = new Vector2();
	private Vector2 velocity = new Vector2();
	private Rectangle bounds = new Rectangle();
	
	public Airplane(Vector2 position) {
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
		this.velocity.set(0, 0);
	}
	
	public Vector2 getPosition() {
		return this.position;
	}
	
	public Rectangle getBounds() {
		return this.bounds;
	}
	
	public Vector2 getVelocity() {
		return this.velocity;
	}
	
	public void setVelocity(float x, float y) {
		this.velocity.x = x;
		this.velocity.y = y;
	}
	
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));
	}
}
