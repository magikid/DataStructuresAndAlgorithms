package week2discussion;

public interface ArrayDeque<T> {
	public T get(int index) throws Exception;
	public void set(int index, T item) throws Exception;
	public void push(T item) throws Exception;
	public T pop() throws Exception;
}
