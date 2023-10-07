package com.yvesb04.hero;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private final TerminalScreen screen;
    Hero hero;

    Game() throws IOException {
        hero = new Hero(10, 10);

        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen();           // screens must be started
        screen.doResizeIfNecessary();   // resize screen if necessary
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    private void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp:
               hero.moveUp();
               break;
            case ArrowDown:
                hero.moveDown();
                break;
            case ArrowLeft:
                hero.moveLeft();
                break;
            case ArrowRight:
                hero.moveRight();
                break;
            case Character:
                if (key.getCharacter() == 'q') {
                    screen.close();
                }
            case EOF:
                screen.close();
        }

    }

    void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.EOF) {
                break;
            }
        }
    }
}