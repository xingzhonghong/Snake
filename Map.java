package com.snake;
import java.util.Random;

public class Map {
     private Point food;
     private SnakeBody snake;
     public Map(SnakeBody snake)
     {
         this.snake=snake;
         generateFood();
     }
     public void generateFood()
     {
         boolean isOnSnake=false;
         int retryCount=0;
         boolean valid=false;
         int x=0,y=0;
         do
         {
             x=(int)(Math.random()*20)+1;
             y=(int)(Math.random()*13)+1;
             isOnSnake=false;
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
                 food=new Point(x,y);
             }
             else{
                 retryCount++;
             }
         }while(!valid&&retryCount<100);
         if(!valid)
         {
             //throw new GameEndException("恭喜通关，地图已无空位");
             food=new Point(x,y);
         }
     }
     public Point getFood()
     {
     return new Point(food.x,food.y);
     }
}
