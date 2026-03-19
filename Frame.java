package com.snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame {

    public Frame() {
        setTitle("贪吃蛇");
        setSize(620, 440);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel=null;
        SnakeGame snakeGame=new SnakeGame(panel);
        panel=new Panel(snakeGame);
        snakeGame.game=panel;
        add(panel);
    }

    public static void main(String[] args) {
        new Frame().setVisible(true);
    }
}