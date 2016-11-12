package com.twocars.game;

import com.badlogic.gdx.math.Vector2;


public class Ball {
	private Vector2 position;
	private int speed = 10;
    private World world; 
    private MyTwocarsGame myTwocarsGame;
    private Bluecar bluecar;
    private Redcar redcar;

    
    public Ball(int x, int y,MyTwocarsGame myTwocarsGame,World world) {
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
		return position.x <= 0;
	}

	public boolean hitBlueCar() {
		return position.x > bluecar.getPosition().x && 
				position.x < bluecar.getPosition().x + Bluecar.width && 
				position.y > bluecar.getPosition().y && 
				position.y < bluecar.getPosition().y + Bluecar.height;
	}

	public boolean hitRedCar() {
		return position.x > redcar.getPosition().x && 
				position.x < redcar.getPosition().x + Redcar.width && 
				position.y > redcar.getPosition().y && 
				position.y < redcar.getPosition().y + Redcar.height;
	}


}
