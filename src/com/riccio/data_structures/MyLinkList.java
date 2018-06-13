package com.riccio.data_structures;

public class MyLinkList implements NodeList {

    private ListItem root = null;

    public MyLinkList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {

        if (this.root == null) {
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);

                } else {
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null ) {
            System.out.println("Deleting item :" + item.getValue());
        }
        ListItem currenItem = this.root;
        while (currenItem!=null){
            int comparison = currenItem.compareTo(item);
            if (comparison==0){
                if (currenItem==this.root){
                    this.root=currenItem.next();
                }else{
                    currenItem.previous().setNext(currenItem.next());
                    if (currenItem.next()!=null){
                        currenItem.next().setPrevious(currenItem.previous());
                    }
                }
                return true;
            }else if (comparison<0){
                currenItem = currenItem.next();
            }else{
                System.out.println("item "+item.getValue()+" not found");
                return false;
            }
        }
        System.out.println("empy list");
        return false;
    }

    @Override
    public void traverse(ListItem root) {

        if (root == null) {
            System.out.println("no elements");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
