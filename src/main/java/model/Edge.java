package model;

public class Edge implements Comparable<Edge>{
    private int src;
    private int dst;
    private int weight;

    @Override
    public String toString() {
        return "Edge{" +
                "firstVertex=" + src +
                ", secondVertex=" + dst +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(weight, o.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return ((src == edge.src && dst == edge.dst) || (src == edge.dst && dst == edge.src)) && weight == edge.weight;
    }



    public Edge(int src, int dst, int weight) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDst() {
        return dst;
    }

    public void setDst(int dst) {
        this.dst = dst;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
