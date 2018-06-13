package com.riccio.extends_implements_more;

public class Moon extends HeavenlyBody {
    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.MOON);
    }
}
