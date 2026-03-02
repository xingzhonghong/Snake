package com.snake;
import java.util.Random;

public class Map {
     private static final int ROWS=20;
     private static final int COLS=30;
     private Point food;
     private SnakeBody snake;
     private Random random;
     public Map(SnakeBody snake)
     {
         this.snake=snake;
         this.random=new Random();
         generateFood();
     }
     public void generateFood()
     {
         int retryCount=0;
         boolean valid=false;
         int x=0;
         int y=0;
         while(retryCount<5&&!valid)
         {
             x=random.nextInt(ROWS)+1;
             y=random.nextInt(COLS)+1;
             boolean isOnSnake=false;
             for(Point p:snake.getBody())
             {
                 if(p.x==x&&p.y==y)
                 {
                     isOnSnake=true;
                     break;
                 }
             }
             if(!isOnSnake)
             {
                 valid=true;
             }
             else{
                 retryCount++;
             }
         }
         if(valid)
         {
             food=new Point(x, y);
         }
         else
         {
             throw new GameEndException("恭喜通关，地图已无空位");
         }
     }
     public Point getFood()
     {
         return new Point(food.x, food.y);
     }

}
