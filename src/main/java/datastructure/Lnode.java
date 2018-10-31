package datastructure;

public class Lnode<type> {
    public type item;
    public Lnode<type> next;

    public Lnode(type item, Lnode<type> next) {
        this.item = item;
        this.next = next;
    }
    public Lnode(type item) {
        this.item = item;
        this.next = null;
    }

}