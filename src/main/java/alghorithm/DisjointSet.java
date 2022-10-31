package alghorithm;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    private int parentNode;
    private int rank;

    DisjointSet(Integer parent) {
        setParentNode(parent);
    }

    public Integer getParentNode() {
        return parentNode;
    }

    public void setParentNode(Integer parentNode) {
        this.parentNode = parentNode;
    }


}
