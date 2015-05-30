package daily_165_hard_forest;

public class Optional<T> {
	private T value;
	
	public boolean isSet() {
		return value!=null;
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
