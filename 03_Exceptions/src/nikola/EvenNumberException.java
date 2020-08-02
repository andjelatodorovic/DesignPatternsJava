package nikola;

public class EvenNumberException extends Exception {
	private static final long serialVersionUID = 1L;

	int x;

	public EvenNumberException(int x) {
		super("broj " + x);
	}
	
	
	
}
