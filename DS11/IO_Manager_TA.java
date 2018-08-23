package DS11;

import java.io.*;
import java.nio.file.Paths;
// 파일을 읽어오는 클래스. 주석은 생략하겠습니다.
public class IO_Manager_TA {
    BufferedReader br;

    String filename = Paths.get("/Users/d.ruin/IdeaProjects/Class_Data_Structure/src/DS11/Random/1000000.txt").toString();
    // 저는 맥이라 파일경로를 다음과 같이 설정했습니다.
    StringBuffer sb;


    String readData() {
        try {
            br = new BufferedReader(new FileReader(filename));
            sb = new StringBuffer();
            int i;
            while ((i = br.read()) != -1) {
                sb.append((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}




