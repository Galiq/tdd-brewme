package tddApp.service;

import java.util.Collection;

/**
 * Created by galik on 01.10.2017.
 */
public interface WarehouseManager {

    void create();

    Collection read();

    Object read(int id);

    void update(Object ob);

    void delete(Object ob);

}
