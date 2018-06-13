package com.riccio.extends_implements_more;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<HeavenlyBody.Key,HeavenlyBody> solarSystem= new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    public static void main(String[] args) {
        HeavenlyBody planet = new Planet("Mercury",88);
        solarSystem.put(planet.getKey(),planet);
        planets.add(planet);

        planet = new Planet("Pippo",88);
        solarSystem.put(planet.getKey(),planet);
        planets.add(planet);

        planet = new Planet("Venus",225);
        solarSystem.put(planet.getKey(),planet);
        planets.add(planet);

        planet = new Planet("Earth",365);
        solarSystem.put(planet.getKey(),planet);
        planets.add(planet);

        HeavenlyBody moon = new Moon("Moon",27);
        solarSystem.put(moon.getKey(),moon);
        //add a moon to planet earth
        planet.addSatellite(moon);

        planet = new Planet("Mars",365);
        solarSystem.put(planet.getKey(),planet);
        planets.add(planet);

        moon = new Moon("Deimos",13);
        solarSystem.put(moon.getKey(),moon);
        //add a moon to planet earth
        planet.addSatellite(moon);

        moon = new Moon("Sophos",13);
        solarSystem.put(moon.getKey(),moon);
        //add a moon to planet earth
        planet.addSatellite(moon);

        planet = new Planet("Jupiter",365);
        solarSystem.put(planet.getKey(),planet);
        planets.add(planet);

        moon = new Moon("Io",13);
        solarSystem.put(moon.getKey(),moon);
        //add a moon to planet earth
        planet.addSatellite(moon);

        moon = new Moon("Europa",13);
        solarSystem.put(moon.getKey(),moon);
        //add a moon to planet earth
        planet.addSatellite(moon);

        moon = new Moon("Ganymede",13);
        solarSystem.put(moon.getKey(),moon);
        //add a moon to planet earth
        planet.addSatellite(moon);

        planet = new DwarfPlanet("Pippo",828);
        solarSystem.put(planet.getKey(),planet);
        planets.add(planet);

        for (HeavenlyBody planetItem : planets){
            System.out.println(planetItem);
            if (planetItem.getSatellites().size()>0){
                for (HeavenlyBody satellite : planetItem.getSatellites()){
                    System.out.println(planetItem.getKey().getName()+"-> \t"+satellite.toString());
                }
            }
        }

        HeavenlyBody planet1 = new Planet("Earth",365);
        solarSystem.put(planet1.getKey(),planet);
        planet1 = new Planet("Earth",366);
        solarSystem.put(planet1.getKey(),planet1);
        System.out.println(solarSystem.get(new HeavenlyBody.Key("Earth", HeavenlyBody.BodyType.PLANET)));

    }
}
