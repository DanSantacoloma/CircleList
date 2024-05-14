public class CircleList {

    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public CircleList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int data) {
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            Node newNode = new Node(data);
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
    }

    public void printCl() {
        Node current = head;
        while (current.getNext() != null) {
            System.out.println(current.getData());
            if (current.getNext() == head) {
                return;
            }
            current = current.getNext();
        }
    }

    public void removeNode(int data) {
        Node current = head;
        Node previous = current;
        while (current != null) {
            previous = current;
            current = current.getNext();
            if (current.getData() == data) {
                if (current == head) {
                    head = current.getNext();
                    tail.setNext(head);
                    current = null;
                    return;
                }
                if (current == tail) {
                    tail = previous;
                    tail.setNext(head);
                    current = null;
                    return;
                }
                previous.setNext(current.getNext());
                current = null;
                return;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        CircleList myCl = new CircleList();
        myCl.insertNode(10);
        myCl.insertNode(20);
        myCl.insertNode(30);
        myCl.insertNode(40);
        myCl.insertNode(50);
        myCl.insertNode(60);
        System.out.println("Before:");
        myCl.printCl();
        myCl.removeNode(60);
        myCl.removeNode(20);
        myCl.removeNode(10);
        System.out.println("After:");
        myCl.printCl();
        System.out.println("New head: " + myCl.getHead().getData());
        System.out.println("New tail: " + myCl.getTail().getData());
        System.out.println("Tail's next: " + myCl.getTail().getNext().getData());
    }
}
