package ThreadProgramming;

public class ThreadSearch extends Thread {
	private SharedLinkedList list;
	
	public ThreadSearch(String name, SharedLinkedList list){
		super(name);
		this.list = list;
	}
	
	public void run() {
		Integer element = (int) (Math.random() * 10) + 1;
		list.search(element);
	}
}
