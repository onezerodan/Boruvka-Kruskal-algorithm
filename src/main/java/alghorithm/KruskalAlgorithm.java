package alghorithm;

import model.Edge;
import model.Graph;
import service.InputOutputService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {

    private static List<Edge> MST = new ArrayList<>();

    public static void runKruskalAlgorithm(Graph graph) {

        // Sort edges by weight
        List<Edge> edges = graph.getEdges();
        Collections.sort(edges);
        graph.setEdges(edges);

        Operations operations = new Operations(graph);

        int edgeCount = 0;
        int totalWeight = 0;
        for (Edge edge : edges) {

            // Go to next iteration if cycle detected
            if (operations.detectCycle(edge.getSrc(), edge.getDst())) {
                continue;
            }

            // Add edge to final MST
            MST.add(edge);

            edgeCount++;
            totalWeight += edge.getWeight();


            if (edgeCount == graph.getTotalNodes() - 1) {
                break;
            }
        }
        InputOutputService.writeAnswer(MST, totalWeight, edgeCount, graph.getTotalNodes());
    }
}
