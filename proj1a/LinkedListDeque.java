public class LinkedListDeque<T> {

    // inner class
    public class Node {
        public T item;
        public Node previous;
        public Node next;

        public Node(T item) {
            this.item = item;
        }

        public Node(T item, Node previous, Node next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    public int size;
    public Node sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null);
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        size += 1;
        Node node = new Node(item, sentinel, sentinel.next);
        sentinel.next.previous = node;
        sentinel.next = node;

    }

    public void addLast(T item) {
        size += 1;
        Node node = new Node(item, sentinel.previous, sentinel);
        sentinel.previous.next = node;
        sentinel.previous = node;
    }

    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }

        return false;
    }

    public int size() {
        return size;
    }

    //Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {

    }

    public T removeFirst() {
        size -= 1;
        //get the first node
        Node node = sentinel.next;
        sentinel.next = node.next;
        node.next.previous = sentinel;

        return node.item;
    }

    public T removeLast() {
        size -= 1;
        //get the last node
        Node node = sentinel.previous;
        sentinel.previous = node.previous;
        node.next.previous = sentinel;

        return node.item;
    }

    public T get(int index) {

        Node node = sentinel.next;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.item;
    }

    public T getRecursive(int index) {

        if (index == 0) {
            return sentinel.item;
        }
        index -= 1;
        sentinel = sentinel.next;
        return getRecursive(index);

    }

}
