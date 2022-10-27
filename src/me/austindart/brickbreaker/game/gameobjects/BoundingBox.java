package me.austindart.brickbreaker.game.gameobjects;

public class BoundingBox
{

    private int xCoord;
    private int yCoord;

    private final int width;
    private final int height;

    public BoundingBox(int x, int y, int width, int height)
    {
        this.xCoord = x;
        this.yCoord = y;
        this.width = width;
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setLocation(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    public boolean overlaps(BoundingBox other)
    {
        int leftX = xCoord;
        int rightX = xCoord + width;
        int bottomY = yCoord;
        int topY = yCoord - height;

        int oLeftX = other.xCoord;
        int oRightX = other.xCoord + other.width;
        int oBottomY = other.yCoord;
        int oTopY = other.yCoord - other.height;

        if(topY > oBottomY || bottomY < oTopY)
        {
            return false;
        }
        // could be simplified but would likely impair readability
        else if (rightX < oLeftX || leftX > oRightX)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean isInside(int x, int y)
    {
        int leftX = xCoord;
        int rightX = xCoord + width;
        int bottomY = yCoord;
        int topY = yCoord - height;

        if ((x >= leftX && x <= rightX) && (y >= topY && y <= bottomY))
        {
            return true;
        }
        return false;
    }

}
