package DS03;

import java.util.Random;

public class PerformanceMeasurement implements PerformanceMeasurementInterface{
	private SortedArrayBag arrayBag;	// SortedArrayBag 클래스의 변수로 arrayBag 선언 
	private SortedLinkedBag linkedBag;	// SortedLinkedBag 클래스의 변수로 linkedBag 선언 
	private Random rand;	// 위에서 import된 Random 모듈 사용을 위해 rand 선언 
	private int[] data;	// 정수 배열 data 선언 
	private long startTime, endTime, insertingTime, findingMaxTime;	// 64비트 정수 선언 
	
	public void generateData(){	// 
		data = new int[5000];	// data는 5000개의 넓이를 가진 배열로 선언 
		rand = new Random();	// 난수 생성을 하는 객체 생성 
		rand.setSeed(System.currentTimeMillis());	// 현재 시간을 구함 
		for(int i = 0; i < data.length; i++){	// 0부터 데이터의 길이만큼 
			data[i] = rand.nextInt();	// 난수를 생성해 배열에 넣음 
		}
	}
	
	public void testSortedArrayBag(){	// SortedArrayBag에 대해서 
		System.out.println("[Sorted Array]");	// 안내문 출력 
		
		for(int i = 0; i < 5; i++){	
			arrayBag = new SortedArrayBag(5000);	// 크기는 5000으로 
			startTime = System.nanoTime();	// 시작 시간 설정 
			for(int j = 0; j < (i+1) * 1000; j++){	// arrayBag에 하나씩 넣어주기 위한 반복문 
				arrayBag.add(data[j]);	// 하나씩 삽입한다 
			}
			endTime = System.nanoTime();	// 끝나는 시간 
			insertingTime = endTime - startTime;	// 끝나는 시간 - 시작 시간을 빼면 걸린 시간 
			
			startTime = System.nanoTime();	// 시작 시간 
			arrayBag.max((i + 1) * 1000);	// 최대값 찾기 
			endTime = System.nanoTime();	// 끝나는 시간 
			findingMaxTime = endTime - startTime;	// 걸린 시간 
			
			System.out.println("크기 " + (i + 1) * 1000 + ",\t삽입하기 " + insertingTime + ",\t최대값 찾기 " + findingMaxTime);
		}
	}
	
	public void testSortedLinkedBag() {
	      System.out.println("\n[Sorted Linked]");
	      
	      for(int i=0; i<5; i++) {	
	         linkedBag = new SortedLinkedBag(5000);	// 크기는 5000으로 
	         startTime = System.nanoTime();	// 시작 시간 
	         for (int j=0; j<(i+1)*1000;j++) {	// linkedBag에 하나씩 넣어주기 위한 반복문 
	            linkedBag.add(data[j]);	// 하나씩 삽입 
	         }
	         endTime = System.nanoTime();	// 끝나는 시간 
	         insertingTime = endTime - startTime;	// 걸린 시간 
	         
	         startTime = System.nanoTime();	// 시작 시간 
	         linkedBag.max((i+1)*1000);	// 최대값 찾기 
	         endTime = System.nanoTime();	// 끝나는 시간 
	         findingMaxTime = endTime - startTime;	// 걸린 시간 
	         
	         System.out.println("크기 " + (i+1)*1000 + ", \t삽입하기 " + insertingTime + ",\t최대값 찾기 " + findingMaxTime);
	      }
	   }
}
