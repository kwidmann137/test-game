package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.*;
import view.Window;;

public class Controller {

	private static Window window;
	private static boolean keepRunning = true;
	private static ArrayList<Entity> allEntities = new ArrayList<Entity>();
	private double secPerUpdate = 1/30;
//	private double previous = getTime();
//	double steps = 0.0;
	
	public static void main(String[] args) throws InterruptedException {
		createCircle();
		initWindow();
		
		//Game Loop
		while(keepRunning){
			window.renderGame();
		}
	}
	
	public ArrayList<Entity> getEntities(){
		return allEntities;
	}
	
	public void updateCircle(int e){
		for(Entity temp : allEntities){
			temp.updatePosition(e);
		}
	}
	
	public static void createCircle(){
		allEntities.add(new Circle(280, 280, 40, Color.RED));
	}
	
	public static void initWindow(){
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					window = new Window("Moving Circle");
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopGame(){
		keepRunning = false;
	}
}
