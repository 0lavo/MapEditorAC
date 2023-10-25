package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {
    private Rectangle player;
    private Grid grid;
    private boolean painting;


    public Player(Grid grid, LoadAndSave loadAndSave) {
        player = new Rectangle(Grid.PADDLE,Grid.PADDLE,20,20);
        KeyBoardEvents keyBoardEvents = new KeyBoardEvents(this,grid, loadAndSave);
        this.grid = grid;
        keyBoardEvents.initKeyboardEvents();
    }

    public void fill() {
        player.setColor(Color.GREEN);
        player.fill();
    }
    public void moveUp() {
        if (player.getY() != grid.getOutGridY()) {
            player.translate(0, -20);
        }
        if (painting) {
            paint();
        }
    }
    public void moveDown() {
        if (player.getY() != grid.getOutGridMaxY() - 20) {
            player.translate(0, 20);
        }
        if (painting) {
            paint();
        }
    }
    public void moveLeft() {
        if (player.getX() != grid.getOutGridX()) {
            player.translate(-20, 0);
        }
        if (painting) {
            paint();
        }
    }
    public void moveRight() {
        if (player.getX() != grid.getOutGridMaxX() - 20) {
            player.translate(20, 0);
        }
        if (painting) {
            paint();
        }
    }


    public void paint() {
        int index = getIndexOfRectangle();
        if (!grid.getIsPainted()[index]) {
            grid.getRectanglesArray()[index].fill();
            grid.setIsPainted(index,true);
        } else {
            grid.getRectanglesArray()[index].draw();
            grid.setIsPainted(index,false);
        }
    }
    public void clear() {
        for (int i = 0; i < grid.getRectanglesArray().length; i ++) {
            grid.getRectanglesArray()[i].draw();
            grid.setIsPainted(i,false);
        }
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }


    private int getIndexOfRectangle() {
        for (int i = 0; i < grid.getRectanglesArray().length; i++) {
            if (grid.getRectanglesArray()[i].getX() == player.getX() && grid.getRectanglesArray()[i].getY() == player.getY()) {
                return i;
            }
        }
        return -1;
    }
}
