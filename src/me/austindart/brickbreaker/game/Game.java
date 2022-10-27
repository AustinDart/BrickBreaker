package me.austindart.brickbreaker.game;

import me.austindart.brickbreaker.game.gameobjects.Ball;
import me.austindart.brickbreaker.game.gameobjects.Brick;
import me.austindart.brickbreaker.game.gameobjects.EndScreen;
import me.austindart.brickbreaker.game.gameobjects.Player;
import me.austindart.brickbreaker.game.inputs.Keyboard;
import me.austindart.brickbreaker.gui.guiobjects.BrickBreakerPanel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Game
{

    private final Player player;
    private final Ball ball;
    private final List<Brick> bricks;
    private final EndScreen endScreen;

    private boolean running;

    public Game()
    {
        player = initPlayer();
        ball = initBall();
        bricks = initBricks();
        endScreen = initEndScreen();
        start();
    }

    public void start()
    {
        running = true;
        Runnable runnable = () ->
        {
            while(running)
            {
                tick();
                try
                {
                    BrickBreakerPanel.getInstance(this).updateUI();
                    Thread.sleep(20);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        Thread gameThread = new Thread(runnable);
        gameThread.start();
    }

    public void tick()
    {
        player.tick();
        ball.tick();
        if(shouldWin() && running)
        {
            end(true);
        }
    }

    private void startOver()
    {
        player.setEnabled(true);
        ball.setEnabled(true);
        ball.reset();
        for(Brick brick : bricks)
        {
            brick.setEnabled(true);
        }
        endScreen.setEnabled(false);
        start();
    }

    private boolean shouldWin()
    {
        for(Brick brick : bricks)
        {
            if(brick.isEnabled())
            {
                return false;
            }
        }
        return true;
    }

    public void end(boolean win)
    {
        running = false;
        if(!win)
        {
            endScreen.setText("Game Over! Press 'R' to restart.");
        }
        else
        {
            endScreen.setText("You Won! Press 'R' to restart.");
        }
        endScreen.setEnabled(true);

        for(Brick brick : bricks)
        {
            brick.setEnabled(false);
        }

        player.setEnabled(false);
        ball.setEnabled(false);
        running = false;
        Runnable runnable = () ->
        {
            while(!running)
            {
                try
                {
                    if(Keyboard.isKeyPressed(KeyEvent.VK_R))
                    {
                        startOver();
                    }
                    Thread.sleep(20);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        Thread gameOverThread = new Thread(runnable);
        gameOverThread.start();
    }

    private Player initPlayer()
    {
        return new Player(this);
    }

    private Ball initBall()
    {
        return new Ball(this);
    }

    private List<Brick> initBricks()
    {
        List<Brick> bricks = new ArrayList<>();
        for(int i = 0; i < 13; i++)
        {
            Brick brick = new Brick(this, i * 60 + 20, 50, 50, 20);
            bricks.add(brick);
        }
        return bricks;
    }

    private EndScreen initEndScreen()
    {
        EndScreen endScreen = new EndScreen(this);
        endScreen.setEnabled(false);
        return endScreen;
    }

    public Player getPlayer()
    {
        return player;
    }

    public Ball getBall()
    {
        return ball;
    }

    public List<Brick> getBricks()
    {
        return bricks;
    }

    public EndScreen getEndScreen()
    {
        return endScreen;
    }

}
