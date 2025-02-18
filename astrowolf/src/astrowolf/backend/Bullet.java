/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astrowolf.backend;

import java.awt.Graphics;

/**
 *
 * @author mithu
 */
public class Bullet {
    private int x;
    private int y;
    private int targetX;
    private int targetY;
    private double m;
    private double b;
    
//    constructor, getter, setters
    
    public Bullet(int x, int y, int targetX, int targetY) {
        this.x = x;
        this.y = y;
        this.targetX = targetX;
        this.targetY = targetY;
        this.m = findSlope();
        this.b = findYInt();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public double getM() {
        return m;
    }

    public double getB() {
        return b;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }

    public void setM(double m) {
        this.m = m;
    }

    public void setB(double b) {
        this.b = b;
    }
    
//    actual mathods
    
    public double findSlope() {
        return (targetY - y) / (targetX - x);
    }
    
    public double findYInt() {
        return targetY - (m*targetX);
    }
    
    public int calcY(int x) {
        return (int)(m*x + b);
    }
    
    public void drawBullet(Graphics g) {
        g.drawLine(x, y, x + 5, calcY(x+5));
        double dx = targetX - x;
        double dy = targetY - y;
        double length = Math.sqrt(dx * dx + dy * dy);

        x = (int) (x + (dx / length) * 2);
        y = (int) (y + (dy / length) * 2);
    }
}
