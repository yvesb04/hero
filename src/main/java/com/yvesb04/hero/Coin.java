package com.yvesb04.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {

    Coin(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#eed49f"));
        graphics.putString(new TerminalPosition(getPosition().getX() * 2,
                getPosition().getY() * 2), "/\\");
        graphics.putString(new TerminalPosition(getPosition().getX() * 2,
                getPosition().getY() * 2 + 1), "\\/");
    }
}
