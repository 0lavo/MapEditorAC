package org.codeforall.ooptimus;

public class Game {
    private Grid grid;
    private Player player;
    private LoadAndSave loadAndSave;

    public Game(Grid grid, Player player, LoadAndSave loadAndSave) {
        this.grid = grid;
        this.player = player;
        this.loadAndSave = loadAndSave;
    }

    public void init() {
        player.fill();
    }
}
