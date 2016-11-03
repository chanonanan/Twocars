package com.twocars.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private MyTwocarsGame mytwocarsGame;
	
	private Bluecar bluecar;
	private Redcar redcar;
	World world;
	WorldRenderer worldRenderer;
	 
    public GameScreen(MyTwocarsGame mytwocarsGame) {
        this.mytwocarsGame = mytwocarsGame;
     
        world = new World(mytwocarsGame);
        worldRenderer = new WorldRenderer(mytwocarsGame,world);
        //position 35/160/290/415
    }
    @Override
    public void render(float delta) {
    	update(delta);
    	Gdx.gl.glClearColor(0, 0, 0, 1);
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	worldRenderer.render(delta);
    }
	private void update(float delta) {
		Bluecar bluecar = world.getBluecar();
		Redcar redcar = world.getRedcar();
		if(Gdx.input.isKeyPressed(Keys.D)) {
			redcar.move(Redcar.DIRECTION_RIGHT);
		}
		if(Gdx.input.isKeyPressed(Keys.A)) {
			redcar.move(Redcar.DIRECTION_LEFT);
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			bluecar.move(Bluecar.DIRECTION_LEFT);
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			bluecar.move(Bluecar.DIRECTION_RIGHT);
		}else{
			bluecar.move(Bluecar.DIRECTION_STILL);
			redcar.move(Redcar.DIRECTION_STILL);
   	 }
  	  	world.update(delta);
	}
}
