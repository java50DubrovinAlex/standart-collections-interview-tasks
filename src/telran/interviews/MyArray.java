package telran.interviews;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * All methods of the class should have complexity O[1]
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	T setAll;
	LocalDateTime setAllTime;
	int size = 0;
	
	Map<Integer, Node<T>> myArray = new HashMap<>();
	
	
	
	static private class Node<T>{
		T value;
		LocalDateTime currentTime =  LocalDateTime.now();
		
	}
	
	
	
	public MyArray(int size) {
		this.size = size;
		for(int i = 0;i < size;i++) {
			this.myArray.put(i, new Node<>());
		}
		
		
	}
	/**
	 * sets all array's elements with a given value
	 * @param value
	 */
	public void setAll(T value) {
		setAll = value;
		this.setAllTime = LocalDateTime.now();
	}
	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		if(index > size) {
			throw new IndexOutOfBoundsException();
		}
		T res = null;
		if(myArray.get(index).currentTime.compareTo(this.setAllTime) > 0) {
			res = myArray.get(index).value;
		}else {
			res = this.setAll;
		}
		return res;
	}
	/**
	 * sets a given value at a given index
	 * throws IndexOutOfBoundsException in the case of wrong index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		myArray.get(index).currentTime = LocalDateTime.now();
		myArray.get(index).value = value;
	}
}