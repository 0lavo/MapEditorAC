package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {
    private Rectangle player;
    private Grid grid;
    private boolean painting;


    public Player(Grid grid, LoadAndSave loadAndSave) {
        createPlayer(loadAndSave);
        this.grid = grid;
    }

            //Creates the player and starts the keyboard events \\
    public void createPlayer(LoadAndSave loadAndSave) {
        player = new Rectangle(Grid.PADDING,Grid.PADDING,20,20);
        KeyBoardEvents keyBoardEvents = new KeyBoardEvents(this,grid, loadAndSave);
        keyBoardEvents.initKeyboardEvents();
        player.setColor(Color.GREEN);
        player.fill();
    }

            //Movement of the player in the grid \\

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
        if (!grid.getIsPainted()[getIndexOfRectangle()]) {
            grid.getRectanglesArray()[getIndexOfRectangle()].fill();
            grid.setIsPainted(getIndexOfRectangle(),true);
        } else {
            grid.getRectanglesArray()[getIndexOfRectangle()].draw();
            grid.setIsPainted(getIndexOfRectangle(),false);
        }
    }

                    //Clear all the grid\\
    public void clear() {
        for (int i = 0; i < grid.getRectanglesArray().length; i ++) {
            grid.getRectanglesArray()[i].draw();
            grid.setIsPainted(i,false);
        }
    }


                    //Returns the index of the rectangle the player is in\\
    private int getIndexOfRectangle() {
        for (int i = 0; i < grid.getRectanglesArray().length; i++) {
            if (grid.getRectanglesArray()[i].getX() == player.getX() && grid.getRectanglesArray()[i].getY() == player.getY()) {
                return i;
            }
        }
        return -1;
    }

                        //Getters and setters\\
    public void setPainting(boolean painting) {
        this.painting = painting;
    }
}
