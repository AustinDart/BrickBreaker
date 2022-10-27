package me.austindart.brickbreaker.game.gameobjects;

import me.austindart.brickbreaker.game.Game;

public class EndScreen extends GameObject
{

    private String text = "Game over. Press 'r' to play again.";

    public EndScreen(Game game)
    {
        super(game);
    }

    @Override
    public void tick()
    {

    }

    public String getText()
    {
        return text;
    }
}
