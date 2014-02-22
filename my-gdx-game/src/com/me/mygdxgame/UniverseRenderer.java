package com.me.mygdxgame;

import java.util.Iterator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class UniverseRenderer {
	private Universe universe;
	private OrthographicCamera cam;
	
	/** for debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();
	
	public UniverseRenderer(Universe universe) {
		this.universe = universe;
		this.cam = new OrthographicCamera(10, 7);
		this.cam.position.set(5, 3.5f, 0);
		this.cam.update();
	}
	
	public void render() {
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Filled);
		
		// render Bullet
		Bullet bullet = universe.getBullet();
		Circle cir = bullet.getCircle();
		debugRenderer.setColor(new Color(0, 1, 0, 1));
		debugRenderer.circle(cir.x, cir.y, cir.radius,50);
		
		// render many Bullet
		Array<Bullet> ary = universe.getBulletAry();
		Iterator<Bullet> iter = ary.iterator();
		while(iter.hasNext()) {
			   Bullet temp = iter.next();
			   Circle cir1 = temp.getCircle();
				debugRenderer.setColor(new Color(0, 1, 0, 1));
				debugRenderer.circle(cir1.x, cir1.y, cir.radius,50);			   
	   }

		
		// render airplane
		Airplane airplane = universe.getAirplane();
		Rectangle rect = airplane.getBounds();
		float x1 = airplane.getPosition().x + rect.x;
		float y1 = airplane.getPosition().y + rect.y;
		debugRenderer.setColor(new Color(1, 0, 1, 0));
		debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.end();
	}


}
