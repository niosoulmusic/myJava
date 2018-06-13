package com.riccio.extends_implements_more;

import java.util.HashSet;
import java.util.Set;

public abstract class    HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    public enum BodyType {STAR,PLANET,DWARF_PLANET,MOON,COMET,ASTEROIDS}

    public HeavenlyBody(String name, double orbitalPeriod,BodyType bodyType) {
        this.key = new Key(name,bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addSatellite(HeavenlyBody satellite){
        return this.satellites.add(satellite);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
            if (obj instanceof HeavenlyBody) {
                HeavenlyBody obj1 = (HeavenlyBody) obj;
                return this.key.equals( obj1.getKey());
            }
        return false;

    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyType bodyType){
        return new Key(name,bodyType);
    }
    @Override
    public String toString() {
        return this.getKey().name+" , "+this.getKey().bodyType+" , "+this.getOrbitalPeriod();
    }

    public static final class Key{
        private String name;
        private BodyType bodyType;

        public Key(String name, BodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode()+57+this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this.name.equals(((Key)obj).getName())){
                return this.bodyType==((Key)obj).getBodyType();
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name+" : "+this.bodyType;
        }
    }
}
