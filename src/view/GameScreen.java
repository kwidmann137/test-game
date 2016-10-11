package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import model.Entity;

import javax.swing.JPanel;

public class GameScreen extends JPanel{
	
	private Graphics g;
	private ArrayList<Entity> allEntities;
	
	public GameScreen(Graphics g){
		super();
		this.setBackground(Color.WHITE);
		this.g = g;
		this.allEntities = new ArrayList<Entity>();
	}
	
	public void setEntities(ArrayList<Entity> allEntities){
		this.allEntities = allEntities;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);  //Clear the screen
		
		for(Entity temp : allEntities){
			temp.draw(g);
		}
	}
}
