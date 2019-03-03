package main.gamestuff;

import java.util.Random;

public class GameNumber
{
    private int value = 0;

    /**
     * 
     */
    public GameNumber()
    {
    }
    
    
    /**
     * @param value
     */
    public GameNumber(int value)
    {
        this.value = value;
    }

    public void setRandom(int minimum, int maximum)
    {
        Random random = new Random();
        this.value = random.nextInt(maximum - minimum) + minimum;
    }
    
    public void increment()
    {
        this.value++;
    }

    /**
     * @return the value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value)
    {
        this.value = value;
    }

    
    public static void main(String[] args)
    {
        

    }

}
