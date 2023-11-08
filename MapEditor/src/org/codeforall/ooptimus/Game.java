package org.codeforall.ooptimus;

public class Game {


            // Initiate the game \\
    public void init(int gridSquareSize) {
        Grid grid = new Grid(gridSquareSize);
        LoadAndSave loadAndSave = new LoadAndSave(grid);
        Player player = new Player(grid,loadAndSave);
    }
}
