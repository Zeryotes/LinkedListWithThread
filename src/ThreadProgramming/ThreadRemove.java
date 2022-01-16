package ThreadProgramming;

public class ThreadRemove extends Thread {
	private SharedLinkedList list;

	
	public ThreadRemove(String name, SharedLinkedList list){
		super(name);
		this.list = list;
	}
	
	public void run() {
		Integer element = (int) (Math.random() * 10) + 1;
		list.remove(element);
	}
}