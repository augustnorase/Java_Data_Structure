package DS01;

public class Debug_Main {
	public static void main(String[] args) {
		
		System.out.println("Example1");
		DebugExample ex1 = new DebugExample();
		int [] ex1Array = ex1.array();
		
		for(int i = 0; i < ex1Array.length; i++){
			System.out.println(ex1Array[i]);
		}
		
		System.out.println("\nExample2");
		
		DebugExample ex2 = new DebugExample(3);
		int[] ex2Array = ex2.array();
		
		for(int i = 0; i < ex2Array.length; i++){
			System.out.println(ex2Array[i]);
		}
		}
}
