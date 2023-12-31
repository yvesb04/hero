package com.yvesb04.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {

    public Wall(int c, int r) {
        super(c, r);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#939ab7"));
        graphics.putString(new TerminalPosition(getPosition().getX() * 2,
                getPosition().getY() * 2), "\\/");
        graphics.putString(new TerminalPosition(getPosition().getX() * 2,
                getPosition().getY() * 2 + 1), "/\\");
    }
}
