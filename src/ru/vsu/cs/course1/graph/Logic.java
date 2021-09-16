package ru.vsu.cs.course1.graph;

public class Logic {
    public static  int solution(Graph graph,  int N, int arr[][], int v){
        int n=0;
        Dijkstra test = new Dijkstra();
        int[] result = test.getShortestPaths(arr, v);
        for(int i=0; i< result.length; i++){
            if(result[i]>=N){
                n++;
            }
        }
        return n;
    }
    public static Graph create(int[][] arr){
        Graph gr=new AdjMatrixGraph();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j]!=0 && arr[i][j]!=-1 ) {
                    gr.addAdge(i, j);
                }
            }
        }
        return gr;
    }

}
