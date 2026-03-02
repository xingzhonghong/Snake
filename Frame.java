package com.snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {
    Panel panel;
    SnakeGame game;

    public Frame() {
        game = new SnakeGame();
        panel = new Panel(game);

        setTitle("贪吃蛇");
        setSize(816, 639);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!game.isRunning) return;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> game.snake.changeDirection(Direction.UP);
            case KeyEvent.VK_DOWN -> game.snake.changeDirection(Direction.DOWN);
            case KeyEvent.VK_LEFT -> game.snake.changeDirection(Direction.LEFT);
            case KeyEvent.VK_RIGHT -> game.snake.changeDirection(Direction.RIGHT);
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new Frame();
    }
}
