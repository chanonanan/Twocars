package com.twocars.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private MyTwocarsGame mytwocarsGame;
	private Texture bluecarImg;
	private Texture redcarImg;
	private Texture bgImg;
	private int x;
	private int y;
	 
    public GameScreen(MyTwocarsGame mytwocarsGame) {
        this.mytwocarsGame = mytwocarsGame;
        bluecarImg = new Texture("bluecar.png");
        redcarImg = new Texture("redcar.png");
        bgImg = new Texture("bg.jpg");
        x = 100;
        y = 100;
    }
    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	update(delta);
        SpriteBatch batch = mytwocarsGame.batch;
        batch.begin();
        batch.draw(bluecarImg, x, y);
        batch.end();
    }
	private void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			x -= 10;
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x += 10;
		}
	}
}
