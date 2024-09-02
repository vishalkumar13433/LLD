package org.example.models;

import org.example.game.Box;

public class Players {
    int id;
    String name;

    Box currentBox;


    public Players(int id, String name) {
        this.id = id;
        this.name = name;
        this.currentBox = null;
    }

    public void setPlayerBox(Box box) {
        this.currentBox = box;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Box getCurrentBox() {
        return currentBox;
    }

    public void setCurrentBox(Box currentBox) {
        this.currentBox = currentBox;
    }
}
