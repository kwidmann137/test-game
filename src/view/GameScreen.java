package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Level;

import javax.swing.JPanel;

public class GameScreen extends JPanel{
	private BufferedImage drawBuffer;
	private Graphics2D bufferGraphics;
	private int displayWidth;
	private int displayHeight;
	
	public GameScreen(int displayWidth, int displayHeight){
		this.drawBuffer = new BufferedImage(displayWidth, displayHeight, BufferedImage.TYPE_INT_ARGB);		
		this.bufferGraphics = drawBuffer.createGraphics();
		this.displayWidth = displayWidth;
		this.displayHeight = displayHeight;
	}
	
	//	public void renderMenu(){
	//	//Set up rendering for main menu
	//}
	
	public void renderGame(Level level, List<model.Entity> levelEntities){		
		
		List<ViewEntity> vEnts = new ArrayList<ViewEntity>();
		int numEntities = levelEntities.size();
		
		//Create viewEntities from Level.entities.
		for(int i=0; i<numEntities; ++i){
			vEnts.add(new ViewEntity(levelEntities.get(i)));
		}
		
		//Transform world space to view space.
		//TODO Rotatable camera.
		for(int i=0; i<numEntities; ++i){
			vEnts.get(i).x += -level.camX;
			vEnts.get(i).y += -level.camY;
			vEnts.get(i).z += -level.camZ;
		}
		
		//Transform view space to image plane, and set spriteScale.
		for(int i=0; i<numEntities; ++i){
			vEnts.get(i).x =
				-level.camFocalL * (vEnts.get(i).x / vEnts.get(i).z);
			vEnts.get(i).y =
				-level.camFocalL * (vEnts.get(i).y / vEnts.get(i).z);
			
			vEnts.get(i).spriteScale = 4 * vEnts.get(i).spriteScale * level.camFocalL / vEnts.get(i).z;
		}
		
		//Transform image plane to normalized square display plane [-1.0, 1.0] x [-1.0, 1.0].
		for(int i=0; i<numEntities; ++i){
			vEnts.get(i).x =
				vEnts.get(i).x / (level.camFocalL * Math.tan(level.camFOV/2));
			vEnts.get(i).y =
				vEnts.get(i).y / (level.camFocalL * Math.tan(level.camFOV/2));
		}
		
		//Transform normalized display plane to actual display plane.
		for(int i=0; i<numEntities; ++i){
			vEnts.get(i).x =
				vEnts.get(i).x * displayWidth + displayWidth/2;
			vEnts.get(i).y =
				-vEnts.get(i).y * displayWidth + displayHeight/2;
		}
		
		//Sort viewEntities by z-depth.
		Collections.sort(vEnts, new Comparator<ViewEntity>(){
			public int compare(ViewEntity v1, ViewEntity v2){
				return (int)(v1.z - v2.z);
			}
		});
		
		//Draw background.
		bufferGraphics.drawImage(level.background, 0, 0, null);
		
		//Draw entities.
		for(int i=0; i<numEntities; ++i){
			if(vEnts.get(i).z < 0){
				bufferGraphics.drawImage(
					vEnts.get(i).sprite,
					new AffineTransform(
						vEnts.get(i).spriteScale,
						0.0,
						0.0,
						vEnts.get(i).spriteScale,
						vEnts.get(i).x - vEnts.get(i).sprite.getWidth(null)*vEnts.get(i).spriteScale / 2,
						vEnts.get(i).y - vEnts.get(i).sprite.getHeight(null)*vEnts.get(i).spriteScale / 2
					),
					null
				);
			}
		}
		repaint();
	}
	
	protected void paintComponent(Graphics g){
		g.drawImage(drawBuffer, 0, 0, null);			
	}

	class ViewEntity{
		double x, y, z;
		Image sprite;
		double spriteScale;
		
		ViewEntity(model.Entity entity){
			this.x = entity.getX();
			this.y = entity.getY();
			this.z = entity.getZ();
			this.sprite = entity.getSprite();
			this.spriteScale = entity.getSpriteScale();
		}
		
		public String toString(){
			return String.format("x = %s, y= %s, z= %s, sprite = %s, spriteScale = %s", this.x, this.y, this.z, this.sprite, this.spriteScale);
		}
	}
}
