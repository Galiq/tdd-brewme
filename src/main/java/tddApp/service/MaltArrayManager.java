package tddApp.service;

import tddApp.domain.Malt;

import java.util.ArrayList;

/**
 * Created by galik on 01.10.2017.
 */
public class MaltArrayManager implements MaltManager {

    private ArrayList<Malt> maltCollection = new ArrayList<Malt>();

    public void create(Malt malt) {
        maltCollection.add(malt);
    }

    public ArrayList<Malt> read() {
        return maltCollection;
    }

    public Malt read(int id) {
        for (Malt malt : maltCollection) {
            if (malt.getId() == id) {
                return malt;
            }
        }
        return null;
    }

    public void update(Malt malt) throws Exception {
        Malt maltToUpdate = read(malt.getId());
        int index = maltCollection.indexOf(maltToUpdate);
        maltToUpdate.setName(malt.getName());
        maltToUpdate.setQunatity(malt.getQunatity());
        maltToUpdate.setColorEBC(malt.getColorEBC());
        maltToUpdate.setProducer(malt.getProducer());
        maltCollection.add(index, maltToUpdate);
    }

    public void delete(Malt malt) {
        maltCollection.remove(malt);
    }
}
