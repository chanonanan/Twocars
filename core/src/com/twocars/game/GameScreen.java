package com.twocars.game;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class GameScreen extends ScreenAdapter {
	private MyTwocarsGame mytwocarsGame;
	World world;
	WorldRenderer worldRenderer;
	public boolean isBluecarMoved = false;
	public boolean isRedcarMoved = false;

	 
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
    //position 35/160/290/420
	private void update(float delta) {
		getInput();
  	  	world.update(delta);
	}
	
	private void getInput() {
		Bluecar bluecar = world.getBluecar();
		Redcar redcar = world.getRedcar();		
		if(Gdx.input.isKeyJustPressed(Keys.Z)) {
			isRedcarMoved = !isRedcarMoved;
			redcar.move2(isRedcarMoved);
		}
		if(Gdx.input.isKeyJustPressed(Keys.X)) {
			isBluecarMoved = !isBluecarMoved;
			bluecar.move2(isBluecarMoved);
		}
	}
}
