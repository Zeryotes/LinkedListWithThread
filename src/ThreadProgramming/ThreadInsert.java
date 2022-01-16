package ThreadProgramming;

public class ThreadInsert extends Thread {
	private SharedLinkedList list;
	
	public ThreadInsert(String name, SharedLinkedList list){
		super(name);
		this.list = list;
	}
	
	public void run() {
		Integer element = (int) (Math.random() * 10) + 1;
		list.insert(element);
	}
}
