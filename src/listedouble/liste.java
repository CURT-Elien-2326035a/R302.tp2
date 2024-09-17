package listedouble;

public class liste {
    private Node head;

    public int countNodes() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        Node current = head;

        while (current.getNext() != head) {
            count++;
            current = current.getNext();
        }

        return count;
    }

    public void pushBack(int element) {
        Node newNode = new Node(element, null, null);

        if (head == null) {
            head = newNode;
            newNode.setNext(head);
            newNode.setPrev(head);
        } else {
            Node tail = head.getPrev();
            
            tail.setNext(newNode);
            newNode.setPrev(tail);
            
            newNode.setNext(head);
            head.setPrev(newNode);
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("La liste est vide");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        } while (temp != head);
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        liste otherList = (liste) obj;

        if (this.countNodes() != otherList.countNodes()) {
            return false;
        }

        Node currentThis = this.head;
        Node currentOther = otherList.head;

        do {
            if (currentThis.getElement() != currentOther.getElement()) {
                return false;
            }
            currentThis = currentThis.getNext();
            currentOther = currentOther.getNext();
        } while (currentThis != this.head && currentOther != otherList.head);

        return true;
    }

    public static void main(String[] args) {
        liste list1 = new liste();
        list1.pushBack(10);
        list1.pushBack(20);
        list1.pushBack(30);

        liste list2 = new liste();
        list2.pushBack(10);
        list2.pushBack(20);
        list2.pushBack(30);

        System.out.println("Les deux listes sont-elles égales ? " + list1.equals(list2));

        list2.pushBack(40);

        System.out.println("Les deux listes sont-elles égales après modification ? " + list1.equals(list2));
    }
}
