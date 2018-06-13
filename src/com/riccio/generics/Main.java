package com.riccio.generics;

import com.riccio.generics.League;

public class Main {

    public static void main(String[] args) {

        /*FootballPlayer joe = new FootballPlayer("joe");
        BaseballPlayer pet = new BaseballPlayer("pet");
        SoccerPlayer ronaldo = new SoccerPlayer("ronaldo");
        SoccerPlayer genio = new SoccerPlayer("genio");
        SoccerPlayer mario = new SoccerPlayer("mario");
        Team<FootballPlayer> baubau = new Team<>("baubau");
        baubau.addPlayer(joe);
        Team<BaseballPlayer> miaomiao = new Team<>("miaomiao");
        miaomiao.addPlayer(pet);
        Team<SoccerPlayer> bestSoccer = new Team<>("bestSoccer");
        bestSoccer.addPlayer(ronaldo);
        Team<SoccerPlayer> catanzion = new Team<>("catanzion");
        catanzion.addPlayer(genio);
        Team<SoccerPlayer> milano = new Team<>("milano");
        milano.addPlayer(mario);

        catanzion.matchResult(milano,10,2);
        milano.matchResult(bestSoccer,5,0);
        bestSoccer.matchResult(catanzion,0,2);
        System.out.println("Rankings ");
        System.out.println(catanzion.getName()+ " : "+catanzion.ranking());
        System.out.println(milano.getName()+ " : "+ milano.ranking());
        System.out.println(bestSoccer.getName()+ " : "+ bestSoccer.ranking());
        System.out.println(bestSoccer.compareTo(milano));
        System.out.println(catanzion.compareTo(milano));
        System.out.println(bestSoccer.compareTo(catanzion));*/

        League<Team<SoccerPlayer>> footballLeague = new League<>("FIFA");
        Team<SoccerPlayer> bestSoccer = new Team<>("bestSoccer");
        Team<SoccerPlayer> catanzion = new Team<>("catanzion");
        Team<SoccerPlayer> milano = new Team<>("milano");
        footballLeague.add(bestSoccer);
        footballLeague.add(catanzion);
        footballLeague.add(milano);
        catanzion.matchResult(milano,10,2);
        milano.matchResult(bestSoccer,5,0);
        bestSoccer.matchResult(catanzion,0,2);
        footballLeague.teamChart();


    }

}
