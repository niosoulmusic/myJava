package com.riccio.data_structures;



public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
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
        if (item!=null){
            System.out.println("deleting item "+ item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while (currentItem!=null){
            int comparison = currentItem.compareTo(item);
            //it means we'll go right in the tree
            if (comparison<0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            }else if (comparison > 0){
                //means we'll go left in the tree
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }else{
                //we found the element
                performRemoval(currentItem,parentItem);
            }
        }
        return false;
    }
    private void performRemoval(ListItem item, ListItem parent){
        if (item.next()==null){
            //no right tree so make point parent point to left tree(which may be null)
            if (parent.next()==null){
                parent.setNext(item.previous());
            }else if (parent.previous()==item){
                //item is left child of its parent
                parent.setPrevious(item.previous());
            }else{
                //parent must be item so we're looking at the root of the tree
                this.root=item.previous();
            }
        }else if (item.previous() == null){
            //no left tree so make parent point to right tree (which may be null)
            if (parent.next()==item){
                //item is right child of its parent
                parent.setNext(item.next());
            }else if (parent.previous()== item){
                //item is left child of its parent
                parent.setPrevious(item.next());
            }else{
                //root deleting
                this.root= item.next();
            }
        }else{
            //neither left nor right are null, deletion requires trickies
            //from the right subtree lets look for the leftmost item --the smallest value
            ListItem current = item.next();
            ListItem leftMostParent = item;
            while (current.previous()!=null){
                leftMostParent = current;
                current = current.previous();
            }
            //now put the smallest value into node for deletion
            item.setValue(current.getValue());
            if (leftMostParent==item){
                item.setNext(current.next());
            }else{
                leftMostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root!=null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }


}
