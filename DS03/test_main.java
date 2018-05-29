package DS03;

public class test_main {
	public static void main(String[] args) {
		SortedArrayBag Bag = new SortedArrayBag(100);
		SortedLinkedBag LinkedBag = new SortedLinkedBag(100);
		Bag.add(20);
		Bag.add(18);
		Bag.add(17);
		Bag.add(15);
		Bag.add(26);
		Bag.add(22);
		Bag.add(70);
		Bag.add(14);
		Bag.add(1);
		Bag.print();
		System.out.println();
		System.out.println();
		
		LinkedBag.add(30);
		LinkedBag.add(40);
		LinkedBag.add(50);
		LinkedBag.add(20);
		LinkedBag.add(17);
		LinkedBag.add(32);
		LinkedBag.add(100);
		LinkedBag.add(16);
		LinkedBag.print();
	}
}
