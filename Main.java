
public class Main {

	public static void main(String[] args) {	
		MyTreeMap<Integer, String> bst = new MyTreeMap<>();
		bst.put(435, "Bill");
		bst.put(565, "Jill");
		bst.put(335, "Dill");
		bst.put(725, "Mill");
		bst.put(935, "Sill");
		bst.put(165, "Phil");
		bst.put(235, "Gill");
		System.out.println(bst.put(625, "Hill"));
		System.out.println(bst.put(625, "Kill"));
		
		bst.remove​(165);
		//bst.delete(565);
		//bst.delete(725);
		//System.out.println(bst.containsKey​(165));
		//System.out.println(bst.get(565));
		//System.out.println(bst.get(435));
		
		bst.printTree();
		System.out.println(bst.keySet());
		System.out.println(bst.size());
		bst.clear();
		bst.printTree();
		System.out.println(bst.keySet());
		System.out.println(bst.size());


		
		
		
		/*
		 * MyTreeMap<String, Integer> tm = new MyTreeMap<>();
		 * 
		 * tm.put("Jack", 4237); tm.put("Mack", 237); tm.put("Back", 37); tm.put("Lack",
		 * 7);
		 * 
		 * tm.print();
		 */
	}
}

