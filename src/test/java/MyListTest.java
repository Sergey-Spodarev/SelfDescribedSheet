import collections.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {
    private MyList<Integer> list;
    @BeforeEach
    void setUp() {
        list = new MyList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
    }

    @Test
    void testAdd() {
        list.add(50);
        assertEquals(5, list.getSize()); // Размер списка должен быть 5
        assertEquals(50, list.getByIndex(4)); // Последний элемент должен быть 50
    }

    @Test
    void testGetByValue() {
        assertEquals(10, list.getByValue(10)); // Элемент со значением 10 найден
        assertEquals(30, list.getByValue(30)); // Элемент со значением 30 найден
        assertNull(list.getByValue(100)); // Элемент со значением 100 не найден
    }

    @Test
    void testGetByIndex() {
        assertEquals(10, list.getByIndex(0)); // Первый элемент
        assertEquals(20, list.getByIndex(1)); // Второй элемент
        assertEquals(40, list.getByIndex(3)); // Четвертый элемент
        assertNull(list.getByIndex(10)); // Индекс вне диапазона
    }

    @Test
    void testDelLastNode() {
        list.delLastNode();
        assertEquals(3, list.getSize()); // Размер уменьшился на 1
        assertNull(list.getByValue(40)); // Последний элемент удален
        assertEquals(30, list.getByIndex(2)); // Третий элемент остался 30
    }

    @Test
    void testDelFirstNode() {
        list.delFirstNode();
        assertEquals(3, list.getSize()); // Размер уменьшился на 1
        assertNull(list.getByValue(10)); // Первый элемент удален
        assertEquals(20, list.getByIndex(0)); // Новый первый элемент теперь 20
    }

    @Test
    void testDelByIndex() {
        list.delByIndex(1); // Удаляем второй элемент (20)
        assertEquals(3, list.getSize()); // Размер уменьшился на 1
        assertNull(list.getByValue(20)); // Элемент 20 удален
        assertEquals(30, list.getByIndex(1)); // Второй элемент теперь 30
    }

    @Test
    void testEmptyListOperations() {
        MyList<Integer> emptyList = new MyList<>();
        assertNull(emptyList.getByValue(10)); // Поиск в пустом списке
        assertNull(emptyList.getByIndex(0)); // Получение элемента из пустого списка
        emptyList.delLastNode(); // Удаление из пустого списка
        emptyList.delFirstNode(); // Удаление из пустого списка
        emptyList.delByIndex(0); // Удаление по индексу из пустого списка
        assertEquals(0, emptyList.getSize()); // Размер пустого списка остается 0
    }
}