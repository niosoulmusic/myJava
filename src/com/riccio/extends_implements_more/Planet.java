package com.riccio.extends_implements_more;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getKey().getBodyType()== BodyType.MOON){
            return super.addSatellite(satellite);
        }
        return false;
    }
}
