package com.me.mygdxgame;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Universe {
	Bullet bullet;
	Array<Bullet> arylist;
//	Bullet[] ary = new Bullet[10];
	Airplane airplane;
	
	public Bullet getBullet() {
		return this.bullet;
	}
	
	public Array<Bullet> getBulletAry() {
		return arylist;
	}
	
	public Airplane getAirplane() {
		return this.airplane;
	}
	
	public Universe() {
		this.createUniverse();
	}
	
	private void createUniverse() {
		bullet = new Bullet(new Vector2(7,2));
		arylist = new Array<Bullet>();
		airplane = new Airplane(new Vector2(5f,3.5f));
	}
	
}
