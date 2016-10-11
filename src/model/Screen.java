package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Screen extends JPanel{
	
	public Graphics g;
	private ArrayList<model.Entity> allEntities;
	
	public Screen(){
		this.setBackground(Color.WHITE);
		this.g = this.getGraphics();
		this.allEntities = new ArrayList<Entity>();
	}
	
	public Graphics getGraphics(){
		return this.g;
	}
	
	@Override
	public void paintComponent(Graphics g){
		System.out.println(g);
//		super.paintComponent(g);
		for(Entity temp : allEntities){
			System.out.println(g);
//			temp.draw(g);
		}
	}
	
	public void addEntity(Entity entity){
		allEntities.add(entity);
	}
}
