import org.example.CustomArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CustomArrayListTest {

    private CustomArrayList customList;

    @BeforeEach
    public void setup() {
        customList = new CustomArrayList();
    }

    @Test
    public void testAdd() {
        customList.add("Element 1");
        customList.add("Element 2");

        assertEquals("Element 1", customList.get(0));
        assertEquals("Element 2", customList.get(1));
    }

    @Test
    public void testAddMultipleElements() {
        customList.addMultipleElements("A,B,C");

        assertEquals("A", customList.get(0));
        assertEquals("B", customList.get(1));
        assertEquals("C", customList.get(2));
    }

    @Test
    public void testAddAtIndex() {
        customList.add("Element 1");
        customList.add("Element 2");
        customList.add("Element 3");

        customList.add(1, "Inserted Element");

        assertEquals("Inserted Element", customList.get(1));
        assertEquals("Element 2", customList.get(2));
    }

    @Test
    public void testRemove() {
        customList.add("Element 1");
        customList.add("Element 2");
        customList.add("Element 3");

        customList.remove(1);

        assertEquals("Element 1", customList.get(0));
        assertEquals("Element 3", customList.get(1));
        assertEquals(2, customList.list.size());
    }

    @Test
    public void testSort() {
        customList.add("Z");
        customList.add("A");
        customList.add("M");

        customList.sort();

        assertEquals("A", customList.get(0));
        assertEquals("M", customList.get(1));
        assertEquals("Z", customList.get(2));
    }

    @Test
    public void testQuickSort() {
        customList.add("Z");
        customList.add("A");
        customList.add("M");

        customList.quickSort();

        assertEquals("A", customList.get(0));
        assertEquals("M", customList.get(1));
        assertEquals("Z", customList.get(2));
    }
}