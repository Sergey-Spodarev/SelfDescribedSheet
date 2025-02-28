package collections;

/**
 * Обобщенный класс, представляющий односвязный список элементов.
 * Позволяет добавлять, удалять и получать элементы из списка.
 *
 * @param <T> Тип элементов, хранимых в списке.
 */
public class MyList<T> {
    /**
     * Приватный вложенный класс, представляющий узел односвязного списка.
     * Каждый узел содержит значение и ссылку на следующий узел.
     *
     * @param <T> Тип значения, хранимого в узле.
     */
    static private class Node<T>{
        T value;
        Node<T> next;
        /**
         * Конструктор для создания нового узла с заданным значением.
         *
         * @param value Значение, которое будет храниться в узле.
         */
        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * Возвращает текущий размер списка.
     *
     * @return Размер списка (количество элементов).
     */
    public int getSize() {
        return size;
    }

    private int size;
    private Node<T> head;

    public MyList() {
        size = 0;
        head = null;
    }

    /**
     * Метод добавляет значение в конец списка
     * @param value Значение, которое добавляется в лист
     */
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

    /**
     * Метод возвращает значение из листа по значению
     * @param value Значение, которое мы хотим проверить есть ли в листе
     * @return Возвращаем значение если оно есть, иначе возвращает null
     */
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

    /**
     * Возвращает значение из списка по указанному индексу.
     *
     * @param index Индекс элемента (индексация начинается с 0).
     * @return Значение элемента по указанному индексу; иначе null, если индекс некорректен.
     */
    public T getByIndex(int index){
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> slider = head;
        for (int i = 0; i < index; ++i){
            slider = slider.next;
        }
        return slider.value;
    }

    /**
     * Удаляет последний элемент из списка.
     * Если список пуст, метод не выполняет никаких действий.
     */
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

    /**
     * Удаляет первый элемент из списка.
     * Если список пуст, метод не выполняет никаких действий.
     */
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

    /**
     * Удаляет элемент из списка по указанному индексу.
     *
     * @param index Индекс элемента (индексация начинается с 0).
     * Если индекс некорректен, метод не выполняет никаких действий.
     */
    public void delByIndex(int index) {
        if (index < 0 || index >= size || head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> slider = head;
            for (int i = 0; i < index - 1; ++i) {
                slider = slider.next;
            }
            slider.next = slider.next.next;
        }
        size--;
    }
}
