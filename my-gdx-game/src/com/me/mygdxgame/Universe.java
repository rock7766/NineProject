package com.me.mygdxgame;

import com.badlogic.gdx.math.Vector2;

public class Universe {
	Bullet bullet;
	Bullet[] ary = new Bullet[10];
	Airplane airplane;
	
	public Bullet getBullet() {
		return this.bullet;
	}
	
	public Bullet[] getBulletAry() {
		return ary;
	}
	
	public Airplane getAirplane() {
		return this.airplane;
	}
	
	public Universe() {
		this.createUniverse();
	}
	
	private void createUniverse() {
		bullet = new Bullet(new Vector2(7,2));
		for (int i = 0; i < ary.length; i++) {
			ary[i] = new Bullet(new Vector2(i,0));
			ary[i].setVelocity((float)Math.random()*8-4, (float)Math.random()*4); //x: -1~1, y: 0~4
		}
		airplane = new Airplane(new Vector2(5f,3.5f));
	}
	
}
