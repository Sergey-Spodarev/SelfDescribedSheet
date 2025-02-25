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
}
