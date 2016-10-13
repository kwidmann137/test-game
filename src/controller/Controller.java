package controller;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import model.*;

import javax.swing.SwingUtilities;

import view.Window;;

public class Controller {

	private static Window window;
	private static int displayWidth, displayHeight;
	private static List<KeyEvent> inputQue;
	private static Keyboard keys;
	private static long loopStartTime;
	private static Level currentLevel;
	
	public static void main(String[] args) throws InterruptedException, InvocationTargetException {
		initWindow();
		
		//main loop
		while(true){
			loopStartTime = System.nanoTime();
			
			//Read
			Read();
			
			//Eval
			Eval();
			
			//Print
			Print();
			
			while((System.nanoTime() - loopStartTime) < ( (1000*1000*1000)/60) ){
				Thread.sleep(1);
			}
		}
	}
	
	public static void initWindow() throws InvocationTargetException, InterruptedException{
		//Initialize
		inputQue = new ArrayList<KeyEvent>();
		keys = new Keyboard();
		displayWidth = 800;
		displayHeight = 600;
		
		
		
		try {
			currentLevel = new Level();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				window = new Window("Lunar Strike", displayWidth, displayHeight);
			}
		});
	}
	
	public static void Read() throws InvocationTargetException, InterruptedException{
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				inputQue = window.getInputBuffer();
			}
		});
	}
	
	public static void Eval(){
		keys.update(inputQue);
		if(keys.escPressed){ System.exit(0);}
		currentLevel.update(keys);
	}
	
	public static void sync(){
		
	}
	
	public static void Print(){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				window.render(currentLevel, currentLevel.entities);
			}
		});
	}
}
