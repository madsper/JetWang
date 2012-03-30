package model;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.RectF;


public class GameLayer {
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	//Does this layer check for collision?
	private boolean isPhysical;
	public GameLayer(boolean isPhys) {
		isPhysical=isPhys;
	}

	public void addSprite(Sprite s) {
		sprites.add(s);
	}
	public void removeSprite(Sprite s) {
		sprites.remove(s);
	}

	//Update all sprites and check for collisions
	public void update(float dt) {
		for(Sprite s1 : sprites) {
			s1.update(dt);
			//Uncomment code beneath if only player sprite can collide with other objects. Makes this algorithm O(n) instead of O(n²)
			//if(s1 instanceof PlayerSprite)

			if(isPhysical && s1 instanceof CollisionListener)
				for(Sprite s2 : sprites)
					//Collision detected! Activate casting hell!
					if(RectF.intersects(s1.getPosition(),s2.getPosition()) && s2 instanceof CollisionListener) {
						((CollisionListener) s1).collided((CollisionListener) s2);
						//Comment out line below if only player collides with other objects.
						((CollisionListener) s2).collided((CollisionListener) s1);
					}
		}
	}
	public void draw(Canvas c) {
		for(Sprite s : sprites) {
			s.draw(c);
		}
	}

}
