package com.twocars.game;

import com.badlogic.gdx.math.Vector2;

public class Redcar {
	private Vector2 position;
	public static float width = 50;
	public static float height = 96;
	private static final int SPEED = 5;
	private int moveAccel = 1;
	private int moveSpeed;
	 
	private static final int [][] DIR_OFFSETS = new int [][] {
		{0,0},
	    {0,-1},
	    {1,0},
	    {0,1},
	    {-1,0}
	};
	    
    public Redcar(int x, int y) {
        position = new Vector2(x,y);
    }   
    
    
    public Vector2 getPosition() {
        return position;    
    }
    
    public void update() {
    	
    }
    
    //position 35/160/290/415
    
    public void move(int dir) { 
    	if(position.x >= 160) {
    		position.x = 160;
    	}
    	if(position.x <= 35) {
    		position.x = 35;
    	}
        
        for (int i=1 ;i<=125 ;i++) {
        	position.x += 1 * DIR_OFFSETS[dir][0];
        }
    }


	public void move2(boolean isRedcarMoved) {
		while(true) {
			if(isRedcarMoved) {
				if (position.x < 160) {
					position.x += moveSpeed;
					moveSpeed += moveAccel;
					if (position.x > 160) {
						position.x = 160;
						break;
					}
				}
			}else {
				if (position.x > 35) {
					position.x -= moveSpeed;
					moveSpeed += moveAccel;
					if (position.x < 35) {
						position.x = 35;
						break;
					}
				}
			}
		}
		
	}
}
