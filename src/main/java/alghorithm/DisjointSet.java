package alghorithm;

import java.util.ArrayList;
import java.util.List;

// Used to determine if both endpoints belongs to one set (if so, there is a loop)
public class DisjointSet {
    private int parentNode;

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
