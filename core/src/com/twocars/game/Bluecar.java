package com.twocars.game;

import com.badlogic.gdx.math.Vector2;

public class Bluecar {
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
  
    public Bluecar(int x, int y) {
        position = new Vector2(x,y);
    }    
    
     
    public Vector2 getPosition() {
        return position;    
    }
    
    public void update() {

    }
    //position 35/160/290/415
    
    public void move(int dir) { 
        	if(position.x >= 420) {
        		position.x = 420;
        	}
        	if(position.x <= 290) {
        		position.x = 290;
        	}
            
            for (int i=1 ;i<=130 ;i++) {
            	position.x += 1 * DIR_OFFSETS[dir][0];
            }
    }

	public void move2(boolean isBluecarMoved) {
		while(true) {
			if(!isBluecarMoved) {
//				position.x = 420;
				if (position.x < 420) {
					position.x += moveSpeed;
					moveSpeed += moveAccel;
					if (position.x > 420) {
						position.x = 420;
					break;
					}
				}
			} else {
//				position.x = 290;
				if (position.x > 290) {			
					position.x -= moveSpeed;
					moveSpeed += moveAccel;
					if (position.x < 290) {
						position.x = 290;
						break;
					}
				}
			}
		}
	}

}
