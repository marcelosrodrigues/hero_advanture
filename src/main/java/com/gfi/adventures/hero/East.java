package com.gfi.adventures.hero;

public class East implements Move {
    @Override
    public Hero move(Hero hero) {
        return hero.right();
    }
}
