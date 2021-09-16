package ru.vsu.cs.course1.graph;

public class Dijkstra {
    public int[] getShortestPaths(int[][] adjMatrix, int n) {
        int [] result = new int [adjMatrix.length]; // Используется для хранения кратчайшего расстояния от вершины 0 до других вершин
        boolean [] used = new boolean [adjMatrix.length]; // Используется для определения, пройдена ли вершина
        used [n] = true; // Указывает, что вершина 0 пройдена
        for(int i = 0;i < adjMatrix.length;i++) {
            result[i] = adjMatrix[n][i];
            used[i] = false;
        }

        for(int i = 0;i < adjMatrix.length;i++) {
            int min = Integer.MAX_VALUE; // Используется для временного хранения кратчайшего расстояния от вершины 0 до i, инициализированного до максимального значения типа Integer
            int k = 0;
            for (int j = 0; j <adjMatrix.length; j ++) {// найти вершину с наименьшим расстоянием от вершины 0 до других вершин
                if(!used[j] && result[j] != -1 && min > result[j]) {
                    min = result[j];
                    k = j;
                }
            }
            used [k] = true; // Вершина с наименьшим расстоянием записывается как пройденная
            for (int j = 0; j <adjMatrix.length; j ++) {// Затем сравните расстояние от вершины 0 до других вершин с расстоянием после добавления средней вершины k, чтобы обновить кратчайшее расстояние
                if (! used [j]) {// когда вершина j не пройдена
                    // Прежде всего, вершина k к вершине j должна быть проходимой, в это время, когда расстояние от вершины 0 до вершины j больше, чем расстояние от вершины 0 до k до j или вершина 0 не может напрямую достичь вершины j, обновите вершину 0 до вершины j Кратчайшее расстояние
                    if(adjMatrix[k][j] != -1 && (result[j] > min + adjMatrix[k][j] || result[j] == -1))
                        result[j] = min + adjMatrix[k][j];
                }
            }
        }
        return result;
    }

}
