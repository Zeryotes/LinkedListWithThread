package ThreadProgramming;

public class Main {
	
	public static final int NUM_INSERT = 3;
	public static final int NUM_REMOVE = 3;
	public static final int NUM_SEARCH = 3;
	
	public static void main(String[] args) {
		SharedLinkedList list = new SharedLinkedList();
		
		ThreadInsert i[] = new ThreadInsert[NUM_INSERT];
		ThreadRemove r[] = new ThreadRemove[NUM_REMOVE];
		ThreadSearch s[] = new ThreadSearch[NUM_SEARCH];
		
		for(int index = 0; index < NUM_INSERT; index++) {
			i[index] = new ThreadInsert("Insert" + (index+1), list);
		}
		
		for(int index = 0; index < NUM_REMOVE; index++) {
			r[index] = new ThreadRemove("Remove" + (index+1), list);
		}
		
		for(int index = 0; index < NUM_SEARCH; index++) {
			s[index] = new ThreadSearch("Search" + (index+1), list);
		}

		for(ThreadInsert item : i) {
			item.start();
		}
		
		for(ThreadSearch item : s) {
			item.start();
		}
		
		for(ThreadRemove item : r) {
			item.start();
		}
		
		try {
			for(ThreadInsert item : i) {
				item.join();
			}
			
			for(ThreadSearch item : s) {
				item.join();
			}
			
			for(ThreadRemove item : r) {
				item.join();
			}
		} catch(InterruptedException  e) {
			e.printStackTrace();
		}
		
		list.print();
		System.out.println("Thread main finalized.");
	}

}
