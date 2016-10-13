package model;

import java.awt.event.KeyEvent;
import java.util.List;

//Models the physical state of keyboard keys.
public class Keyboard{
	
	final int
		PRESSED = 401,
		RELEASED = 402,
		
		LEFT = 37,
		UP = 38,
		RIGHT = 39,
		DOWN = 40,
		
		ONE = 49,
		TWO = 50,
		THREE = 51,
		FOUR = 52,
		FIVE = 53,
		SIX = 54,
		SEVEN = 55,
		EIGHT = 56,
		NINE = 57,
		ZERO = 48,
		
		A = 65,
		B = 66,
		C = 67,
		D = 68,
		E = 69,
		F = 70,
		G = 71,
		H = 72,
		I = 73,
		J = 74,
		K = 75,
		L = 76,
		M = 77,
		N = 78,
		O = 79,
		P = 80,
		Q = 81,
		R = 82,
		S = 83,
		T = 84,
		U = 85,
		V = 86,
		W = 87,
		X = 88,
		Y = 89,
		Z = 90,
		
		ESC = 27,
		ENTER = 13;
	
	Boolean
		leftHeld = false,
		upHeld = false,
		rightHeld = false,
		downHeld = false,
		
		oneHeld = false,
		twoHeld = false,
		threeHeld = false,
		fourHeld = false,
		fiveHeld = false,
		sixHeld = false,
		sevenHeld = false,
		eightHeld = false,
		nineHeld = false,
		zeroHeld = false,
		
		aHeld = false,
		bHeld = false,
		cHeld = false,
		dHeld = false,
		eHeld = false,
		fHeld = false,
		gHeld = false,
		hHeld = false,
		iHeld = false,
		jHeld = false,
		kHeld = false,
		lHeld = false,
		mHeld = false,
		nHeld = false,
		oHeld = false,
		pHeld = false,
		qHeld = false,
		rHeld = false,
		sHeld = false,
		tHeld = false,
		uHeld = false,
		vHeld = false,
		wHeld = false,
		xHeld = false,
		yHeld = false,
		zHeld = false,
		
		escHeld = false;

	public Boolean escPressed = false;

	Boolean enterHeld = false;

	Boolean enterPressed = false;
	
	public Keyboard(){}
	
	public void update(List<KeyEvent> inputQue){
		
		escPressed = false;
		enterPressed = false;
		
		for(int i=0; i<inputQue.size(); ++i){
			if(inputQue.get(i).getID() == PRESSED){
				switch(inputQue.get(i).getKeyCode()){
					case LEFT:  leftHeld = true;  break;
					case UP:    upHeld = true;    break;
					case RIGHT: rightHeld = true; break;
					case DOWN:  downHeld = true;  break;
					
					case ONE:   oneHeld = true;   break;
					case TWO:   twoHeld = true;   break;
					case THREE: threeHeld = true; break;
					case FOUR:  fourHeld = true;  break;
					case FIVE:  fiveHeld = true;  break;
					case SIX:   sixHeld = true;   break;
					case SEVEN: sevenHeld = true; break;
					case EIGHT: eightHeld = true; break;
					case NINE:  nineHeld = true;  break;
					case ZERO:  zeroHeld = true;  break;
					
					case A:     aHeld = true;     break;
					case B:     bHeld = true;     break;
					case C:     cHeld = true;     break;
					case D:     dHeld = true;     break;
					case E:     eHeld = true;     break;
					case F:     fHeld = true;     break;
					case G:     gHeld = true;     break;
					case H:     hHeld = true;     break;
					case I:     iHeld = true;     break;
					case J:     jHeld = true;     break;
					case K:     kHeld = true;     break;
					case L:     lHeld = true;     break;
					case M:     mHeld = true;     break;
					case N:     nHeld = true;     break;
					case O:     oHeld = true;     break;
					case P:     pHeld = true;     break;
					case Q:     qHeld = true;     break;
					case R:     rHeld = true;     break;
					case S:     sHeld = true;     break;
					case T:     tHeld = true;     break;
					case U:     uHeld = true;     break;
					case V:     vHeld = true;     break;
					case W:     wHeld = true;     break;
					case X:     xHeld = true;     break;
					case Y:     yHeld = true;     break;
					case Z:     zHeld = true;     break;
					
					case ESC:   if(!escHeld){
					            	escPressed = true;
					            }
					            escHeld = true;   break;
					case ENTER: if(!enterHeld){
                      	enterPressed = true;
                      }
                      enterHeld = true; break;
				}
			} else{
				switch(inputQue.get(i).getKeyCode()){
					case LEFT:  leftHeld = false;  break;
					case UP:    upHeld = false;    break;
					case RIGHT: rightHeld = false; break;
					case DOWN:  downHeld = false;  break;
					
					case ONE:   oneHeld = false;   break;
					case TWO:   twoHeld = false;   break;
					case THREE: threeHeld = false; break;
					case FOUR:  fourHeld = false;  break;
					case FIVE:  fiveHeld = false;  break;
					case SIX:   sixHeld = false;   break;
					case SEVEN: sevenHeld = false; break;
					case EIGHT: eightHeld = false; break;
					case NINE:  nineHeld = false;  break;
					case ZERO:  zeroHeld = false;  break;
					
					case A:     aHeld = false;     break;
					case B:     bHeld = false;     break;
					case C:     cHeld = false;     break;
					case D:     dHeld = false;     break;
					case E:     eHeld = false;     break;
					case F:     fHeld = false;     break;
					case G:     gHeld = false;     break;
					case H:     hHeld = false;     break;
					case I:     iHeld = false;     break;
					case J:     jHeld = false;     break;
					case K:     kHeld = false;     break;
					case L:     lHeld = false;     break;
					case M:     mHeld = false;     break;
					case N:     nHeld = false;     break;
					case O:     oHeld = false;     break;
					case P:     pHeld = false;     break;
					case Q:     qHeld = false;     break;
					case R:     rHeld = false;     break;
					case S:     sHeld = false;     break;
					case T:     tHeld = false;     break;
					case U:     uHeld = false;     break;
					case V:     vHeld = false;     break;
					case W:     wHeld = false;     break;
					case X:     xHeld = false;     break;
					case Y:     yHeld = false;     break;
					case Z:     zHeld = false;     break;
					
					case ESC:   escHeld = false;   break;
					case ENTER: enterHeld = false; break;
				}
			}
		}
	}
}
