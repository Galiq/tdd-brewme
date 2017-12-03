package tddApp.service;

import tddApp.domain.Malt;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by galik on 15.10.2017.
 */
public class MaltAdvancedManager implements MaltAdvanced {

    private MaltManager maltManager;

    void setDataSource(MaltManager maltManager) {
        this.maltManager = maltManager;
    }

    public ArrayList<Malt> getByIdList(String idList) {
        String[] strArray = idList.split(",");
        ArrayList<Malt> maltArrayList = new ArrayList<Malt>();
        for(int i = 0; i < strArray.length; i++) {
            maltArrayList.add(maltManager.read(Integer.parseInt(strArray[i])));
        }
        return maltArrayList;
    }

    public void deleteMalts(Collection<Malt> malt) {

    }
}
