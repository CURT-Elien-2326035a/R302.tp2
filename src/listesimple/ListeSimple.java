package listesimple;

public class ListeSimple {
    private Node head;
    private long size;

    public ListeSimple() {
        head = null;
        size = 0;
    }

    public void createNode(int element) {
        Node node = new Node(element, null);
        if (head == null) {
            head = node;
        } else {
            Node tmpNode = head;
            while (tmpNode.getNext() != null) {
                tmpNode = tmpNode.getNext();
            }
            tmpNode.setNext(node);
        }
        size++; 
        }

        public void read() {
        Node node = head;
        if (node == null) {
            System.out.println("La liste est vide");
            return;
        }
        while (node != null) {
            System.out.print(node.getElement());
            if (node.getNext() != null) {
                System.out.print(" -> ");
            }
            node = node.getNext();
        }
        System.out.println();
    }

    public void update(int oldEl, int newEl) {
        Node node = head;
        while (node != null && node.getElement() != oldEl) {
            node = node.getNext();
        }
        if (node != null) {
            node.setElement(newEl);
        } else {
            System.out.println("Élément " + oldEl + " non trouvé.");
        }
    }

    public void delete(int del) {
        if (head == null) {
            System.out.println("La liste est vide.");
            return;
        }

        if (head.getElement() == del) {
            head = head.getNext();
            size--;
            return;
        }

        Node node = head;
        Node prevNode = null;
        while (node != null && node.getElement() != del) {
            prevNode = node;
            node = node.getNext();
        }

        if (node != null) {
            prevNode.setNext(node.getNext());
            size--; 
        } else {
            System.out.println("Élément " + del + " non trouvé.");
        }
    }

    public void startInsert(int insert) {
        Node newNode = new Node(insert, head);
        head = newNode;
        size++;
    }
    
    public int findPenultimateNode() {
        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        return current.getElement();
    }
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next = null;
            
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;            
            }
            
        head = previous; 
    }
    
    public static void main(String[] args) {
        ListeSimple listeSimple = new ListeSimple();
        listeSimple.createNode(10);
        listeSimple.createNode(9);
        listeSimple.createNode(8);
        listeSimple.createNode(7);
        listeSimple.createNode(6);
        listeSimple.createNode(5);
        listeSimple.createNode(4);
        listeSimple.createNode(3);

        System.out.println("Liste initiale:");
        listeSimple.read();

        System.out.println("Après mise à jour (10 -> 6) :");
        listeSimple.update(10, 6);
        listeSimple.read();

        System.out.println("Après suppression (7) :");
        listeSimple.delete(7);
        listeSimple.read();

        System.out.println("Après insertion au début (15) :");
        listeSimple.startInsert(15);
        listeSimple.read();
        
        System.out.print("avant dernier :");
        System.out.println(listeSimple.findPenultimateNode());
        
        System.out.println("liste inversée:");
        listeSimple.reverse();
        listeSimple.read();
        
        System.out.println("on remplace les cases:");
        listeSimple.swapNodes(2,4);
    
    }
}



