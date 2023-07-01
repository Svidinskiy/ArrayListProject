
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private StringList list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList();
    }

    @Test
    public void testAddAndGet() {
        list.add("Hello");
        list.add("World");
        list.add("!");

        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
        assertEquals("!", list.get(2));
    }

    @Test
    public void testAddAtIndex() {
        list.add("Hello");
        list.add("World");
        list.add(1, "beautiful");

        assertEquals("Hello", list.get(0));
        assertEquals("beautiful", list.get(1));
        assertEquals("World", list.get(2));
    }

    @Test
    public void testSet() {
        list.add("Hello");
        list.add("World");

        assertEquals("World", list.set(1, "beautiful"));
        assertEquals("beautiful", list.get(1));
    }

    @Test
    public void testRemove() {
        list.add("Hello");
        list.add("World");
        list.add("!");

        assertEquals("World", list.remove(1));
        assertFalse(list.contains("World"));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveByItem() {
        list.add("Hello");
        list.add("World");
        list.add("!");

        assertEquals("World", list.remove("World"));
        assertFalse(list.contains("World"));
        assertEquals(2, list.size());
    }

    @Test
    public void testContains() {
        list.add("Hello");
        list.add("World");
        list.add("!");

        assertTrue(list.contains("Hello"));
        assertTrue(list.contains("!"));
        assertFalse(list.contains("Java"));
    }

    @Test
    public void testIndexOf() {
        list.add("Hello");
        list.add("World");
        list.add("World");

        assertEquals(1, list.indexOf("World"));
        assertEquals(-1, list.indexOf("Java"));
    }

    @Test
    public void testLastIndexOf() {
        list.add("Hello");
        list.add("World");
        list.add("World");

        assertEquals(2, list.lastIndexOf("World"));
        assertEquals(-1, list.lastIndexOf("Java"));
    }

    @Test
    public void testEquals() {
        StringList otherList = new ArrayList();
        otherList.add("Hello");
        otherList.add("World");
        otherList.add("!");

        list.add("Hello");
        list.add("World");
        list.add("!");

        assertTrue(list.equals(otherList));
        assertTrue(otherList.equals(list));

        otherList.remove(1);
        assertFalse(list.equals(otherList));
        assertFalse(otherList.equals(list));
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());

        list.add("Hello");
        assertEquals(1, list.size());

        list.add("World");
        assertEquals(2, list.size());

        list.remove(0);
        assertEquals(1, list.size());

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add("Hello");
        assertFalse(list.isEmpty());

        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.add("Hello");
        list.add("World");

        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertFalse(list.contains("Hello"));
        assertFalse(list.contains("World"));
    }

    @Test
    public void testToArray() {
        list.add("Hello");
        list.add("World");
        list.add("!");

        String[] expectedArray = {"Hello", "World", "!"};
        assertArrayEquals(expectedArray, list.toArray());
    }

}
