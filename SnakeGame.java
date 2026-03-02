package com.snake;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SnakeGame implements ActionListener {
   SnakeBody snake;
   Map map;
   SnakeGame snakeGame;
   int score;
   int speed;
   boolean isRunning;
   long startTime;
   private javax.swing.Timer timer;
   public SnakeGame() {
       initGame();
   }
   public void initGame() {
       snake=new SnakeBody();
       map=new Map(snake);
       score=0;
       speed=200;
       isRunning=true;
       startTime = System.currentTimeMillis();
       timer=new javax.swing.Timer(speed,this);
       timer.start();
   }
   public void actionPerformed(ActionEvent e) {
       if (!isRunning) {
           timer.stop();
           return;
       }
       checkEatFood();
       checkCollision();
   }
       private void checkEatFood(){
           Point head=snake.getBody().get(0);
           if(head.equals(map.getFood())){
               snake.move(true);
               if(speed>100){
                   speed-=10;
                   timer.setDelay(speed);
               }else{
                   snake.move(false);
               }
           }
       }
       private void checkCollision() {
           Point head = snake.getBody().get(0);
           if (head.x < 1 || head.x >= 20 || head.y < 1 || head.y >= 30) {
               isRunning = false;
           }
           for (int i = 1; i < snake.getBody().size(); i++) {
               Point bodyPoint = snake.getBody().get(i);
               if (head.equals(bodyPoint)) {
                   isRunning = false;
                   break;
               }
           }
       }
       public void restartGame(){
           initGame();
       }

}
