package view;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;

import controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Window extends JFrame{
	
	private ArrayList<model.Entity> allEntities;
	private GameScreen gameScreen;
	private Graphics g;
	private Controller controller;
	
	public Window(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setVisible(true);
		this.allEntities = new ArrayList<model.Entity>();
		this.controller = new Controller();
		
		//add key listener to window to control object
		KeyHandler handler = new KeyHandler();
		this.addKeyListener(handler);
		
		//get graphics object
		this.g = this.getGraphics();
		
		//get main menu
		//THIS WILL REPLCE GAME SCREEN
		
		//get gamescreen
		this.gameScreen = new GameScreen(g);
		this.add(gameScreen);		
	}
	public void renderMenu(){
		//Set up rendering for main menu
	}
	public void renderGame(){		
		//get allEntities and render
		allEntities = controller.getEntities();
		gameScreen.setEntities(allEntities);
		gameScreen.repaint();
	}
	
	private class KeyHandler implements KeyListener{
		
		
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
//			If key pressed equals say ESC, then stop game
//			if( e.getKeyCode() == ){
//				
//			}
			controller.updateCircle(e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
	}
}
