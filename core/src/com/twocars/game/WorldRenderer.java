package com.twocars.game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	private Texture ball2Img;
	private Texture boxImg;
	private Texture box2Img;
	private World world;
	private MyTwocarsGame myTwocarsGame;
	private Bluecar bluecar;
	private Redcar redcar;
	float timeAux = 0;
	public static int posSpawn;
	private int posSpawn2;
	private double timeAux2 = 0;
	private List<Ball> ball;
	private List<Box> box;
    private BitmapFont font;


	public WorldRenderer(MyTwocarsGame mytwocarsGame, World world) {
		this.mytwocarsGame = mytwocarsGame;
		batch = mytwocarsGame.batch;
		this.world = world;
		bluecarImg = new Texture("bluecar.png");
    	redcarImg = new Texture("redcar.png");
    	bgImg = new Texture("bg.jpg");
    	ballImg = new Texture("ball.png");
    	ball2Img = new Texture("ball2.png");
    	boxImg = new Texture("box.png");
    	box2Img = new Texture("box2.png");
    	bluecar = world.getBluecar();
    	redcar = world.getRedcar();
        font = new BitmapFont();



	}
	
    public void render(float delta) {
    	
        SpriteBatch batch = mytwocarsGame.batch;
        batch.begin();
        Vector2 pos_blue = bluecar.getPosition();
        Vector2 pos_red = redcar.getPosition();
	
        
        batch.draw(bgImg, 0, 0);


	    font.draw(batch, "HI-SCORE : " + mytwocarsGame.getHighScore(), 215, 55);
	    font.draw(batch, "SCORE : " + world.getScore(), 215, 35);
        ball = world.getBall();
        box = world.getBox();
        
        //position 35/160/290/415
        randomNum();
        randomNum2();
        spawnBall (delta);
        
        for(Ball i : ball )
		{
        	if(i.getPosition().x >200) {
        		batch.draw(ball2Img, i.getPosition().x,i.getPosition().y);
        	} else {
        		batch.draw(ballImg, i.getPosition().x,i.getPosition().y);

        	}
			
		}
        
        for(Box n : box )
		{
        	if(n.getPosition().x >200) {
        		batch.draw(boxImg, n.getPosition().x,n.getPosition().y);
        	} else {
        		batch.draw(box2Img, n.getPosition().x,n.getPosition().y);

        	}
			
		}
        
		batch.draw(bluecarImg, pos_blue.x, pos_blue.y);
	    batch.draw(redcarImg, pos_red.x, pos_red.y);
        batch.end();
        
    }
    
    
    private void randomNum () {
        Random random = new Random();
        int number = random.nextInt(100);
        if(number<=50){
        	posSpawn =  35;
        }
        else {
        	posSpawn =  160;
        }
    }
    
    private void randomNum2 () {
    	   Random random2 = new Random();
           int number2 = random2.nextInt(100);
           if (number2<=50) {
           	posSpawn2 =  290;
           }
           else{
           	posSpawn2 =  420;
           }
    }
    
    private void spawnBall (float delta) {
		if(timeAux >=0.5){
			if(delta*1000 > 17){
				ball.add(new Ball(posSpawn, 800, myTwocarsGame, world));
			}else {
				box.add(new Box(posSpawn, 800, myTwocarsGame, world));
			}
            timeAux=0;
        }else{
            timeAux+=delta;
        }

		
		if(timeAux2 >=0.5){
			if(delta*10000 > 165){
				ball.add(new Ball(posSpawn2, 860, myTwocarsGame, world));
			}else {
				box.add(new Box(posSpawn2, 860, myTwocarsGame, world));
			}
            timeAux2=0;
        }else{
            timeAux2+=delta;
        }
    }
}
