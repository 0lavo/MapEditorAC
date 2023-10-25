package org.codeforall.ooptimus;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.Arrays;

public class Grid {
    public static final int PADDLE = 10;
    private Rectangle outGrid;
    private Rectangle gridRectangle;
    private Rectangle[] rectanglesArray;
    private Boolean[] isPainted;

    public Grid() {
        drawHoleGrid();
    }

    public void drawHoleGrid() {
        outGrid = new Rectangle(PADDLE,PADDLE,500,500);
        outGrid.draw();
        rectanglesArray = new Rectangle[625];
        int index = 0;

        for (int i = PADDLE; i != outGrid.getHeight() + 10; i += 20) {
            for (int j = PADDLE; j != outGrid.getWidth() + 10; j += 20) {
                gridRectangle = new Rectangle(j,i,20,20);
                gridRectangle.draw();
                rectanglesArray[index] = gridRectangle;
                index++;
            }
        }

        isPainted = new Boolean[index];
        Arrays.fill(isPainted,false);

    }

    public int getOutGridX() {
        return outGrid.getX();
    }
    public int getOutGridMaxX(){return outGrid.getX() + outGrid.getWidth();}
    public int getOutGridY() {
        return outGrid.getY();
    }
    public int getOutGridMaxY() {
        return outGrid.getY() + outGrid.getHeight();
    }

    public Rectangle[] getRectanglesArray() {
        return rectanglesArray;
    }

    public Boolean[] getIsPainted() {
        return isPainted;
    }

    public void setIsPainted(int index,Boolean isPainted) {
        this.isPainted[index] = isPainted;
    }
}

