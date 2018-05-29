package DS03;

public class MainClass_03_201300402 {
    public static void main(String[] args){
        PerformanceMeasurementInterface test = new PerformanceMeasurement();	//	PerformanceMeasurement 생성 

        // 해당 클래스 내에 들어있는 메소드 실행 
        test.generateData();	
        test.testSortedArrayBag();
        test.testSortedLinkedBag();
    }
}
