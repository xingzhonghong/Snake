package com.snake;

public class GameEndException extends RuntimeException
{
    public GameEndException(String message)
    {
        super(message);
    }
}
