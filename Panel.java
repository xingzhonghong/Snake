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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 墙
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 800, 600);
        Point food=game.map.getFood();
        // 食物
        g.setColor(Color.RED);
        g.fillOval(10 + food.x*20, 10 + food.y*20, 20, 20);
        Point head=game.snake.getBody().getFirst();
        // 蛇头
        g.setColor(Color.GREEN);
        g.fillRect(10 + head.x*20, 10 + head.y*20, 20, 20);
        g.setColor(Color.RED);
        // 蛇身
        for (int i=1;i<game.snake.getBody().size();i++) {
            Point bodyPoint=game.snake.getBody().get(i);
            g.fillRect(10 + bodyPoint.x*20, 10 + bodyPoint.y*20, 20, 20);
        }

        // 分数
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体", Font.PLAIN, 20));
        g.drawString("分数: " + game.score, 50, 30);

        // 游戏结束
        if (!game.isRunning) {
            long time = (System.currentTimeMillis() - game.startTime) / 1000;
            g.drawString("游戏结束！得分：" + game.score + " 时长：" + time + "s", 280, 300);
            restartBtn.setVisible(true);
        }

        repaint();
    }
}
