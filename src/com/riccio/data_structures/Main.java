package com.riccio.data_structures;



public class Main {

    public static void main(String[] args) {

//        MyLinkList list = new MyLinkList(null);
//        list.traverse(list.getRoot());
//        String data = "5 7 3 9 8 2 1 0 4 6";
//        String[] dataSplitted = data.split(" ");
//        for (String s : dataSplitted){
//            list.addItem(new Node(s));
//        }
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("3"));
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("11"));
//        list.traverse(list.getRoot());
//
//
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());
        String data = "5 7 3 9 8 2 1 0 4 6";
        String[] dataSplitted = data.split(" ");
        for (String s : dataSplitted) {
            tree.addItem(new Node(s));
        }
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("3"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("11"));
        tree.traverse(tree.getRoot());

     }
}
