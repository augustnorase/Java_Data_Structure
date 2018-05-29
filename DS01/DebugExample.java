package DS01;

public class DebugExample {
	private int _value;
	private int [] _array = new int[4];
	
	public DebugExample(){
		this._value = 0;
		assignArray();
	}
	
	public DebugExample(int input){
		this._value = input;
		assignArray();
	}
	
	public int[] array(){
		return this._array;
	}
	
	private void assignArray(){
		for(int i = 0; i < this._array.length; i++){
			this._array[i] = _value + i;
		}
	}
}
