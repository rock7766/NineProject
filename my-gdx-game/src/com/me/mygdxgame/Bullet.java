package com.me.mygdxgame;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
	static final float SPEED = 4f;
	static final float SIZE = 0.05f;
	
	private Vector2 position = new Vector2();
	private Vector2 velocity = new Vector2();
	private Rectangle bounds = new Rectangle();
	private Circle cir = new Circle();
	
	public Bullet(Vector2 position) {
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
		cir.set(position, this.SIZE);
	}
	
	public Vector2 getPosition() {
		return this.position;
	}
	
	public Rectangle getBounds() {
		return this.bounds;
	}
	
	public Circle getCircle() {
		return this.cir;
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
		cir.set(position, this.SIZE);
	}
	
	static public Bullet Generator(int position){
		Bullet bullet;
		Vector2 pos = new Vector2(0,0);
		Vector2 direct = new Vector2(0,0);
		switch(position){
		case 0:pos.x= MathUtils.random(10);pos.y=7.5f;
		direct.add(MathUtils.random(-1,1), -MathUtils.random(1,2));
		break;		
		case 1:pos.x= MathUtils.random(10);
		direct.add(MathUtils.random(-1,1), MathUtils.random(1,2));
		break;		
		case 2:pos.y= MathUtils.random();pos.x=10;
		direct.add(-MathUtils.random(1,2), MathUtils.random(-1,1));
		break;		
		case 3:pos.y= MathUtils.random(10);
		direct.add(MathUtils.random(1,2), MathUtils.random(-1,1));
		break;
		default:break;
		}
		bullet = new Bullet(pos);
		bullet.setVelocity(direct.x, direct.y);
		return bullet;		
	}

}
