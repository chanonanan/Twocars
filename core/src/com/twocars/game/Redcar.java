package com.twocars.game;

import com.badlogic.gdx.math.Vector2;


public class Redcar {
	private Vector2 position;
	 public static final int DIRECTION_UP = 1;
	 public static final int DIRECTION_RIGHT = 2;
	 public static final int DIRECTION_DOWN = 3;
	 public static final int DIRECTION_LEFT = 4;
	 public static final int DIRECTION_STILL = 0;
	 private static final int SPEED = 5;
	 private int currentDirection;
	 private int nextDirection;
	 private World world; 
	 
	 
	 
	private static final int [][] DIR_OFFSETS = new int [][] {
		{0,0},
	    {0,-1},
	    {1,0},
	    {0,1},
	    {-1,0}
	};
	    
    public Redcar(int x, int y) {
        position = new Vector2(x,y);
        currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
        this.world = world;
    }   
    
    public void setNextDirection(int dir) {
        nextDirection = dir;
    }
    public Vector2 getPosition() {
        return position;    
    }
    
    public void update() {
   
        position.x += SPEED * DIR_OFFSETS[currentDirection][0];
        position.y += SPEED * DIR_OFFSETS[currentDirection][1];
    }
    
 
    //position 35/160/290/415
    
    public void move(int dir) { 
    	if(position.x >= 165) {
    		position.x = 165;
    	}
    	if(position.x <= 35) {
    		position.x = 35;
    	}
        position.x += 10 * DIR_OFFSETS[dir][0];
    }


}
