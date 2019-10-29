package com.gfi.advantures.hero;

public class North implements Move {
    @Override
    public Hero move(Hero hero) {
        return hero.up();
    }
}
