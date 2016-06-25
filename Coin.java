package CoinGame;

import apcs.Window;


public class Coin {

	int radius;
	int x, y;
	String color;
	int yspeed;
	int points;
	boolean doom = false;
	
	public Coin() {
		radius = 15;
		x = Window.rollDice(Window.width());
		y = (Window.rollDice(500) + 100) * -1;
		color = "yellow";
		yspeed = 7;
		points = 1;
		
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.circle(x, y, radius);
	}
	
	public void move() {
		y += yspeed;
		
		if (y > Window.height() + 100){
			reset ();
		}
	}

	public void reset() {
		x = Window.rollDice(Window.width());
		y = (Window.rollDice(500) + 100) * -1;
		
	}
	
}
