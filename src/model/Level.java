package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
public class Level {
		
	int levelTimer;
	
	public Image background;
	
	public double camX;

	public double camY;

	public double camZ;

	public double camFocalL;

	public double camFOV;
	
	public List<Entity> entities;
	
	public Level() throws IOException{
		levelTimer = 0;
		this.background = ImageIO.read(new File("./assets/bg.png"));
		this.entities = new ArrayList<Entity>();
		
		camX = 0;
		camY = 0;
		camZ = 400;
		camFocalL = 200;
		camFOV = Math.toRadians(90);
	 
		entities.add(new Ball(-100, 100, -200));
		entities.add(new Ball(-100, -100, -200));
		entities.add(new Ball(100, 100, -200));
		entities.add(new Ball(100, -100, -200));
		
		entities.add(new Ball(-100, 100, -400));
		entities.add(new Ball(-100, -100, -400));
		entities.add(new Ball(100, 100, -400));
		entities.add(new Ball(100, -100, -400));
	}
	
	public void update(Keyboard keys){
		for(int i=0; i<entities.size(); ++i){
			entities.get(i).update(keys);
			++levelTimer;
		}
	}
	
	public double getCamX(){
		return this.camX;
	}
	public double getCamY(){
		return this.camY;
	}
	public double getCamZ(){
		return this.camZ;
	}
	public double getCamFocalL(){
		return this.camFocalL;
	}
	public double getCamFOV(){
		return this.camFOV;
	}
}
