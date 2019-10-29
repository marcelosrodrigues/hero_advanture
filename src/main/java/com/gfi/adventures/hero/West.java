package com.gfi.adventures.hero;

public class West implements Move {
    @Override
    public Hero move(Hero hero) {
        return hero.left();
    }
}
