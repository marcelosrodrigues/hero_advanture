package com.gfi.adventures.hero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HeroApplication {
    public static void main(String... args) throws Exception {

        if (args.length == 0) throw new RuntimeException("The map is required");

        String map = args[0];
        String movimentFile = args[1];

        AdventureMap advantureMap = new AdventureMap(new File(map));
        Hero hero = advantureMap.createHero();
        StringBuffer moviment = new StringBuffer();
        try( BufferedReader reader = new BufferedReader(new FileReader(new File(movimentFile))) ) {
            moviment.append(reader.readLine() + System.lineSeparator());
        }

        hero = advantureMap.move(hero, moviment.toString() );
        System.out.println("hero position " + hero);


    }
}
