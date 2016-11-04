package com.twocars.game;

public class World {
	private Bluecar bluecar;
	private Redcar redcar;
	private MyTwocarsGame mytwocarGame;

	
	World(MyTwocarsGame mytwocarGame) {
		this.mytwocarGame = mytwocarGame;
		
		bluecar = new Bluecar(415,75);
	    redcar = new Redcar(35,75);

	}

	Bluecar getBluecar() {
		return bluecar;
	}
	
	Redcar getRedcar() {
		return redcar;
	}
	

	 
    public void update(float delta) {
        redcar.update();
        bluecar.update();
    }
}
