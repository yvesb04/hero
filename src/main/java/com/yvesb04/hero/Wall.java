package com.yvesb04.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {

    private Position position;

    public Wall(int c, int r) {
        position = new Position(c, r);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX() * 2,
                position.getY() * 2), "\\/");
        graphics.putString(new TerminalPosition(position.getX() * 2,
                position.getY() * 2 + 1), "/\\");
    }
}
