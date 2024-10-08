package listedouble;

public class Node {
    private int element;
    private Node next;
    private Node prev;

    public Node(int element, Node next, Node prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
