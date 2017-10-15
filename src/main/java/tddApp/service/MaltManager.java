package tddApp.service;

import tddApp.domain.Malt;

import java.util.ArrayList;

/**
 * Created by galik on 01.10.2017.
 */
public interface MaltManager {

    void create(Malt malt);

    ArrayList<Malt> read();

    Malt read(int id);

    void update(Malt malt) throws Exception;

    void delete(Malt malt);

}
