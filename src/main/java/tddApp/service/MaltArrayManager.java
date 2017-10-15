package tddApp.service;

import tddApp.domain.Malt;
import tddApp.exception.NotFoundException;

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

    /**
     * @param malt
     * @throws Exception
     */
    public void update(Malt malt) throws NotFoundException {
        try {
            Malt maltToUpdate = read(malt.getId());
            int index = maltCollection.indexOf(maltToUpdate);
            maltToUpdate.setName(malt.getName());
            maltToUpdate.setQunatity(malt.getQunatity());
            maltToUpdate.setColorEBC(malt.getColorEBC());
            maltToUpdate.setProducer(malt.getProducer());
            maltCollection.add(index, maltToUpdate);
        } catch (NullPointerException exception){
            throw (new NotFoundException("Malt with index not found"));
        }
    }

    public void delete(Malt malt) {
        maltCollection.remove(malt);
    }
}
