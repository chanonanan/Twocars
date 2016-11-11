package com.twocars.game;
import java.util.List;
import java.util.Random;

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
	private Box box;
	float timeAux = 0;
	public static int posSpawn;
	private int posSpawn2;
	private double timeAux2 = 0;
	private List<Ball> ball;

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
    	ball = world.getBall();

	}
	
    public void render(float delta) {
    	
        SpriteBatch batch = mytwocarsGame.batch;
        batch.begin();
        Vector2 pos_blue = bluecar.getPosition();
        Vector2 pos_red = redcar.getPosition();
		for(Ball i : ball )
		{
//			Vector2 pos_ball = ball.get(i).getPosition();
		}
        
        batch.draw(bgImg, 0, 0);
        batch.draw(bluecarImg, pos_blue.x, pos_blue.y);
        batch.draw(redcarImg, pos_red.x, pos_red.y);
        
        //position 35/160/290/415
        randomNum();
        randomNum2();
        spawnBall (delta);
        
        batch.end();
    }
    
    private void randomNum () {
        Random random = new Random();
        int number = random.nextInt(100);
        System.out.println(number);
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
           System.out.println("num2 " + number2);
           if (number2<=50) {
           	posSpawn2 =  290;
           }
           else{
           	posSpawn2 =  415;
           }
    }
    
    private void spawnBall (float delta) {
		if(timeAux >=0.5){
			if(delta*1000 > 17){
				batch.draw(ballImg, posSpawn, 800);
			}else {
				batch.draw(boxImg, posSpawn, 800);
			}
            timeAux=0;
        }else{
            timeAux+=delta;
        }

		
		if(timeAux2 >=0.5){
			System.out.println("Hello " + posSpawn);
			if(delta*10000 > 165){
				batch.draw(ballImg, posSpawn2, 800);
			}else {
				batch.draw(boxImg, posSpawn2, 800);
			}
            timeAux2=0;
        }else{
            timeAux2+=delta;
        }
    }
}
