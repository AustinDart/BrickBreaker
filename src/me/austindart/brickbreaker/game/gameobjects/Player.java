package me.austindart.brickbreaker.game.gameobjects;

import me.austindart.brickbreaker.game.Game;
import me.austindart.brickbreaker.game.inputs.Keyboard;

import java.awt.event.KeyEvent;

public class Player extends GameObject
{

    private final int xVel = 5;

    boolean cheatMode = false;

    public Player(Game game)
    {
        super(game);
        xCoord = 0;
        yCoord = 580;
        setBoundingBox(new BoundingBox(xCoord, yCoord, 80, 20));
    }

    @Override
    public void tick()
    {
        if(Keyboard.isKeyPressed(KeyEvent.VK_LEFT))
        {
            moveLeft();
        }
        else if(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT))
        {
            moveRight();
        }

        if(Keyboard.isKeyPressed(KeyEvent.VK_C))
        {
            cheatMode = true;
        }
        else
        {
            cheatMode = false;
        }

        if(cheatMode)
        {
            Ball ball = game.getBall();

            if(Math.abs(ball.getMiddleX() - getMiddleX()) > 10)
            {
                if(ball.getMiddleX() > getMiddleX())
                {
                    moveRight();
                }
                else
                {
                    moveLeft();
                }
            }
        }

        boundingBox.setLocation(xCoord, yCoord);
    }

    public void moveLeft()
    {
        if(xCoord > 0)
        {
            xCoord -= xVel;
        }
    }

    public void moveRight()
    {
        if(xCoord < 725)
        {
            xCoord += xVel;
        }
    }

}
