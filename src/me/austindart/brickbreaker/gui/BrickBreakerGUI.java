package me.austindart.brickbreaker.gui;

import me.austindart.brickbreaker.game.Game;
import me.austindart.brickbreaker.game.inputs.Keyboard;
import me.austindart.brickbreaker.gui.guiobjects.BrickBreakerPanel;

import javax.swing.*;
import java.awt.*;

/**
 * BrickBreakerGUI is the JFrame that displays the BrickBreaker game
 * @author Austin Dart
 */
public class BrickBreakerGUI extends JFrame
{

    protected BrickBreakerPanel jPanel;

    public BrickBreakerGUI(Game game)
    {
        jPanel = BrickBreakerPanel.getInstance(game);
        jPanel.setBorder(BorderFactory.createEmptyBorder(300, 400, 300, 400));

        add(jPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(new Keyboard());
        pack();
        setVisible(true);
    }

}