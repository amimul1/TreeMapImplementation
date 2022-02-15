import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MyTreeMapTest {

    @Test
    public void putTest1() {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        String result = map.get(1);
        assertEquals("a", result);
        System.out.println("Expected a, got " + result);
    }


    @Test
    public void putTest2() {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(284, "Sam");
        map.put(353, "Jan");
        map.put(593, "Ann");
        map.put(599, "Dan");
        map.put(768, "Stan");
        String result = map.get(593);
        assertEquals("Ann", result);
        System.out.println("Expected Ann, got " + result);
    }

    @Test
    public void putTest3() {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(284, "Sam");
        map.put(353, "Jan");
        map.put(593, "Ann");
        map.put(599, "Dan");
        map.put(768, "Stan");
        String result = map.get(768);
        assertEquals("Stan", result);
        System.out.println("Expected Stan, got " + result);
    }

    @Test
    public void containsKeyTest1(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(284, "Sam");
        map.put(353, "Jan");
        map.put(593, "Ann");
        map.put(599, "Dan");
        map.put(768, "Stan");
        boolean result = map.containsKey​(284);
        assertEquals(true, result);
        System.out.println("Expected true, got " + result);
    }

    @Test
    public void containsKeyTest2(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(534, "Sam");
        map.put(743, "Jan");
        map.put(1235, "Ann");
        map.put(901283, "Dan");
        map.put(12412, "Stan");
        boolean result = map.containsKey​(901283);
        assertEquals(true, result);
        System.out.println("Expected true, got " + result);
    }

    @Test
    public void containsKeyTest3(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(284, "Sam");
        map.put(353, "Jan");
        map.put(593, "Ann");
        map.put(599, "Dan");
        map.put(768, "Stan");
        boolean result = map.containsKey​(1);
        assertEquals(false, result);
        System.out.println("Expected false, got " + result);
    }

    @Test
    public void containsValueTest1(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(284, "Sam");
        map.put(353, "Jan");
        map.put(593, "Ann");
        map.put(599, "Dan");
        map.put(768, "Stan");
        boolean result = map.containsValue("Stan");
        assertEquals(true, result);
        System.out.println("Expected true, got " + result);
    }

    @Test
    public void containsValueTest2(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(534, "a");
        map.put(743, "ab");
        map.put(1235, "abc");
        map.put(901283, "abcd");
        map.put(12412, "abcdE");
        boolean result = map.containsValue("abcd");
        assertEquals(true, result);
        System.out.println("Expected true, got " + result);
    }

    @Test
    public void containsValueTest3(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(534, "Sam");
        map.put(743, "Jan");
        map.put(1235, "Ann");
        map.put(901283, "Dan");
        map.put(12412, "Stan");
        boolean result = map.containsValue("a");
        assertEquals(false, result);
        System.out.println("Expected false, got " + result);
    }

    @Test
    public void removeTest1(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(534, "Sam");
        map.put(743, "Jan");
        map.put(1235, "Ann");
        map.put(901283, "Dan");
        map.put(12412, "Stan");
        String result = map.remove​(534);
        assertEquals("Sam", result);
        System.out.println("Expected Sam, got " + result);
    }

    @Test
    public void removeTest2(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(534, "a");
        map.put(743, "ab");
        map.put(1235, "abc");
        map.put(901283, "abcd");
        map.put(12412, "abcdE");
        String result = map.remove​(901283);
        assertEquals("abcd", result);
        System.out.println("Expected abcd, got " + result);
    }

    @Test
    public void removeTest3(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(534, "a");
        map.put(743, "ab");
        map.put(1235, "abc");
        map.put(901283, "abcd");
        map.put(12412, "abcdE");
        String result = map.remove​(1);
        assertEquals(null, result);
        System.out.println("Expected null got " + result);
    }

    @Test
    public void sizeTest1(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(534, "a");
        map.put(743, "ab");
        map.put(1235, "abc");
        map.put(901283, "abcd");
        map.put(12412, "abcdE");
        int result = map.size();
        assertEquals(5, result);
        System.out.println("Expected 5 got " + result);
    }

    @Test
    public void sizeTest2(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        int result = map.size();
        assertEquals(4, result);
        System.out.println("Expected 4 got " + result);
    }

    @Test
    public void sizeTest3(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        int result = map.size();
        assertEquals(0, result);
        System.out.println("Expected 0, got " + result);
    }

    @Test
    public void isEmptyTest1(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        boolean result = map.isEmpty();
        assertEquals(true, result);
        System.out.println("Expected true, got " + result);
    }

    @Test
    public void inEmptyTest2(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(1,"a");
        boolean result = map.isEmpty();
        assertEquals(false, result);
        System.out.println("Expected false, got " + result);
    }

    @Test
    public void clearTest1(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(1,"a");
        MyTreeMap<Integer, String> result = map;
        map.clear();
        assertEquals(map, result);
        System.out.println("Expected empty, got " + result);
    }

    @Test
    public void keySetTest1(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        Set<Integer> result = map.keySet();
        Set<Integer> expected = new HashSet<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        assertEquals(expected , result);
        System.out.println("Expected [1, 2, 3, 4], got " + result);
    }

    @Test
    public void keySetTest2(){
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(534, "a");
        map.put(743, "ab");
        map.put(1235, "abc");
        map.put(901283, "abcd");
        map.put(12412, "abcdE");
        Set<Integer> result = map.keySet();
        Set<Integer> expected = new HashSet<Integer>();
        expected.add(534);
        expected.add(743);
        expected.add(1235);
        expected.add(901283);
        expected.add(12412);
        assertEquals(expected , result);
        System.out.println("Expected [534, 743, 1235, 901283, 12412], got " + result);
    }

    
    @Test
    public void test1() {
		System.out.println("Test " + 1 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		System.out.println("Put (4, \"Bill\")");
		System.out.println("Previously " + mtm.put(4, "Bill"));
		
		System.out.println("Put (5, \"Jill\")");
		System.out.println("Previously " + mtm.put(5, "Jill"));
		
		System.out.println("Put (3, \"Dill\")");
		System.out.println("Previously " + mtm.put(3, "Dill"));
		
		System.out.println("Put (7, \"Mill\")");
		System.out.println("Previously " + mtm.put(7, "Mill"));
		
		System.out.println("Put (9, \"Sill\")");
		System.out.println("Previously " + mtm.put(9, "Sill"));
		
		System.out.println("Put (1, \"Phil\")");
		System.out.println("Previously " + mtm.put(1, "Phil"));
		
		System.out.println("Put (2, \"Gill\")");
		System.out.println("Previously " + mtm.put(2, "Gill"));
		
		System.out.println("Put (6, \"Hill\")");
		System.out.println("Previously " + mtm.put(6, "Hill"));
		
		System.out.println("Put (8, \"Runt\")");
		System.out.println("Previously " + mtm.put(8, "Runt"));
		
		System.out.println("Put (8, \"Tree\")");
		System.out.println("Previously " + mtm.put(8, "Tree"));
		
		mtm.printTree();		
	}
	
	@Test
	public void test2() {
		System.out.println("Test " + 2 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		mtm.put(4, "Bill");
		mtm.put(8, "Runt");
		
		boolean result = mtm.containsKey​(8);
		assertEquals(true , result);
		System.out.println("Expected true, got " + result);
	}
	
	@Test
	public void test3() {
		System.out.println("Test " + 3 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		mtm.put(4, "Bill");
		mtm.put(8, "Runt");
		
		boolean result = mtm.containsKey​(80);
		assertEquals(false , result);
		System.out.println("Expected false, got " + result);
	}
	
	@Test
	public void test4() {
		System.out.println("Test " + 4 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		mtm.put(4, "Bill");
		mtm.put(8, "Runt");
		
		boolean result = mtm.containsValue("Bob");
		assertEquals(false , result);
		System.out.println("Expected false, got " + result);
	}
	
	@Test
	public void test5() {
		System.out.println("Test " + 5 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		mtm.put(4, "Bill");
		mtm.put(8, "Runt");
		
		boolean result = mtm.containsValue("Bill");
		assertEquals(true , result);
		System.out.println("Expected true, got " + result);
	}
	
	@Test
	public void test6() {
		System.out.println("Test " + 6 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		mtm.printTree();		
		boolean result = mtm.isEmpty();
		assertEquals(true , result);
		System.out.println("Expected true, got " + result);
	}
	
	@Test
	public void test7() {
		System.out.println("Test " + 7 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		boolean result = mtm.containsValue("Bob");
		assertEquals(false , result);
		System.out.println("Expected false, got " + result);
	}

	@Test
	public void test8() {
		System.out.println("Test " + 8 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		mtm.put(4, "Bill");
		mtm.put(5, "Jill");
		mtm.put(3, "Dill");
		mtm.put(7, "Mill");
		mtm.put(9, "Sill");
		mtm.put(1, "Phil");
		mtm.put(2, "Gill");
		mtm.put(6, "Hill");
		mtm.put(8, "Runt");
		
		mtm.clear();
		mtm.printTree();		
		boolean result = mtm.isEmpty();
		assertEquals(true , result);
		System.out.println("Expected true, got " + result);
		mtm.put(4, "Bill");
		mtm.printTree();
		
	}
	
	@Test
	public void test9() {
		System.out.println("Test " + 9 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		mtm.put(4, "Bill");
		mtm.put(5, "Jill");
		mtm.put(3, "Dill");
		mtm.put(7, "Mill");
		mtm.put(9, "Sill");
		mtm.put(1, "Phil");
		mtm.put(2, "Gill");
		mtm.put(6, "Hill");
		mtm.put(8, "Runt");
		
		System.out.println(mtm.get(4));
		System.out.println(mtm.get(5));
		System.out.println(mtm.get(3));
		System.out.println(mtm.get(7));
		
		System.out.println(mtm.get(9));
		System.out.println(mtm.get(1));
		System.out.println(mtm.get(2));
		System.out.println(mtm.get(6));
		System.out.println(mtm.get(8));
		System.out.println(mtm.keySet());
		
	}
	
	@Test
	public void test10() {
		System.out.println("Test " + 10 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		mtm.put(4, "Bill");
		mtm.put(5, "Jill");
		
		System.out.println("Removed " + mtm.remove​(4));
		System.out.println("Removed " + mtm.remove​(5));
		System.out.println("Removed " + mtm.remove​(6));
		
		System.out.println(mtm.keySet());
		
	}
	
	@Test
	public void test11() {
		System.out.println("Test " + 11 + "\n");
		MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
		mtm.put(4, "Bill");
		mtm.put(5, "Jill");
		mtm.put(6, "KillBill");
		
		System.out.println("Removed " + mtm.remove​(4));
		System.out.println(mtm.keySet());
		System.out.println(mtm.size());
		
	}

}