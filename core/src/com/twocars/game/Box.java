package com.twocars.game;

import com.badlogic.gdx.math.Vector2;

public class Box {
	private Vector2 position;
	private float speed = 7f;
    private World world; 
    private MyTwocarsGame myTwocarsGame;
	public static float width = 50;
	public static float height = 50;
    private Bluecar bluecar;
    private Redcar redcar;

    
    public Box(float x, float y,MyTwocarsGame myTwocarsGame,World world) {
    	position = new Vector2(x,y);
    	this.myTwocarsGame = myTwocarsGame;
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
		return position.y <= -height;
	}

	public boolean hitBlueCar() {
		if(position.y <= bluecar.getPosition().y + Bluecar.height 
				&& position.y <= bluecar.getPosition().y
				&& position.x == bluecar.getPosition().x) return true;

		return false;
	}

	public boolean hitRedCar() {
		if(position.y <= redcar.getPosition().y + Redcar.height 
				&& position.y <= redcar.getPosition().y 
				&& position.x == redcar.getPosition().x) return true;

		return false;
	}


}
