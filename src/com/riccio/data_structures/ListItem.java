package com.riccio.data_structures;

public abstract class ListItem {

    protected ListItem left = null;
    protected ListItem right = null;
    protected Object data;

    public ListItem(Object value) {
        this.data = value;

    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item );
    abstract int compareTo(ListItem item);

    public Object getValue() {
        return data;
    }

    public void setValue(Object value) {
        this.data = value;
    }
}
