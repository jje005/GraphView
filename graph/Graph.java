package graph;


import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public static Queue drawSin(){
        Queue<Integer> que = new LinkedList<>();
        // 사인 그래프 데이터 생성
        for (int i = 0; i < 180; i+=30) {
            que.add((int)(Math.sin(i*Math.PI/180)));
        }
        return que;
    }
    public static Queue drawStep(){
        //step 1개씩 증가했다가 max도달 시 내려옴
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<=128;i++){
            que.add(i);
        }
        for(int i=127;i>=127;i--){
            que.add(i);
        }
        return que;
    }


    public static void main(String[] args) throws InterruptedException {
        for(int j= 0; j<10;j++){
            for(int i = 0; i<360; i+=30){
                System.out.println(Math.sin((i*Math.PI)/180));
            }
            Thread.sleep(2000);
            System.out.println("1번 주기\n\n");
        }
    }
}
