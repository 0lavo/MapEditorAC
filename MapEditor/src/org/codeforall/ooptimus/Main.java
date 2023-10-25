package org.codeforall.ooptimus;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        LoadAndSave loadAndSave = new LoadAndSave(grid);
        Player player = new Player(grid,loadAndSave);
        Game game = new Game(grid,player,loadAndSave);
        game.init();

    }
}