package com.gfi.advantures.hero;

public class West implements Move {
    @Override
    public Hero move(Hero hero) {
        return hero.left();
    }
}
