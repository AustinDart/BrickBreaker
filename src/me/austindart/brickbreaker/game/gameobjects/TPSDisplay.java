package me.austindart.brickbreaker.game.gameobjects;

import me.austindart.brickbreaker.game.Game;

public class TPSDisplay extends GameObject
{

    private String text = "TPS: 0";

    public TPSDisplay(Game game)
    {
        super(game);
    }

    @Override
    public void tick()
    {
        text = "TPS: " + game.getTicksPerSecond();
    }

    public String getText()
    {
        return text;
    }
}
