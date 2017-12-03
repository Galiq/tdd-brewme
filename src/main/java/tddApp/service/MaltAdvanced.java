package tddApp.service;

import tddApp.domain.Malt;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by galik on 01.10.2017.
 */
public interface MaltAdvanced {

    //TODO: TESY kazdej z metod

    ArrayList<Malt> getByIdList(String name);

    void deleteMalts(Collection<Malt> malt);

}
