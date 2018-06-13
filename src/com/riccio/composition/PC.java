package com.riccio.composition;

public class PC {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }


    public void powerUp(){
        getTheCase().pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        getMonitor().drawPixelAt(255,444,"yellow");

    }
    private Case getTheCase() {
        return theCase;
    }

    public void setTheCase(Case theCase) {
        this.theCase = theCase;
    }

    private Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    private Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }
}
