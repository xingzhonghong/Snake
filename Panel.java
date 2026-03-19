package com.snake;
import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    SnakeGame game;
    JButton restartBtn;

    public Panel(SnakeGame game) {
        this.game = game;
        setLayout(null);
        restartBtn = new JButton("重新开始");
        restartBtn.setBounds(350, 350, 120, 40);
        restartBtn.setVisible(false);
        add(restartBtn);
        restartBtn.addActionListener(e -> {
            game.restartGame();
            restartBtn.setVisible(false);
            requestFocus();
        });
        setFocusable(true);
        requestFocus();
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                switch (e.getKeyCode()) {
                    case
        java.awt.event.KeyEvent.VK_UP:
        game.snake.changeDirection(Direction.UP);
                    break;
                    case java.awt.event.KeyEvent.VK_DOWN:
                        game.snake.changeDirection(Direction.DOWN);
                        break;
                        case java.awt.event.KeyEvent.VK_LEFT:
                            game.snake.changeDirection(Direction.LEFT);
                            break;
                            case java.awt.event.KeyEvent.VK_RIGHT:
                            game.snake.changeDirection(Direction.RIGHT);
                            break;
                }
            }
        });
        setFocusable(true);
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 墙
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 600, 400);
        g.setColor(Color.GREEN);
        for (Point p:game.snake.getBody()) {
            g.fillRect(10 + (p.x-2)*30, 10 + (p.y-2)*30, 28, 28);
        }
        g.setColor(Color.RED);
        Point food=game.map.getFood();
        g.fillRect(10 + (food.x-2)*30, 10 + (food.y-2)*30, 28, 28);
        // 游戏结束
        if (!game.isRunning) {
            long time = (System.currentTimeMillis() - game.startTime) / 1000;
            g.drawString("游戏结束！得分：" + game.score + " 时长：" + time + "s", 280, 300);
            restartBtn.setVisible(true);
        }
        repaint();
    }
}
