package telran.interviews;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

//Requirement: all methods must have complexity O[1]
public class MyStack<T> {
	class Entry<E> {
		T currentMax;
		T value;

	}

	T maxValue = null;
	LinkedList<T> myStack = new LinkedList<>();
	Comparator<T> comp = null;

	public MyStack(Comparator<T> comp) {
		this.comp = comp;

	}

	@SuppressWarnings("unchecked")
	public MyStack() {
		this.comp = (Comparator<T>) Comparator.naturalOrder();
	}

	@SuppressWarnings("unchecked")
	public void push(T element) {
		Entry<T> elm = new Entry<T>();
		if (this.isEmpty()) {
			elm.currentMax = element;
			elm.value = element;
			maxValue = element;
			myStack.addLast((T) elm);
		} else {
			if (comp.compare(element, maxValue) > 0) {
				maxValue = element;
				elm.currentMax = element;

			}
			elm.currentMax = maxValue;
			elm.value = element;
			myStack.addLast((T) elm);
		}

	}

	public T pop() {
		if (this.myStack == null) {
			throw new NoSuchElementException("Stack is empty!");
		}
		return myStack.removeLast();
	}

	public boolean isEmpty() {

		return myStack.isEmpty();
	}

	public T getMax() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty!");
		}
		return maxValue;

	}
}