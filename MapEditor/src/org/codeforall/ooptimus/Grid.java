package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.util.Arrays;

public class Grid {
    public static final int PADDING = 10;
    private int numOfGridRectangleCreated = 0;
    private Rectangle outGrid;  //Bigger rectangle of the grid \\
    private Rectangle[] rectanglesArray; //Array that store the gridRectangles \\
    private Boolean[] isPainted; // Array that indicate if the rectangle of the grid is painted or not. The index of the rectangle stored in the rectangleArray is the same in this array  \\
    private int outSideGridColsAndRows;
    private final int gridRectangleColsAndRows = 20; // Cells size \\

    public Grid(int outSideGridColsAndRows) {
        variableCheck(outSideGridColsAndRows);
        drawHoleGrid();
    }

                            // Defense system to always make a correct grids \\

    public void variableCheck(int outSideGridColsAndRows) {

        while (true) {

            if (((outSideGridColsAndRows * outSideGridColsAndRows) % (gridRectangleColsAndRows * gridRectangleColsAndRows)) == 0) {
                break;
            }
            outSideGridColsAndRows++;
        }

        this.outSideGridColsAndRows = outSideGridColsAndRows;
    }


    public void drawHoleGrid() {

        Rectangle gridRectangle; // Smaller rectangles that fill the grid \\

        outGrid = new Rectangle(PADDING, PADDING, outSideGridColsAndRows,outSideGridColsAndRows);
        outGrid.draw();

        rectanglesArray = new Rectangle[(outSideGridColsAndRows * outSideGridColsAndRows) / (gridRectangleColsAndRows * gridRectangleColsAndRows)];

        for (int i = PADDING; i != outGrid.getHeight() + PADDING; i += gridRectangleColsAndRows) {

            for (int j = PADDING; j != outGrid.getWidth() + PADDING; j += gridRectangleColsAndRows) {

                gridRectangle = new Rectangle(j,i,gridRectangleColsAndRows,gridRectangleColsAndRows);
                gridRectangle.draw();
                rectanglesArray[numOfGridRectangleCreated] = gridRectangle;
                numOfGridRectangleCreated++;
            }
        }

        isPainted = new Boolean[numOfGridRectangleCreated];
        Arrays.fill(isPainted,false);

    }


                    // Getters and setters \\

    public int getOutGridX() {return outGrid.getX();}
    public int getOutGridMaxX(){return outGrid.getX() + outGrid.getWidth();}
    public int getOutGridY() {return outGrid.getY();}
    public int getOutGridMaxY() {return outGrid.getY() + outGrid.getHeight();}

    public Rectangle[] getRectanglesArray() {return rectanglesArray;}

    public Boolean[] getIsPainted() {return isPainted;}

    public void setIsPainted(int index,Boolean isPainted) {this.isPainted[index] = isPainted;}
}
