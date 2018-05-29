package recursion;

public class test {
//	int n ;
	public long g(int n){
		if(n == 1){
			return 0;
		}
		else if(n == 33){
			return 33;
		}
		else{
			return 2 * g(n/2) + 1;
		}
	}
}
