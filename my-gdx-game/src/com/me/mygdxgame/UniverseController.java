package com.me.mygdxgame;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class UniverseController {
	private Universe universe;
	private Bullet bullet;
	private Airplane airplane;
	
	enum Keys {
		UP,DOWN,LEFT,RIGHT;
	}
	
	static Map<Keys, Boolean> keys = new HashMap<UniverseController.Keys, Boolean>();
	static {
	    keys.put(Keys.LEFT, false);
	    keys.put(Keys.RIGHT, false);
	    keys.put(Keys.UP, false);
	    keys.put(Keys.DOWN, false);
	};

	
	public UniverseController(Universe universe) {
		this.universe = universe;
		this.bullet = universe.getBullet();
		this.airplane = universe.getAirplane();
	}
	
	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}
	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}
	public void upPressed() {
		keys.get(keys.put(Keys.UP, true));
	}
	public void downPressed() {
		keys.get(keys.put(Keys.DOWN, true));
	}
	
	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}
	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}
	public void upReleased() {
		keys.get(keys.put(Keys.UP, false));
	}
	public void downReleased() {
		keys.get(keys.put(Keys.DOWN, false));
	}
	
	public void processInput() {
		if (keys.get(Keys.LEFT)) {
			airplane.getVelocity().x = -Airplane.SPEED;
		}
		if (keys.get(Keys.RIGHT)) {
			airplane.getVelocity().x = Airplane.SPEED;
		}
		if (keys.get(Keys.UP)) {
			airplane.getVelocity().y = Airplane.SPEED;
		}
		if (keys.get(Keys.DOWN)) {
			airplane.getVelocity().y = -Airplane.SPEED;
		}
		if (!keys.get(Keys.LEFT) && !keys.get(Keys.RIGHT)) {
			airplane.getVelocity().x = 0;
		}
		if (!keys.get(Keys.UP) && !keys.get(Keys.DOWN)) {
			airplane.getVelocity().y = 0;
		}
		if (keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) {
			airplane.getVelocity().x = 0;
		}
		if (keys.get(Keys.UP) && keys.get(Keys.DOWN)) {
			airplane.getVelocity().y = 0;
		}
		if(!keys.get(Keys.LEFT) && !keys.get(Keys.RIGHT) && !keys.get(Keys.UP) && !keys.get(Keys.DOWN)) {
			airplane.setVelocity(0, 0);
		}
	}

	
	public void update(float delta) {
		processInput();
		airplane.update(delta);
		bullet.setVelocity(-4.0f, 1);
		bullet.update(delta);
		
		// update many bullet
		Array<Bullet> ary = universe.getBulletAry();
		ary.add(Bullet.Generator(MathUtils.random(0,3)));
		Iterator<Bullet> iter = ary.iterator();
		while(iter.hasNext()) {
			   Bullet temp = iter.next();
			   temp.update(delta);
			   if(temp.getPosition().x<0 || temp.getPosition().x>10
					   ||temp.getPosition().y<0 || temp.getPosition().y>7.5 ){
				   iter.remove();
			   }
	   }
	}
}
