package me.austindart.brickbreaker.game.gameobjects;

import me.austindart.brickbreaker.game.Game;

public class Ball extends GameObject
{

    private int xVel;
    private int yVel;

    private final int originalXVel = 3;
    private final int originalYVel = -3;
    private final int originalXCoord = 750;
    private final int originalYCoord = 550;

    public Ball(Game game)
    {
        super(game);
        xCoord = originalXCoord;
        yCoord = originalYCoord;
        xVel = originalXVel;
        yVel = originalYVel;
        setBoundingBox(new BoundingBox(xCoord, yCoord, 15, 15));
    }

    public void reset()
    {
        xVel = originalXVel;
        yVel = originalYVel;
        xCoord = originalXCoord;
        yCoord = originalYCoord;
    }

    @Override
    public void tick()
    {
        move();
        checkCollisions();
        checkBounds();
    }

    private void checkCollisions()
    {
        Player player = game.getPlayer();
        if(player.isEnabled() && this.isEnabled())
        {
            BoundingBox playerBox = player.getBoundingBox();
            if(playerBox.overlaps(boundingBox))
            {
                yVel *= -1;
                increaseSpeed();
            }
        }

        for(Brick brick : game.getBricks())
        {
            if(brick.isEnabled() && this.isEnabled())
            {
                BoundingBox brickBox = brick.getBoundingBox();
                if(brickBox.overlaps(boundingBox))
                {
                    brick.setEnabled(false);
                    yVel *= -1;
                }
            }
        }
    }

    private void checkBounds()
    {
        if (yCoord <= 0)
        {
            yVel *= -1;
        }

        if(xCoord >= 795)
        {
            xVel *= -1;
        }
        else if (xCoord <= 0)
        {
            xVel *= -1;
        }

        if(yCoord >= 620)
        {
            game.end(false);
        }
    }

    private void increaseSpeed()
    {
        yVel -= 1;
    }

    private void move()
    {
        xCoord += xVel;
        yCoord += yVel;
        boundingBox.setLocation(xCoord, yCoord);
    }

}
