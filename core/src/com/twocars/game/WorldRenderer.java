package com.twocars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer{
	
	public static final int BLOCK_SIZE = 50;
	private SpriteBatch batch;
	private MyTwocarsGame mytwocarsGame;
	private Texture bluecarImg;
	private Texture redcarImg;
	private Texture bgImg;
	private Texture ballImg;
	private Texture boxImg;
	private World world;
	private Bluecar bluecar;
	private Redcar redcar;
	private Ball ball;
	private Box box;
	float timeAux = 0;

	public WorldRenderer(MyTwocarsGame mytwocarsGame, World world) {
		this.mytwocarsGame = mytwocarsGame;
		batch = mytwocarsGame.batch;
		this.world = world;
		bluecarImg = new Texture("bluecar.png");
    	redcarImg = new Texture("redcar.png");
    	bgImg = new Texture("bg.jpg");
    	ballImg = new Texture("ball.png");
    	boxImg = new Texture("box.png");
    	bluecar = world.getBluecar();
    	redcar = world.getRedcar();

	}
	
    public void render(float delta) {
    	
        SpriteBatch batch = mytwocarsGame.batch;
        batch.begin();
        Vector2 pos_blue = bluecar.getPosition();
        Vector2 pos_red = redcar.getPosition();
        batch.draw(bgImg, 0, 0);
        batch.draw(bluecarImg, pos_blue.x, pos_blue.y);
        batch.draw(redcarImg, pos_red.x, pos_red.y);
        
		if(timeAux >=0.5){ //10 seconds
			System.out.println("Hello " + timeAux);
			if(delta*1000 > 17){
				batch.draw(ballImg, 35, 500);
			}else {
				batch.draw(boxImg, 35, 500);
			}
            timeAux=0;
        }else{
            timeAux+=delta;
            System.out.println("Hello 2:" + timeAux);
        }
		
        batch.end();
    }
}
