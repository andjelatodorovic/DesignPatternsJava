package nikola;

public class MainClass {

	public static void test1() {
		int x, y, z = 0;
		int[] a = new int[10];
		x = 3;
		y = 1;
		
		try {
			z = x / y;
			a[11] = 1;
			System.out.println("posle");
			//throw new ArithmeticException();
		} catch (ArithmeticException e) {
			System.out.println("Desio se exception");
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index out of bounds");
		} finally {
			System.out.println("finally");
		}
		
		System.out.println(z);
	}
	
	public static void test2() throws MyException {
		test3();
	}
	
	public static void test3() throws MyException {
		throw new MyException("hej");
	}
	
	public static int F(int x) throws EvenNumberException {
		if (x % 2 == 0) {
			throw new EvenNumberException(x);
		}
		return x / (2 * (x % 2));
	}
	
	public static void main(String[] args) {
		//test1();
		/*
		try {
			test2();
		} catch (MyException e) {
			e.printStackTrace();
		}
		*/
		
		int x = 6;
		try {
			System.out.println(F(x));
		} catch (EvenNumberException e) {
			e.printStackTrace();
			System.out.println("Unesite neparan broj");
		}
	}
	
}
