package alghorithm;

import model.Graph;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    private List<DisjointSet> nodes;

    public Operations(Graph graph) {
        initDisjointSets(graph.getTotalNodes());
    }


    // Initialize all nodes parents by themselves
    public void initDisjointSets(int totalNodes) {
        List<DisjointSet> nodes = new ArrayList<>(totalNodes+1);
        nodes.add(0, new DisjointSet(0));
        for (int i = 1; i < totalNodes + 1; i++) {
            nodes.add(new DisjointSet(i));
        }
        this.nodes = nodes;
    }


    // Recursively search parent of the node
    public Integer find(Integer node) {
        Integer parent = nodes.get(node).getParentNode();
        if (parent.equals(node)) {
            return node;
        } else {
            return find(parent);
        }
    }

    // Put one endpoint to set which contains another endpoint
    void union(Integer rootSrc, Integer rootDst) {
        DisjointSet setInfoSrc = nodes.get(rootSrc);
        setInfoSrc.setParentNode(rootDst);
    }


    boolean detectCycle(Integer src, Integer dst) {

        // Find parents for each endpoint
        Integer rootSrc = find(src);
        Integer rootDst = find(dst);

        // If both endpoints of one edge belongs to the same set -> loop detected
        if (rootSrc.equals(rootDst)) {
            return true;
        }
        // If loop not detected
        union(rootSrc, rootDst);
        return false;
    }
}
