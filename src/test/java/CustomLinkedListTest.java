
import org.example.CustomLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new CustomLinkedList<>();
    }

    @Test
    public void testAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testAddAtIndex() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(1, 3);
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testBubbleSort() {
        list.clear();
        list.add(3);
        list.add(1);
        list.add(2);
        list.bubbleSort();
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testBinarySearch() {
        list.clear();
        list.add(3);
        list.add(1);
        list.add(2);
        list.bubbleSort();
        assertEquals(0, list.binarySearch(1));
        assertEquals(1, list.binarySearch(2));
        assertEquals(2, list.binarySearch(3));
    }
}
