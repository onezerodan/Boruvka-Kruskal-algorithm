package model;

import java.util.List;

public class Graph {
    int totalNodes;
    int totalEdges;
    List<Edge> edges;

    public Graph(int totalNodes, int totalEdges, List<Edge> edges) {
        this.totalNodes = totalNodes;
        this.totalEdges = totalEdges;
        this.edges = edges;
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public void setTotalNodes(int totalNodes) {
        this.totalNodes = totalNodes;
    }

    public int getTotalEdges() {
        return totalEdges;
    }

    public void setTotalEdges(int totalEdges) {
        this.totalEdges = totalEdges;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "totalNodes=" + totalNodes +
                ", totalEdges=" + totalEdges +
                ", edges=" + edges +
                '}';
    }
}
