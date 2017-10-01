package tddApp.domain;

/**
 * Created by galik on 01.10.2017.
 */
public class MaltWarehouse {

    private int id;
    private String name;
    private int qunatity;
    private int colorEBC;
    private String producer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    public int getColorEBC() {
        return colorEBC;
    }

    public void setColorEBC(int colorEBC) {
        this.colorEBC = colorEBC;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
