package org.codeforall.ooptimus;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        LoadAndSave loadAndSave = new LoadAndSave(grid);
        Player player = new Player(grid,loadAndSave);
        Game game = new Game(grid,player,loadAndSave);
        game.init();

    }

    // blablablalbalbalbalba
    //skdfmdsfsdofiosdjfiods

    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

}