package CoinGame;


public class BadCoin extends Coin{
 
    public BadCoin() {
        super();
        points = super.points * -5;
        color = "red";
        yspeed = 10;
        radius = 15;
    }
}

