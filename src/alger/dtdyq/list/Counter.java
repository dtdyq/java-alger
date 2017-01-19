package alger.dtdyq.list;
public class Counter {
	private static final String DEFAULT_NAME="counter";
	private int count;
	private String name;
	/**
	 * create a counter with default name
	 */
	public Counter(){
		this.name=DEFAULT_NAME;
	}
	/**
	 * create a counter with specified name
	 * @param name
	 */
	public Counter(String name){
		this.name=name;
	}
	/**
	 * call this method to make counter plus one
	 */
	public void increase(){
		this.count++;
	}
	/**
	 * merge the specified Counter to this counter,and this counter's value equals to
	 * before value plus specified Counter's value
	 * @param Counter
	 */
	public boolean join(Counter counter){
		if(counter==null){
			return false;
		}
		this.count+=counter.count;
		return true;
	}
	/**
	 * call this method to make counter minus one
	 */
	public void decrease(){
		this.count--;
	}
	@Override
	public String toString(){
		return this.name+": "+this.count;
	}

}
