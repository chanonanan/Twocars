package com.twocars.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;


public class World {
	private Bluecar bluecar;
	private Redcar redcar;
	private List<Ball> ball;
	private MyTwocarsGame mytwocarGame;
	
	World(MyTwocarsGame mytwocarGame) {
		this.mytwocarGame = mytwocarGame;
		bluecar = new Bluecar(415,75);
	    redcar = new Redcar(35,75);
	    ball = new ArrayList<Ball>();
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
	
    public void update(float delta) {
        redcar.update();
        bluecar.update();
        updateBall();
    }
    
    private void updateBall()
	{
		for(int i=0;i<ball.size();i++)
		{
			ball.get(i).update();
//			if(ball.get(i).hitBoss())
//			{
//				boss.hitByBullet();
//				bullet.remove(i);
//				continue;
//			}
			if(ball.get(i).hitEdge())
			{
				ball.remove(i);
			}
		}
	}
}
