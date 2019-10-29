package test.com.gfi.advantures.hero;

import com.gfi.advantures.hero.AdvantureMap;
import com.gfi.advantures.hero.Hero;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestAdvantureMap {

    @Test
    public void shouldOpenMap(){

        final AdvantureMap map = new AdvantureMap(new File(ClassLoader.getSystemResource("card.txt").getFile()));
        assertNotNull(map.getMapFile());
        assertFalse(map.getMapFile().isEmpty());

    }

    @Test
    public void shouldDefineFirst() {
        final AdvantureMap map = new AdvantureMap(new File(ClassLoader.getSystemResource("card.txt").getFile()));
        Hero hero = map.createHero();
        assertEquals(0, hero.getLine());
        assertEquals(3, hero.getColumn());
    }

    @Test
    public void shouldMoveTheHero() {
        final AdvantureMap map = new AdvantureMap(new File(ClassLoader.getSystemResource("card.txt").getFile()));
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

        final AdvantureMap map = new AdvantureMap(new File(ClassLoader.getSystemResource("card.txt").getFile()));
        Hero hero = map.createHero();
        hero = map.move(hero, MOVIMENT_2);

        assertEquals("coluna",5, hero.getColumn());
        assertEquals("linha",7, hero.getLine());
    }

}