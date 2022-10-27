package me.austindart.brickbreaker;

import me.austindart.brickbreaker.game.Game;
import me.austindart.brickbreaker.gui.BrickBreakerGUI;

public class BrickBreaker
{

    public static void main(String[] args)
    {
        Game game = new Game();
        new BrickBreakerGUI(game);
    }

}
