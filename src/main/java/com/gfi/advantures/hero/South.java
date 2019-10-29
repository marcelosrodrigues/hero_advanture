package com.gfi.advantures.hero;

public class South implements Move {
    @Override
    public Hero move(Hero hero) {
        return hero.down();
    }
}
