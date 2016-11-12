package com.twocars.game;

import com.badlogic.gdx.math.Vector2;


public class Ball {
	private Vector2 position;
	private int speed = 10;
	public static float width = 50;
	public static float height = 50;
    private World world; 
    private MyTwocarsGame myTwocarsGame;
    private Bluecar bluecar;
    private Redcar redcar;

    
    public Ball(float x, float y,MyTwocarsGame myTwocarsGame,World world) {
    	this.myTwocarsGame = myTwocarsGame;
    	position = new Vector2(x,y);
    	this.world = world;
    	bluecar = world.getBluecar();
    	redcar = world.getRedcar();
    	
    }   
    
    public Vector2 getPosition() {
		return position;
	}
    

	public void update() {
		position.y -= speed;

	}
	
	public boolean hitEdge(){
		return position.y <= 0;
	}

	public boolean hitBlueCar() {
		if(position.y <= bluecar.getPosition().y + Bluecar.height && position.y <= bluecar.getPosition().y) {
			if(position.x == bluecar.getPosition().x) return true;
		}
		return false;
	}

	public boolean hitRedCar() {
		if(position.y <= redcar.getPosition().y + Redcar.height && position.y <= redcar.getPosition().y) {
			if(position.x == redcar.getPosition().x) return true;
		}
		return false;
	}


}
