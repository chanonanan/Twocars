package com.twocars.game;

import com.badlogic.gdx.math.Vector2;

public class Box {
	private Vector2 position;
	private int speed = 10;
    private World world; 

    
    public Box(int x, int y) {
    	position = new Vector2(x,y);
    	this.world = world;
    }   
    
    public Vector2 getPosition() {
		return position;
	}
    

	public void update() {
		position.y -= speed;
	}
	
	public boolean hitEdge(){
		return position.y <= -51;
	}


}
