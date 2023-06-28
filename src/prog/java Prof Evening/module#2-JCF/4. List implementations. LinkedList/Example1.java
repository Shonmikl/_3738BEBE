// todo recheck classwork with the code
public class Example1 {
    public static void main(String[] args) {
        MyOwnLinkedList a = new MyOwnLinkedList();

        a.add(10);
        a.add(20);
        a.add(30);

        a.printList();

        a.deleteByKey(20);
        a.printList();

        a.deleteAtPosition(1);
        a.printList();
    }
}

class Node {
    private final int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }


    // GETTERS & SETTERS
    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}

class MyOwnLinkedList {

    private Node head;

    // ADDING DATA
    public void add(int data) {

        // creating a new node with given data
        Node newNode = new Node(data);
        newNode.setNext(null);

        // if the MyOwnLinkedList is empty, then make the new node as head
        if (head == null)
            head = newNode;

        else {
            // else traverse till the last node and insert the new_node there
            Node tail = head;
            while (tail.getNext() != null)
                tail = tail.getNext();

            tail.setNext(newNode);
        }
    }

    // PRINTING LIST
    public void printList() {
        Node currNode = head;

        System.out.print("MyOwnLinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.getData() + " ");
            currNode = currNode.getNext();
        }
        System.out.println();
    }

    // DELETION BY KEY
    public void deleteByKey(int key) {
        Node currNode = head;
        Node prev = null;

        if (currNode != null && currNode.getData() == key) {
            head = currNode.getNext();

            System.out.println(key + " found and deleted");
        }

        while (currNode != null && currNode.getData() != key) {
            prev = currNode;
            currNode = currNode.getNext();
        }

        if (currNode != null) {
            prev.setNext(currNode.getNext());
            System.out.println(key + " found and deleted");
        }

        if (currNode == null)
            System.out.println(key + " not found");
    }

    public void deleteAtPosition(int index) {
        Node currNode = head;
        Node prev = null;

        if (index == 0 && currNode != null) {
            head = currNode.getNext();

            System.out.println(index + " position element deleted");
        }

        int counter = 0;

        while (currNode != null ) {
            if (counter == index) {
                prev.setNext(currNode.getNext());
                System.out.println(index + " position element deleted");
                break;
            } else {
                prev = currNode;
                currNode = currNode.getNext();
                counter++;
            }
        }

        if (currNode == null)
            System.out.println(index + " position element not found");
    }
}