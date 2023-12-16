package com.yvesb04.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {

    Monster(int x, int y) {
        super(x, y);
    }

    public Position move(Arena arena) {
        Random random = new Random();
        while (true) {
            Position ret = new Position(this.getPosition().getX() + random.nextInt(3) - 1, this.getPosition().getY() + random.nextInt(3) - 1);
            if (ret.getX() > 0 && ret.getX() < arena.getWidth() - 1 && ret.getY() > 0 && ret.getY() < arena.getHeight() - 1 && !ret.equals(this.getPosition())) {
                return ret;
            }
        }
    }


    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ed8796"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX() * 2,
                getPosition().getY() * 2), "\\/");
        graphics.putString(new TerminalPosition(getPosition().getX() * 2,
                getPosition().getY() * 2 + 1), "/\\");
    }
}
