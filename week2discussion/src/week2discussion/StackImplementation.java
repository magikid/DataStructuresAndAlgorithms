package week2discussion;

public class StackImplementation<T> implements ArrayDeque<T> {
	private Object[] elements;
	private int numberElements;
	private int headTracker;
	
	public StackImplementation(){
		numberElements = 0;
		headTracker = 0;
		elements = new Object[numberElements];
	}

	@SuppressWarnings("unchecked")
	public T get(int index) throws Exception {
		checkIndex(index);
		return (T) elements[(headTracker + index) % elements.length];
	}
	
	public T get() throws Exception{
		return (T) get(0);
	}

	public void set(int index, T item) throws Exception{
		checkIndex(index);
		elements[(headTracker + index) % elements.length] = (T) item;
	}

	public void push(T item) {
		if(numberElements >= elements.length){
			resize();
		}
		
		elements[numberElements % elements.length] = (T) item;
		numberElements++;
	}
	
	@SuppressWarnings("unchecked")
	public T pop() throws Exception{
		T valToReturn = (T) get();
		set(0, null);
		numberElements--;
		headTracker++;
		return valToReturn;		
	}
	
	@SuppressWarnings("unchecked")
	private void resize(){
		Object[] resizedArray = new Object[Math.max(1, numberElements*2)];
		for(int k=0; k < numberElements; k++){
			resizedArray[k] = (T) elements[(headTracker + k) % elements.length];
		}
		elements = resizedArray;
	}
	
	private void checkIndex(int index) throws Exception{
		if(index > numberElements || index < 0){
			throw new Exception("You're dumb");
		}
	}
	
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		for(int k=0; k < elements.length; k++){		
			output.append(Integer.toString(k) + " " + elements[k % elements.length] + "\n");
		}
		return output.toString();
	}
}
