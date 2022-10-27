package me.austindart.brickbreaker.game.gameobjects;

import me.austindart.brickbreaker.game.Game;

public abstract class GameObject
{

    protected BoundingBox boundingBox;
    protected int xCoord;
    protected int yCoord;
    protected Game game;

    protected boolean enabled;

    public GameObject(Game game)
    {
        this.game = game;
        xCoord = 0;
        yCoord = 0;
        enabled = true;
    }

    public abstract void tick();

    public int getX()
    {
        return xCoord;
    }

    public int getY()
    {
        return yCoord;
    }

    public void setBoundingBox(BoundingBox boundingBox)
    {
        this.boundingBox = boundingBox;
    }

    public BoundingBox getBoundingBox()
    {
        return boundingBox;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public int getMiddleX()
    {
        int radius = boundingBox.getWidth() / 2;
        return xCoord + radius;
    }

}
