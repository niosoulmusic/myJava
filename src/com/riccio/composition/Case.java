package com.riccio.composition;

public class Case {
    private String model;
    private String manifacturer;
    private String powerSupply;
    private Dimension dimension;

    public Case(String model, String manifacturer, String powerSupply, Dimension dimension) {
        this.model = model;
        this.manifacturer = manifacturer;
        this.powerSupply = powerSupply;
        this.dimension = dimension;
    }

    public void pressPowerButton(){
        System.out.println("Power Button pressed");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManifacturer() {
        return manifacturer;
    }

    public void setManifacturer(String manifacturer) {
        this.manifacturer = manifacturer;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
