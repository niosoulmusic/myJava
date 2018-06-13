package com.riccio.collection;

import java.util.Map;

public class Main {

    private static StockList list = new StockList();
    public static void main(String[] args) {

        StockItem myItem = new StockItem("bread",6.20,100);
        list.addStock(myItem);
        myItem=new StockItem("cake",10,7);
        list.addStock(myItem);
        myItem=new StockItem("juice",5,70);
        list.addStock(myItem);
        myItem=new StockItem("carrot",1,700);
        list.addStock(myItem);
        myItem=new StockItem("pineapple",10,17);
        list.addStock(myItem);
        myItem=new StockItem("flour",5,7000);
        list.addStock(myItem);
        myItem=new StockItem("ice scream",19,70000);
        list.addStock(myItem);
        myItem=new StockItem("cake",0.45,10);
        list.addStock(myItem);
        Basket gegeBasket = new Basket("gege");
        sellItem(gegeBasket,"flour",10);
        sellItem(gegeBasket,"flour",20);
        sellItem(gegeBasket,"flour",20000);
        sellItem(gegeBasket,"cavoli",10);
        Basket customerBasket = new Basket("customer");
        sellItem(customerBasket,"flour",100);
        sellItem(customerBasket,"ice scream",10);
        removeItem(gegeBasket,"flour",10);
        removeItem(customerBasket,"flour",10);
        removeItem(gegeBasket,"cavoli",10);
        System.out.println(gegeBasket);
        checkOut(gegeBasket);
        checkOut(customerBasket);
    }

    public static int sellItem(Basket basket, String item,int quantity){
        StockItem stockItem = list.get(item);
        if (item==null){
            System.out.println("we don't sell item "+ item);
            return 0;

        }else{
            if (list.reserveStock(item,quantity) !=0){
                return basket.addToBasket(stockItem,quantity);
            }
        }
        return 0;
    }
    public static int removeItem(Basket basket, String item,int quantity){
        StockItem stockItem = list.get(item);
        if (item==null){
            System.out.println("we don't sell item "+ item);
            return 0;

        }else{
            if (basket.removeFromBasket(stockItem,quantity) ==quantity){
                return list.unreserveStock(item,quantity);
            }
        }
        return 0;
    }

    public static void checkOut (Basket basket){
        for (Map.Entry<StockItem,Integer> item : basket.items().entrySet()){
            list.sellStock(item.getKey().getName(),item.getValue());
        }
        basket.clearBasket();
    }
}
