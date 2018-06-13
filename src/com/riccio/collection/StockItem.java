package com.riccio.collection;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityInStock =0;
    private int reserved=0;

    public StockItem(String name, double price) {
        this(name,price,0);
    }
    public StockItem(String name, double price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.quantityInStock =stockQuantity;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock -reserved;
    }

    public void setPrice(double price) {
        if (price>0) {
            this.price = price;
        }

    }


    public void adjustQuantityStock(int quantityStock){
        int newQuantity= this.quantityInStock +quantityStock;
        if (newQuantity>=0) {
            this.quantityInStock = newQuantity;
        }

    }

    public int reserveStock(int quantity){
        if ((quantity>0) && (availableQuantity()>=quantity)){//use the method,not variable
           reserved+=quantity;
           return quantity;
        }
        return 0;
    }
    public int unreserveStock(int quantity){
        if (quantity<=reserved){
            reserved-=quantity;
            return quantity;
        }
        return 0;
    }

    public int finalizeStock(int quantity){
        if (quantity<=reserved){
            quantityInStock-=quantity;
            reserved-=quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj== this){
            return true;
        }else if (obj==null || obj.getClass()!=this.getClass()){
            return false;
        }
        String name = ((StockItem)obj).getName();
        return this.name.equals(name);

    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+31;
    }

    @Override
    public int compareTo(StockItem item) {
        System.out.println("entering stockitem.compareto");
        if (this == item) {
            return 0;
        }
        if (item != null) {
            return this.name.compareTo(item.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name+" : price "+this.price + " reserved : "+this.reserved;
    }
}
