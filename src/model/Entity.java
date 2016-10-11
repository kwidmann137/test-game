package model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity {
	
	public abstract Color getColor();
	
	public abstract void updatePosition(int x);
	
	public abstract void draw(Graphics g);
	
}
