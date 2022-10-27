package me.austindart.brickbreaker.game.gameobjects;

import me.austindart.brickbreaker.game.Game;

public class Brick extends GameObject
{

    private int xCoord;
    private int yCoord;

    public Brick(Game game, int x, int y, int width, int height)
    {
        super(game);
        xCoord = x;
        yCoord = y;
        setBoundingBox(new BoundingBox(x, y, width, height));
    }

    public int getX()
    {
        return xCoord;
    }

    public int getY()
    {
        return yCoord;
    }

    @Override
    public void tick()
    {
        // Brick doesn't really do anything on tick. Ball will handle hitting Bricks.
    }
}
