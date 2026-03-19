package com.snake;
import java.util.List;
import java.util.ArrayList;
public class SnakeBody {
    private List<Point> body;
    private Direction currentDir;
    private int moveInterval;
    public SnakeBody()
    {
        body=new ArrayList<>();
        body.add(new Point(15,10));
        body.add(new Point(15,9));
        body.add(new Point(15,8));
        currentDir=Direction.RIGHT;
        moveInterval=425;
    }
    public List<Point> getBody() {
        return body;
    }
    public Direction getCurrentDir() {
        return currentDir;
    }
    public int getMoveInterval() {
        return moveInterval;
    }
    public void changeDirection(Direction newDir)
    {
        if(currentDir==Direction.RIGHT&&newDir==Direction.LEFT)
        {
            return;
        }
        if(currentDir==Direction.LEFT&&newDir==Direction.RIGHT)
        {
            return;
        }
        if(currentDir==Direction.UP&&newDir==Direction.DOWN)
        {
            return;
        }
        if(currentDir==Direction.DOWN&&newDir==Direction.UP)
        {
            return;
        }
        currentDir=newDir;
    }
    public void move()
    {
        Point head=body.get(0);
        int newX=head.x;
        int newY=head.y;
        switch(currentDir)
        {
            case UP:
                newY--;
                break;
                case DOWN:
                    newY++;
                    break;
                    case LEFT:
                        newX--;
                        break;
                        case RIGHT:
                            newX++;
                            break;
        }
        Point newHead=new Point(newX,newY);
        body.add(0,newHead);
            body.remove(body.size() - 1);
    }
    public void move(boolean isEatFood)
    {
        Point head=body.get(0);
        int newX=head.x;
        int newY=head.y;
        switch(currentDir)
        {
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
        }
        Point newHead=new Point(newX,newY);
        body.add(0,newHead);
        if(!isEatFood) {
            body.remove(body.size() - 1);
        }
    }
    public void increaseSpeed()
    {
        moveInterval=Math.max(100,moveInterval-10);
    }
}
