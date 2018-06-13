package com.riccio.collection;

import java.util.*;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new TreeMap<>();

    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            //if there's already a stock item in the map let's adjust quantity
            if (inStock != item) {
                item.adjustQuantityStock(inStock.availableQuantity());
            }
            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        return 0;

    }

    public int reserveStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if (inStock!=null && inStock.availableQuantity()>0){
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if (inStock!=null && inStock.availableQuantity()>0){
            return inStock.unreserveStock(quantity);
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if (inStock!=null && inStock.availableQuantity()>0){
            return inStock.finalizeStock(quantity);
        }
        return 0;
//        StockItem instock = list.getOrDefault(item, null);
//        if ((instock != null) && (instock.availableQuantity() >= quantity) &&
//                (quantity > 0)) {
//            instock.adjustQuantityStock(-quantity);
//            return quantity;
//        }
//        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap(list);
    }
    public Map<String,Double> priceList(){
        Map<String,Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String,StockItem> item : list.entrySet()){
            prices.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override
    public String toString() {
        String output = "\n Stock List \n";
        double totalCost = 0;
        for (Map.Entry<String,StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();
            output=output+ stockItem + ". There are "+ stockItem.availableQuantity() +
                    " in stock. Value of items :"+String.format("%.2f",itemValue)+"\n";
            totalCost+=itemValue;
        }
        return output+ " total cost : "+String.format("%.2f",totalCost);
    }
}
