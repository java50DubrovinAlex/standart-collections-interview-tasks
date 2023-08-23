package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.MyStack;

class MyStackTest {
	
	MyStack <Integer> myStack = new MyStack<>();
	MyStack <Integer> myStackComp = new MyStack<>((a, b) -> b - a);
	@BeforeEach
	void setUp() throws Exception {
		
		myStack.push(10);
		myStack.push(2);
		myStack.push(3);
		myStack.push(0);
		myStack.push(12);
		
		myStackComp.push(10);
		myStackComp.push(2);
		myStackComp.push(3);
		myStackComp.push(0);
		myStackComp.push(12);
	}

	@Test
	void getMaxTest() {
		
		Integer res = myStack.getMax();
		Integer res1 = myStackComp.getMax();
		int expected = 12;
		int expected1 = 0;
		assertEquals(expected, res);
		assertEquals(expected1, res1);
		assertFalse(myStack.isEmpty());
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		assertTrue(myStack.isEmpty());
		assertThrows(NoSuchElementException.class, () -> myStack.getMax());
		assertThrows(NoSuchElementException.class,() -> myStack.pop());
	}

}
