package me.austindart.brickbreaker.gui.guiobjects;

import me.austindart.brickbreaker.game.Game;
import me.austindart.brickbreaker.game.gameobjects.Brick;

import javax.swing.*;
import java.awt.*;

/**
 * BrickBreakerPanel is the JPanel that actually does most of the Graphics work for the BrickBreaker Game
 */
public class BrickBreakerPanel extends JPanel
{

    private final Game game;
    private static BrickBreakerPanel instance;

    public static BrickBreakerPanel getInstance(Game game)
    {
        if (instance == null)
        {
            instance = new BrickBreakerPanel(game);
        }
        return instance;
    }

    public BrickBreakerPanel(Game game)
    {
        super();
        setBackground(Color.black);
        this.game = game;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        if (game.getPlayer().isEnabled())
        {
            g.setColor(Color.white);
            g.fillRect(game.getPlayer().getX(), game.getPlayer().getY(),
                    game.getPlayer().getBoundingBox().getWidth(), game.getPlayer().getBoundingBox().getHeight());
        }

        if(game.getBall().isEnabled())
        {
            g.setColor(Color.red);
            g.fillRect(game.getBall().getX(), game.getBall().getY(),
                    game.getBall().getBoundingBox().getWidth(), game.getBall().getBoundingBox().getHeight());
        }

        for(Brick brick : game.getBricks())
        {
            if(brick.isEnabled())
            {
                g.setColor(Color.yellow);
                g.fillRect(brick.getX(), brick.getY(), brick.getBoundingBox().getWidth(), brick.getBoundingBox().getHeight());
            }
        }

        if(game.getEndScreen().isEnabled())
        {
            g.setColor(Color.white);
            g.drawChars(game.getEndScreen().getText().toCharArray(), 0,
                    game.getEndScreen().getText().length(), 400 - (2 * game.getEndScreen().getText().length()), 300);
        }

        if(game.getTPSDisplay().isEnabled())
        {
            g.setColor(Color.green);
            g.drawChars(game.getTPSDisplay().getText().toCharArray(), 0, game.getTPSDisplay().getText().length()
                    , 0, 20);
        }
    }

}
