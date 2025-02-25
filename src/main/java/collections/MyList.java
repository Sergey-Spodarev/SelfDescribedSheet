package collections;

public class MyList<T> {
    static private class Node<T>{
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }
    private int size;
    private Node<T> head;

    public MyList() {
        size = 0;
        head = null;
    }

    public void add(T value){
        Node<T> newNode = new Node<>(value);
        if (head == null){
            head = newNode;
        }
        else{
            Node<T> slider = head;
            while (slider.next != null) {
                slider = slider.next;
            }
            slider.next = newNode;
        }
        size += 1;
    }

    public T getByValue(T value){
        if (head == null){
            return null;
        }
        Node<T> slider = head;
        while(slider.next != null && slider.value != value){
            slider = slider.next;
        }
        return slider.value == value ? slider.value : null;
    }

    public T getByIndex(int index){
        if (head == null && index > size){
            return null;
        }
        Node<T> slider = head;
        for (int i = 0; i < index; ++i){
            slider = slider.next;
        }
        return slider.value;
    }

    public void delLastNode() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            size = 0;
            return;
        }
        Node<T> slider = head;
        while (slider.next.next != null) {
            slider = slider.next;
        }
        slider.next = null;
        size--;
    }

    public void delFirstNode(){
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            size = 0;
            return;
        }
        Node<T> newHead = head.next;
        head = null;
        head = newHead;
        size--;
    }

    public void delByIndex(int index){
        if (head == null && index > size){
            return;
        }
        Node<T> slider = head;
        for (int i = 0; i < index - 1; ++i){
            slider = slider.next;
        }
        if (index < size - 2){
            slider.next = slider.next.next;
        }
        else{
            slider.next = null;
        }
        size--;
    }
}
