package view;

import javax.swing.*;
import model.Level;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Window extends JFrame implements KeyListener{	
	final int
		displayWidth,
		displayHeight;
	
	final private GameScreen panel;
	final private List<KeyEvent> inputBuffer;
	
	public Window(String name, int width, int height){
		super(name);
		displayWidth = width;
		displayHeight = height;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);				
		
		panel = new GameScreen(displayWidth, displayHeight);
		panel.setPreferredSize(new Dimension(displayWidth, displayHeight));
		
		setContentPane(panel);
		pack();
		
		inputBuffer = new ArrayList<KeyEvent>();
		addKeyListener(this);
		
		setVisible(true);
	}
	
	//Input listening and access
	public void keyPressed(KeyEvent e){inputBuffer.add(e);}
	public void keyReleased(KeyEvent e){inputBuffer.add(e);}
	public void keyTyped(KeyEvent e){}
	
	public List<KeyEvent> getInputBuffer(){
		List<KeyEvent> inputs = new ArrayList<KeyEvent>(inputBuffer);
		inputBuffer.clear();
		return inputs;
	}

	public void render(Level level, List<model.Entity> levelEntities) {
		//get game state and either render main menu or game...
		// since no main menu yet, just render game for now.
		panel.renderGame(level, levelEntities);
	}
}



//System.out.print("In render Game\n");
//double xTranslates;
//double yTranslates;
//double zTranslates;
//double spriteScale;
////Transform world space to view space.
////TODO Rotatable camera.
//for(model.Entity temp : vEnts){
//	xTranslates = temp.getX() - level.getCamX();
//	yTranslates = temp.getY() - level.getCamY();
//	zTranslates = temp.getZ() - level.getCamZ();
//}
//
////Transform view space to image plane, and set spriteScale.
//for(model.Entity temp : vEnts){
//	xTranslates = -level.camFocalL * (temp.getX() / temp.getZ());
//	yTranslates = -level.camFocalL * (temp.getY() / temp.getZ());
//	spriteScale = 4 * temp.getSpriteScale() * level.camFocalL / temp.getZ();
//}
//
////Transform image plane to normalized square display plane [-1.0, 1.0] x [-1.0, 1.0].
//for(model.Entity temp : vEnts){
//	xTranslates = temp.getX() / (level.camFocalL * Math.tan(level.camFOV/2));
//	yTranslates = temp.getY() / (level.camFocalL * Math.tan(level.camFOV/2));
//}
//
////Transform normalized display plane to actual display plane.
//for(model.Entity temp : vEnts){
//	xTranslates = temp.getX() * displayWidth + displayWidth/2;
//	yTranslates = temp.getY() * displayWidth + displayHeight/2;
//}
//
////Sort viewEntities by z-depth.
//Collections.sort(vEnts, new Comparator<model.Entity>(){
//	public int compare(model.Entity v1, model.Entity v2){
//		return (int)(v1.getZ() - v2.getZ());
//	}
//});
//
////Draw background.
//bufferGraphics.drawImage(level.background, 0, 0, null);
//
////Draw entities.
//for(model.Entity temp : vEnts){
//	if(temp.getZ() < 0){
//		System.out.printf("About to draw: %s\n", temp);
//		bufferGraphics.drawImage(
//			temp.getSprite(),
//			new AffineTransform(
//				temp.getSpriteScale(),
//				0.0,
//				0.0,
//				temp.getSpriteScale(),
//				temp.getX() - temp.getSprite().getWidth(null)*temp.getSpriteScale() / 2,
//				temp.getY() - temp.getSprite().getHeight(null)*temp.getSpriteScale() / 2
//			),
//			null
//		);
//	}
//}