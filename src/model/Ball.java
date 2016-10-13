package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ball extends Entity{
	
	int	moveSpeed;
	
	public Ball(int x, int y, int z) throws IOException{
		this.x = x;
		this.y = y;
		this.z = z;
		moveSpeed = 4;
		
		sprite = ImageIO.read(new File("./assets/ball.png"));
		spriteScale = 1;
	}
	
	public void update(Keyboard keys){
		if(keys.upHeld && !keys.downHeld){y += moveSpeed;}
		else if(keys.downHeld && !keys.upHeld){y += -moveSpeed;}
		
		if(keys.leftHeld && !keys.rightHeld){x += -moveSpeed;}
		else if(keys.rightHeld && !keys.leftHeld){x += moveSpeed;}
		
		if(keys.zHeld && !keys.xHeld){z += -moveSpeed;}
		else if(keys.xHeld && !keys.zHeld){z += moveSpeed;}
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public double getZ() {
		// TODO Auto-generated method stub
		return this.z;
	}

	@Override
	public Image getSprite() {
		// TODO Auto-generated method stub
		return this.sprite;
	}

	@Override
	public double spriteScale() {
		// TODO Auto-generated method stub
		return this.spriteScale;
	}

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	@Override
	public void setZ(double z) {
		// TODO Auto-generated method stub
		this.z = z;
	}
	public void setSpriteScale(double ss) {
		// TODO Auto-generated method stub
		this.spriteScale = ss;
	}
	public double getSpriteScale() {
		// TODO Auto-generated method stub
		return spriteScale;
	}
	
	public String toString(){
		return String.format("x = %s, y= %s, z= %s, sprite = %s, spriteScale = %s", this.x, this.y, this.z, this.sprite, this.spriteScale);
	}
}
