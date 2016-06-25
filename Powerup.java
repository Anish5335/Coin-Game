package CoinGame;

import apcs.Window;


public class Powerup {
	
	int x, y;
    int side;
    int yspeed;
    String color;
    int powerup;
   
    public Powerup(int p) {
        x = Window.rollDice(Window.width());
        y = (Window.rollDice(100) + 100) * -1;
        yspeed = 10;
        color = "purple";
        powerup = p;
        side = 10;
    }
   
    public void draw() {
        Window.out.color(color);
        Window.out.square(x, y, side);
    }
   
    public void move() {
        y += yspeed;
       
        // reset the coin position once it goes out the bottom of the screen
        if (y > Window.height() + 100) {
            reset();
        }
    }
 
    public void reset() {
        x = Window.rollDice(Window.width());
        y = (Window.rollDice(500) + 100) * -1;
    }


}
