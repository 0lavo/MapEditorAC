package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyBoardEvents implements KeyboardHandler {

    private Player player;
    private Grid grid;
    private LoadAndSave loadAndSave;

    public KeyBoardEvents(Player player, Grid grid, LoadAndSave loadAndSave) {
        this.player = player;
        this.grid = grid;
        this.loadAndSave = loadAndSave;
    }

    public void initKeyboardEvents() {

        Keyboard kb = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        kb.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        kb.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        kb.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        kb.addEventListener(down);

        KeyboardEvent spacep = new KeyboardEvent();
        spacep.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacep.setKey(KeyboardEvent.KEY_SPACE);

        kb.addEventListener(spacep);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_C);

        kb.addEventListener(clear);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);

        kb.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);

        kb.addEventListener(load);

        KeyboardEvent spaceR = new KeyboardEvent();
        spaceR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        spaceR.setKey(KeyboardEvent.KEY_SPACE);

        kb.addEventListener(spaceR);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP -> player.moveUp();
            case KeyboardEvent.KEY_DOWN -> player.moveDown();
            case KeyboardEvent.KEY_LEFT -> player.moveLeft();
            case KeyboardEvent.KEY_RIGHT -> player.moveRight();
            case KeyboardEvent.KEY_SPACE -> {
                player.paint();
                player.setPainting(true);
            }
            case KeyboardEvent.KEY_C -> player.clear();
            case KeyboardEvent.KEY_S -> loadAndSave.save();
            case KeyboardEvent.KEY_L -> loadAndSave.load();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            player.setPainting(false);
        }
    }
}
