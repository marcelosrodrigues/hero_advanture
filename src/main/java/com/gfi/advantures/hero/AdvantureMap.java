package com.gfi.advantures.hero;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdvantureMap {

    private List<byte[]> map = new ArrayList<>();

    public AdvantureMap(File mapFile) {

        try (BufferedReader reader = new BufferedReader(new FileReader(mapFile))) {
            String linha = null;
            while ((linha = reader.readLine()) != null) {

                map.add(linha.getBytes());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<byte[]> getMapFile() {
        return this.map;
    }

    public Hero createHero() {
        Hero hero = new Hero();
        return hero.start(this.map);
    }

    public Hero move(Hero hero, String moviment) {

        String[] startposition = moviment.split(System.lineSeparator());
        String[] positions = startposition[0].split("\\.");
        int column = Integer.parseInt(positions[0]);
        int line = Integer.parseInt(positions[1]);

        return hero.start(line , column)
                   .move(startposition[1]);


    }
}
