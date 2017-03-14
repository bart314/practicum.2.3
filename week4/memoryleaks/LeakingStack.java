package memoryleaks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class LeakingStack {
	/* 
	 This class will pass all tests and work just fine.
	 There is, however, lurking a memory leak somewhere.
	 Can you spot it? 
	*/
	
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	public LeakingStack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
		ensureCapacity();
		// post increment
		elements[size++] = e;
	}
	
	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		// pre decrement
		return elements[--size];
	}
	
	/**
	 * Ensure space for at least one more element, roughly
	 * doubling the capacity each time the array needs to grow.
	 */
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
}

/*
 As the stack grows and shrinks, the objects that were put off the stack
 (in the pop()-method) will not be garbage collected. This is because the 
 stack maintains obsolete references to them. This is known as unintentional
 object retention and is common in garbage-collected languages as (among
 many others) Java and C#.
 
 To eliminate the problem we should null out references to objects that are 
 no longer needed. 
 
 This should, however, be the exception and not the rule. Normally, the 
 garbage collection does the work for us and setting all objects to null the 
 moment you are done with it clutters the code. Only when you make a class that
 manages its own memory (such as this one) should you be aware of such memory
 leaks.
*/
