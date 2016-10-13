package model;

import java.awt.Image;

public abstract class Entity{

	double x, y, z;
	
	Image sprite;
	
	double spriteScale;
	
	abstract void update(Keyboard keys);
	
	public abstract double getX();
	public abstract void setX(double x);
	public abstract double getY();
	public abstract void setY(double y);
	public abstract double getZ();
	public abstract void setZ(double z);
	public abstract Image getSprite();
	public abstract double spriteScale();
	public abstract void setSpriteScale(double ss);
	public abstract double getSpriteScale();
}
