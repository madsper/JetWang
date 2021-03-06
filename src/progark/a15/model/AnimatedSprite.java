package progark.a15.model;

import android.graphics.Canvas;
import android.graphics.RectF;

/*
 * AnimatedSprite is essentially a wrapper for a sprite sheet, and passes all its commands through it.
 */
public class AnimatedSprite extends AbstractPhysSprite {
	private SpriteSheet spriteSheet;

	public AnimatedSprite(SpriteSheet sheet) {
		spriteSheet = sheet;
	}
	
	@Override
	public void update(float dt) {
		super.update(dt);
		//SpriteSheet is not connected to this parents' physics framework, and needs to be updated manually.
		spriteSheet.update(dt);
		spriteSheet.setPosition(getPosition());
	}

	public void draw(Canvas c) {
		spriteSheet.draw(c);
	}

	@Override
	public RectF getPosition() {
		return spriteSheet.getPosition();
	}
	
	@Override
	public void setPosition(RectF r) { 
		super.setPosition(r);
		spriteSheet.setPosition(r);
	}

	public void collided(CollisionListener c) {
		// TODO Auto-generated method stub
		
	}

}
