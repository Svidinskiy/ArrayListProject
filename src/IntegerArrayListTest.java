import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerArrayListTest {
    private IntegerList list;

    @Before
    public void setup() {
        list = new IntegerArrayList();
    }

    @Test
    public void testAdd() {
        list.add(10);
        list.add(20);
        list.add(30);

        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(10), list.get(0));
        Assert.assertEquals(Integer.valueOf(20), list.get(1));
        Assert.assertEquals(Integer.valueOf(30), list.get(2));
    }

    @Test
    public void testAddAtIndex() {
        list.add(10);
        list.add(30);
        list.add(1, 20);

        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(10), list.get(0));
        Assert.assertEquals(Integer.valueOf(20), list.get(1));
        Assert.assertEquals(Integer.valueOf(30), list.get(2));
    }

    @Test
    public void testSet() {
        list.add(10);
        list.add(20);

        list.set(1, 30);

        Assert.assertEquals(2, list.size());
        Assert.assertEquals(Integer.valueOf(10), list.get(0));
        Assert.assertEquals(Integer.valueOf(30), list.get(1));
    }

    @Test
    public void testRemoveByItem() {
        list.add(10);
        list.add(20);

        list.remove(Integer.valueOf(10));

        Assert.assertEquals(1, list.size());
        Assert.assertEquals(Integer.valueOf(20), list.get(0));
    }

    @Test
    public void testRemoveByIndex() {
        list.add(10);
        list.add(20);

        list.remove(0);

        Assert.assertEquals(1, list.size());
        Assert.assertEquals(Integer.valueOf(20), list.get(0));
    }

    @Test
    public void testContains() {
        list.add(10);
        list.add(20);

        Assert.assertTrue(list.contains(10));
        Assert.assertTrue(list.contains(20));
        Assert.assertFalse(list.contains(30));
    }

    @Test
    public void testIndexOf() {
        list.add(10);
        list.add(20);
        list.add(10);

        Assert.assertEquals(0, list.indexOf(10));
        Assert.assertEquals(1, list.indexOf(20));
        Assert.assertEquals(-1, list.indexOf(30));
    }

    @Test
    public void testLastIndexOf() {
        list.add(10);
        list.add(20);
        list.add(10);

        Assert.assertEquals(2, list.lastIndexOf(10));
        Assert.assertEquals(1, list.lastIndexOf(20));
        Assert.assertEquals(-1, list.lastIndexOf(30));
    }

    @Test
    public void testGet() {
        list.add(10);
        list.add(20);

        Assert.assertEquals(Integer.valueOf(10), list.get(0));
        Assert.assertEquals(Integer.valueOf(20), list.get(1));
    }

    @Test
    public void testSize() {
        Assert.assertEquals(0, list.size());

        list.add(10);
        list.add(20);

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(list.isEmpty());

        list.add(10);

        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.add(10);
        list.add(20);

        list.clear();

        Assert.assertEquals(0, list.size());
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        list.add(10);
        list.add(20);

        Integer[] array = list.toArray();

        Assert.assertArrayEquals(new Integer[]{10, 20}, array);
    }
    @Test
    public void testSort() {
        list.add(30);
        list.add(10);
        list.add(20);

        list.sort();

        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(10), list.get(0));
        Assert.assertEquals(Integer.valueOf(20), list.get(1));
        Assert.assertEquals(Integer.valueOf(30), list.get(2));
    }

    @Test
    public void testBinarySearch() {
        list.add(10);
        list.add(20);
        list.add(30);

        Assert.assertEquals(0, list.binarySearch(10));
        Assert.assertEquals(1, list.binarySearch(20));
        Assert.assertEquals(2, list.binarySearch(30));
        Assert.assertEquals(-1, list.binarySearch(40));
    }
}
