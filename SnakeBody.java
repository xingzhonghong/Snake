package com.snake;
import java.util.List;
import java.util.ArrayList;
public class SnakeBody {
    private List<Point> body;
    private Direction currentDir;
    private int moveInterval;
    public Snake()
    {
        body=new ArrayList<>();
        body.add(new Point(10,16));
        body.add(new Point(10,15));
        body.add(new Point(10,14));
        currentDir=Direction.RIGHT;
        moveInterval=200;
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
                newX++;
                break;
                case DOWN:
                    newX--;
                    break;
                    case LEFT:
                        newY--;
                        break;
                        case RIGHT:
                            newY++;
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
                newX++;
                break;
            case DOWN:
                newX--;
                break;
            case LEFT:
                newY--;
                break;
            case RIGHT:
                newY++;
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
