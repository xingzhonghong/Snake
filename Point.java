package com.snake;

public class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Point point=(Point)o;
        return (this.x==point.x) && (this.y==point.y);
    }
}
