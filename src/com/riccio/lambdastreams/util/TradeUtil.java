package com.riccio.lambdastreams.util;

import com.riccio.lambdastreams.domain.Trade;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ciccioPasticcio
 */
public class TradeUtil {

    public static List<Trade> createTrades(){
        List<Trade> trades = new ArrayList<Trade>();
        
        Trade t = new Trade(1, "GOOG",200000,"CANCEL");
        trades.add(t);
        t = new Trade(2,"APPL",2000000,"CANCEL");
        trades.add(t);
        t = new Trade(3,"IBM",3000000,"NEW");
        trades.add(t);
        t = new Trade(4,"IBM",4000000,"PENDING");
        trades.add(t);
        
        return trades;
    }
    
    public static List<Trade> createTrades(int size){
        List<Trade> trades = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            Trade t = new Trade("ISUER "+i,i+1000,"NEW");
            trades.add(t);
        }
        
        return trades;
    }
    
    
}
