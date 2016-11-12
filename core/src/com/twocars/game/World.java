package com.twocars.game;

import java.util.ArrayList;
import java.util.List;





public class World {
	private Bluecar bluecar;
	private Redcar redcar;
	private List<Ball> ball;
	private List<Box> box;
	private MyTwocarsGame mytwocarGame;
	private int highScore = 0;
	private int score = 0;
	
	World(MyTwocarsGame mytwocarGame) {
		this.mytwocarGame = mytwocarGame;
		bluecar = new Bluecar(415,75);
	    redcar = new Redcar(35,75);
	    ball = new ArrayList<Ball>();
	    box = new ArrayList<Box>();
	}

	Bluecar getBluecar() {
		return bluecar;
	}
	
	Redcar getRedcar() {
		return redcar;
	}
	
	public List<Ball> getBall() {
		return ball;
	}
	
	public List<Box> getBox() {
		return box;
	}
	
    public void update(float delta) {
        redcar.update();
        bluecar.update();
        updateBall();
        updateBox();
    }
    
    private void updateBox() {
		for(int i=0;i<box.size();i++)
		{
			box.get(i).update();
//			if(ball.get(i).hitBoss())
//			{
//				boss.hitByBullet();
//				bullet.remove(i);
//				continue;
//			}
			if(box.get(i).hitEdge())
			{
				box.remove(i);
				System.out.println("remove");
			}

		}
		
	}

	private void updateBall() {
		for(int i=0;i<ball.size();i++) {
			ball.get(i).update();
			if(ball.get(i).hitBlueCar()) {
				bluecar.hitByBall();
				ball.remove(i);
				score++;
				continue;
			}
			if(ball.get(i).hitRedCar()) {
				redcar.hitByBall();
				ball.remove(i);
		        System.out.println("hit");
		        score++;
				continue;
			}
			if(ball.get(i).hitEdge()) {
				mytwocarGame.dispose();
				mytwocarGame.create();
		        System.out.println("End");
				//game over here
			}

		}
	}

	public int getHighScore() {
		if(score >= highScore) highScore = score;
		return highScore;
	}
	

	public int getScore() {
		return score;
	}
}
