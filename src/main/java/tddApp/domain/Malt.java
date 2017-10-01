package tddApp.domain;

/**
 * Created by galik on 01.10.2017.
 */
public class Malt {

    private int id;
    private String name;
    private int qunatity;
    private int colorEBC;
    private String producer;

    public Malt(int id, String name, int qunatity, int colorEBC, String producer) {
        this.id = id;
        this.name = name;
        this.qunatity = qunatity;
        this.producer = producer;
    }

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
