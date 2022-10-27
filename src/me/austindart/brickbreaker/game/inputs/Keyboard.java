package me.austindart.brickbreaker.game.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Keyboard implements KeyListener
{

    private static final HashMap<Integer, Boolean> keyMap = new HashMap<>();

    public static boolean isKeyPressed(int keyCode)
    {
        if(!keyMap.containsKey(keyCode))
        {
            return false;
        }
        return keyMap.get(keyCode);
    }


    @Override
    public void keyTyped(KeyEvent e)
    {
        // Do nothing
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keyMap.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keyMap.put(e.getKeyCode(), false);
    }
}
