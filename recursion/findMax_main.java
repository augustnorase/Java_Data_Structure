package recursion;

public class findMax_main {
	public static void main(String[] args) {
		int [] A = {32, 15, 142, 21, 32};
		int max;
		findMax recursion = new findMax();
		max = recursion.findMax(A, 0, 4);
		System.out.println(max);
	}
}
