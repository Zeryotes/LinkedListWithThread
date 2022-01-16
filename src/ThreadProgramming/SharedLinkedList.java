package ThreadProgramming;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedLinkedList {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private Lock lock;
	
	public SharedLinkedList(){
		lock = new ReentrantLock(true);
	}
	
	public void search(Integer element){
		int search;
		int duration = (int)(Math.random() * 60) + 1;
		
		System.out.println("Thread [" + Thread.currentThread().getName() +
				"] searching for element " + element);
		
		try {
			Thread.sleep(duration * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		search = list.indexOf(element);		
		
		if(search == -1) {
			System.out.println("Thread [" + Thread.currentThread().getName() + "] and has not found " + element + ".");
		} else {
			System.out.println("Thread [" + Thread.currentThread().getName() + "] founded " + element + " in index " + search + ".");
		}
	}
	
	public void print() {
		System.out.println("List: " + list);
	}
	
	public void insert(Integer element) {
		lock.lock();
		
		boolean isInserted = false;
		
		System.out.println("Thread [" + Thread.currentThread().getName() +
				"] inserting element " + element);
		
		try {
			Thread.sleep(5000);
			isInserted = list.add(element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(isInserted == true) {
			System.out.println("Thread [" + Thread.currentThread().getName() + "] has sucesfully inserted " + element + ".");
		} else {
			System.out.println("Thread [" + Thread.currentThread().getName() + "] has failed to insert " + element + ".");
		}
		lock.unlock();
	}
	
	public void remove(Integer element) {
		lock.lock();
		
		boolean isRemoved = false;
		
		System.out.println("Thread [" + Thread.currentThread().getName() +
				"] removing element " + element);
				
		try {
			Thread.sleep(10000);
			isRemoved = list.remove(element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(isRemoved == true) {
			System.out.println("Thread [" + Thread.currentThread().getName() + "] has sucesfully removed " + element + ".");
		} else {
			System.out.println("Thread [" + Thread.currentThread().getName() + "] has failed to remove " + element + ".");
		}
		lock.unlock();
	}
}
