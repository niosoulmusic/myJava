package com.riccio.extends_implements_more;

public class DwarfPlanet extends  HeavenlyBody{

    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod,BodyType.DWARF_PLANET);
    }

}
