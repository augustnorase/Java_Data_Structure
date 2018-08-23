package DS12;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Graph {
    private int[][] edge;   // 그래프 연결 유무를 위한 변수
    private int size;   // 사이즈를 저장할 변수

    public Graph(int size) {    // 그래프의 생성자. 사이즈와 사이즈를 통해 edge를 생성
        this.size = size;
        this.edge = new int[size][size];
    }

    public int size(){
        return size;
    }   // 사이즈의 게터

    public void addEdge(int src, int dst) { // edge를 추가하는 메소드
      // TODO
        if(src >= size || dst >= size){ // 만약 입력된 변수가 size보다 클 경우에는
            System.out.println("그래프에 없는 접점입니다.");   // 안내문 출력
            return ;    // 종료
        }
        edge[src][dst] = 1; // 그 이외의 경우에는 해당 위치에 1을 넣어줌
        edge[dst][src] = 1; // 그 반대의 경우도 마찬가지
    }

    public void removeEdge(int src, int dst) {  // edge에서 제거하는 메소드
      // TODO
        if(src >= size || dst >= size){ // add와 같은 방법
            System.out.println("그래프에는 없는 접점입니다.");
            return;
        }
        edge[src][dst] = 0; // add와 마찬가지로 해당 위치에 0을 넣어줌
        edge[dst][src] = 0; // 그 반대도 마찬가지
    }

    public void readGraph(File file) throws IOException {   // 그래프 파일을 읽어오는 메소드는 생략하겠습니다
        if (file == null) {
            String currentPath = Paths.get(".", "src").toString();
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File(currentPath));
            jFileChooser.showOpenDialog(new JFrame());
            file = jFileChooser.getSelectedFile();
        }
        if (file != null) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            this.size = Integer.parseInt(br.readLine());
            this.edge = new int[size][size];
            for (int i = 0; i < size; ++i) {
                String[] temps = br.readLine().split(" ");
                for (int j = 0; j < temps.length; ++j) {
                    edge[i][j] = Integer.parseInt(temps[j]);
                }
            }
            System.out.println("File selected!");
        } else {
            System.out.println("No file Selected");
        }
    }
    public void print() {   // 그래프를 출력하는 메소드
        System.out.println("This Graph ::\n");  // 안내문 출력
        for (int i = 0; i < size; ++i) {    // 각 그래프는 [i][j]에서 줄을 나타내는 [i]와 각 줄의 요소를 나타내는 [j]의 방식으로 나타나기 때문에
            // 다음과 같은 2중 반복문으로 실행되어야 함
            for (int j = 0; j < size; ++j) {
                System.out.print(edge[i][j]+" ");   // 각 요소들 출력
            }
            System.out.println();   // 다음 줄로 넘어가기 위해 println으로 출력
        }
        System.out.println();   // 반복문 뒤 한 칸 넣어줌
    }

    public void bfs(int vertex) {   // 그래프 내부 요소들을 출력하기 위한 bfs 메소드. 큐로 실현됨
      // TODO
        boolean[] c = new boolean[size];    // 들렀는지 여부를 저장하기 위해 boolean 배열을 선언.
        // 크기는 들어간 수만큼 되어야 하기 때문에 사이즈로 넣어줄 것
        Queue<Integer> q = new LinkedList<>();  // 큐 선언
        int n = size - 1;   // 0부터 시작하기 때문에 1을 빼줄 것
        
        q.add(vertex);  // 큐에 입력된 vertex를 넣을 것
        c[vertex] = true;   // 들렸다는 걸 표현하기 위해 c에 저장하고 true 선언
        
        while(!q.isEmpty()){    // 큐가 빌 때까지
            
            vertex = q.poll();  // 큐에서 빼낸 것을 vertex에 넣고
            System.out.print(vertex + " -> ");  // 그것을 출력
            
            for(int i = 0; i <= n; i++){    // 0에서 n까지 반복하며
                if(edge[vertex][i] == 1 && !c[i]){  // 만약 해당하는 위치에 1이 있다면(연결된 노드) and 들르지 않은 요소라면
                    q.add(i);   // 큐에 해당 요소를 넣어주고
                    c[i] = true;    // 들렸다는 것을 넣어줌
                }
            }
        }
        
    }

    public void dfs(boolean[] c, int vertex) {  // 그래프 내부 요소들을 출력하기 위한 bfs 메소드. 재귀 방식으로 실현
        // 기본적인 방법은 bfs와 동일
      // TODO
        int n = size - 1;   // 0부터 시작하기 때문에 1 빼줄 것
        c[vertex] = true;   // 들렸다는 걸 확인하기 위해 배열 c에 true 저장
        System.out.print(vertex + " -> ");  // vertex 출력
        for(int i = 0; i <= n; i++){    // 0부터 n까지 반복하며
            if(edge[vertex][i] == 1 && !c[i]){  // 해당하는 위치에 1이 있다면 and 들르지 않은 요소라면
                dfs(c, i);  // 재귀 방식으로 호출해서 출력할 것
            }
        }

    }

    public void kruskalAlgorithm() {
      // TODO
    }

    public void primAlgorithm(int start){
      // TODO
    }
}
