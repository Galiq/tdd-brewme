package tddApp.service;

import junit.framework.TestCase;
import tddApp.domain.Malt;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by galik on 01.10.2017.
 */
public class MaltManagerTest {
    @org.junit.Test
    public void createTest() throws Exception {
        MaltManager maltManager = new MaltArrayManager();
        Malt malt = new Malt(1, "elo", 1, 1, "strzegom");
        maltManager.create(malt);

        assertEquals(1, maltManager.read().size());
    }

    @org.junit.Test
    public void read() throws Exception {
        MaltManager maltManager = new MaltArrayManager();
        assertEquals(0, maltManager.read().size());

        Malt malt = new Malt(1, "elo", 1, 1, "strzegom");
        maltManager.create(malt);

        assertEquals(1, maltManager.read().size());

    }

    @org.junit.Test
    public void read1() throws Exception {
        MaltManager maltManager = new MaltArrayManager();
        Malt malt = new Malt(1, "elo", 1, 1, "strzegom");
        Malt malt2 = new Malt(2, "elo", 1, 1, "strzegom");
        maltManager.create(malt);
        maltManager.create(malt2);

        assertEquals(malt, maltManager.read(1));
        assertEquals(malt2, maltManager.read(2));
    }

    @org.junit.Test
    public void update() throws Exception {
        MaltManager maltManager = new MaltArrayManager();
        Malt malt = new Malt(1, "elo", 1, 1, "strzegom");
        Malt malt2 = new Malt(1, "dwa zero", 2, 2, "malteurope");

        maltManager.create(malt);

        maltManager.update(malt2);

        assertEquals(malt2.getName(), maltManager.read(1).getName());
        assertEquals(malt2.getQunatity(), maltManager.read(1).getQunatity());
        assertEquals(malt2.getColorEBC(), maltManager.read(1).getColorEBC());
        assertEquals(malt2.getProducer(), maltManager.read(1).getProducer());
    }
    

    @org.junit.Test
    public void delete() throws Exception {
        MaltManager maltManager = new MaltArrayManager();
        Malt malt = new Malt(1, "elo", 1, 1, "strzegom");
        Malt malt2 = new Malt(2, "elo", 1, 1, "strzegom");
        maltManager.create(malt);
        maltManager.create(malt2);

        assertEquals(malt, maltManager.read(1));
        assertEquals(malt2, maltManager.read(2));

        maltManager.delete(malt2);

        assertEquals(malt, maltManager.read(1));
        assertEquals(null, maltManager.read(2));
    }
}