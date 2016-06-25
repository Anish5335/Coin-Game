package CoinGame;

	
	import apcs.Window;

	public class RareCoin extends Coin{
	   
	    int xspeed = Window.rollDice(21) - 11;
	    int timer = Window.rollDice(50);
	   
	    public RareCoin() {
	        super();
	        points = super.points * 10;
	        radius = super.radius / 2;
	        yspeed = super.yspeed * 3;
	    }
	   
	    public void draw() {
	        Window.out.randomColor();
	        Window.out.circle(x, y, radius);
	    }
	   
	    public void move() {
	        super.move();
	       
	        if (timer > 0) {
	            x += xspeed;
	        }
	        else {
	            timer = Window.rollDice(50);
	            xspeed = Window.rollDice(21) - 11;
	        }
	       
	        timer--;
	    }
	}




