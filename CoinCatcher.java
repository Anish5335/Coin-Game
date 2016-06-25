package CoinGame;



import java.util.ArrayList;

import apcs.Window;

public class CoinCatcher {

	public static void main(String[] args) {

		Coin coins[] = new Coin[30];
		ArrayList<Powerup> powerups = new ArrayList<Powerup>();
		Catcher c = new Catcher();
		int score = 0;
		int lives = 3;

		// create a new coin object at every index in the array
		for (int i = 0; i < coins.length; i++) {
			if (i < 15) {
				coins[i] = new Coin();
			}
			else if (i < 25){
				coins[i] = new BadCoin();
			}
			else if (i < 27){
				coins[i] = new RareCoin();
			}
			else {  
				coins[i] = new DoomCoin();
			}
		}

		//int r = Window.rollDice(255);
		//int g = Window.rollDice(255);
		//int b = Window.rollDice(255);

		while (true) {

			Window.out.background("black");
			
			if (c.powerup == 2 && c.timer <= 0) {
				for (int i = 0; i < coins.length; i++) {
					if (i < 15) {
						coins[i] = new Coin();
					}
					else if (i < 25){
						coins[i] = new BadCoin();
					}
					else if (i < 27){
						coins[i] = new RareCoin();
					}
					else {
						coins[i] = new DoomCoin();
					}
				}

			}

			// draw and move the catcher
			c.draw();
			c.move();
			
			// randomly add powerups to the game
			if (Window.rollDice(100) == 1) {
				powerups.add(new Powerup(Window.rollDice(2)));
			}
		
			
			// draw and move powerups
			for (int i = 0; i < powerups.size(); i++) {
				powerups.get(i).draw();
				powerups.get(i).move();
				
				// apply powerup affect on catcher and remove the powerup from the game
				if (c.isTouching(powerups.get(i))) {
					c.powerupOn(powerups.get(i).powerup);
					powerups.remove(i);
					if (c.powerup == 2) {
						for (int j = 0; j < coins.length; j++) {
							coins[j] = new RareCoin();
						}
					}
				}
			}

			// tell every coin to draw and move itself
			for (int i = 0; i < coins.length; i++) {
				coins[i].draw();
				coins[i].move();

				// reset the coin and add to the score
				if (c.isTouching(coins[i])) {
					score += coins[i].points;
					coins[i].reset();
					if (coins[i].doom) {
						lives--;
						
					}
				}
			}
			
			// force score to never be below zero
			if (score < 0) {
				score = 0;
			}
			
			//game over state
			if (lives < 0) {
				Window.out.color("lime green");
				Window.out.fontSize(40);
				Window.out.print("GAME OVER", 100, 200);
				Window.frame(2000);
				lives = 3;
				score = 0;
				c.powerup = 0;
				for (int i = 0; i < coins.length; i++) {
					coins[i].reset();
				}
			}

			// print out the score
			Window.out.color("white");
			Window.out.font("papyrus", 30);
			Window.out.print("Score: " + score, 20, 30);
			
			Window.out.print("Lives: " + lives, 20, 60);


			//r = Window.rollDice(255);
			//g = Window.rollDice(255);
			//b = Window.rollDice(255);
			
			Window.frame();
		}
	}

}
