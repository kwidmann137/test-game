package model;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Entity{

	private int x;
	private int y;
	private int radius;
	private Color color;
	
	public Circle(int x, int y, int radius, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
		this.radius = radius;
	}
	
	@Override
	public void updatePosition(int e) {
		if(e == 37){
			this.x -= 4;
		}else if(e == 39){
			this.x += 4;
		}else if(e == 38){
			this.y -= 4;
		}else if(e == 40){
			this.y += 4;
		}
	}

	public Color getColor(){
		return this.color;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x,this.y,this.radius,this.radius);
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString(){
		return String.format("Circle: x = %s y = %s radius = %s color = %s\n", this.x, this.y, this.radius, this.color);
	}
		
}
