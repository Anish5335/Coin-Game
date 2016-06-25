package CoinGame;


import apcs.Window;

public class Catcher {

	int x, y;
	String color;
	int width, height;
	int xspeed;
	int powerup;
	int timer;
	
	public Catcher() {
		x = Window.width() / 2;
		y = Window.height() - 100;
		width = 50;
		height = 20;
		xspeed = 7;
		color = "green";
		powerup = 0;
		timer = 0;
	}
	
	public void powerupOn(int powerup) {
		this.powerup = powerup;
		timer = 100;
	}
	
	public void powerupStuff() {
		if (powerup == 1) {
			width = 100;
			height = 40;
		}
		
		else if (powerup == 0) {
			width = 50;
			height = 20;
		}
		
		
		if (timer <= 0) {
			powerup = 0;
			timer = 0;
		}
		
		timer--;
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.rectangle(x, y, width, height);
	}
	
	public void move() {
		if (Window.key.pressed("left")) {
			x -= xspeed;
		}
		else if (Window.key.pressed("right")) {
			x += xspeed;
		}
		
		// check collision with left side of screen
		if (x < width / 2) {
			x = width / 2;
		}
		
		// check collision with right side of screen
		if (x > Window.width() - width / 2) {
			x = Window.width() - width / 2;
		}
		
		powerupStuff();
	}
	
	public boolean isTouching(Coin c) {
		
		if (Math.abs(x - c.x) < width / 2 + c.radius &&
				Math.abs(y - c.y) < height / 2 + c.radius) {
			return true;
		}
		
		return false;
	}
	
	public boolean isTouching(Powerup p) {
		if (Math.abs(x - p.x) < width / 2 + p.side / 2 &&
				Math.abs(y - p.y) < height / 2 + p.side / 2) {
			return true;
		}
		
		return false;
	}
}
