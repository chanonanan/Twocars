package com.twocars.game;

import com.badlogic.gdx.math.Vector2;




public class Ball {
	private Vector2 position;
	private int speed = 1;
    private World world; 
    
    
    public Ball(int x, int y) {
        position = new Vector2(x,y);
        this.world = world;
    }    

	public void update()
	{
		position.y -= speed;
	}
	
	public Vector2 getPosition()
	{
		return position;
	}
	
	public void remove () {
		
	}
	
	public boolean hitEdge()
	{
		return position.y <= 0;
	}
	//public boolean hitBoss()
//	{
	//	return position.x > boss.getPosition().x && 
//				position.x < boss.getPosition().x + Boss.width && 
//				position.y > boss.getPosition().y && 
//				position.y < boss.getPosition().y + Boss.height;
//	}
}
