package recursion;

public class findMax {
	public int findMax(int [] A, int left, int right){
		int maxOfSubPart ; 
		if (left == right)
			return A[left] ; 
		else {
			maxOfSubPart = findMax (A, left+1, right) ; 
			if (A[left] >= maxOfSubPart)
				return A[left] ; 
			else
				return maxOfSubPart ;
		}
	}
}
