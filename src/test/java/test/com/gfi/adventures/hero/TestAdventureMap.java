package test.com.gfi.adventures.hero;

import com.gfi.adventures.hero.AdventureMap;
import com.gfi.adventures.hero.Hero;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestAdventureMap {

    @Test
    public void shouldOpenMap(){

        final AdventureMap map = new AdventureMap(new File(ClassLoader.getSystemResource("card.txt").getFile()));
        assertNotNull(map.getMapFile());
        assertFalse(map.getMapFile().isEmpty());

    }

    @Test
    public void shouldDefineFirst() {
        final AdventureMap map = new AdventureMap(new File(ClassLoader.getSystemResource("card.txt").getFile()));
        Hero hero = map.createHero();
        assertEquals(0, hero.getLine());
        assertEquals(3, hero.getColumn());
    }

    @Test
    public void shouldMoveTheHero() {
        final AdventureMap map = new AdventureMap(new File(ClassLoader.getSystemResource("card.txt").getFile()));
        Hero hero = map.createHero();
        assertEquals(0, hero.getLine());
        assertEquals(3, hero.getColumn());

        final String MOVIMENT_1 = "3.0\r\nSSSSEEEEEENN";

        hero = map.move(hero, MOVIMENT_1);

        assertEquals(2, hero.getLine());
        assertEquals(9, hero.getColumn());



    }

    @Test
    public void shouldMoveToWEST() {


        final String MOVIMENT_2 = "9.6\r\nOONOOOSSO";

        final AdventureMap map = new AdventureMap(new File(ClassLoader.getSystemResource("card.txt").getFile()));
        Hero hero = map.createHero();
        hero = map.move(hero, MOVIMENT_2);

        assertEquals("coluna",5, hero.getColumn());
        assertEquals("linha",7, hero.getLine());
    }

}