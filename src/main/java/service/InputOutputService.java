package service;

import model.Edge;
import model.Graph;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class InputOutputService {
    public static Graph readGraph(String filePath)  {
        String line;
        List<Integer> adjacencyArray = new ArrayList<>();
       

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int verticesAmount = Integer.parseInt(reader.readLine());
            while ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                while (scanner.hasNextInt()) {
                    adjacencyArray.add(scanner.nextInt());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        int firstNodeIndex = adjacencyArray.get(0) -1;

        List<Edge> edges = new ArrayList<>();
        int totalNodes = 0;
        int totalEdges = 0;
        for (int i = 0; i < firstNodeIndex; i++) {

            int index = adjacencyArray.get(i);
            if (adjacencyArray.get(index-1) == 32767) break;
            totalNodes++;
            int currentNode = i+1;


            for (int j = adjacencyArray.get(i)-1; j < adjacencyArray.get(i+1)-1; j+=2){

                int destinationNode = adjacencyArray.get(j);
                int weight = adjacencyArray.get(j+1);

                Edge edge = new Edge(currentNode, destinationNode, weight);
                if (!edges.contains(edge)) {
                    totalEdges++;
                    edges.add(edge);
                }



            }


        }
        return new Graph(totalNodes, totalEdges, edges);

    }

    public static void writeAnswer(List<Edge> edges, int totalWeight, int totalEdges, int totalNodes) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"))) {

            List<Edge> sortedEdges = edges.stream()
                    .sorted(Comparator.comparing(Edge::getSrc)).toList();

            for (int i = 0; i < totalNodes; i++) {
                int currentNode = i + 1;
                for (Edge edge : sortedEdges) {
                    if (edge.getSrc() == currentNode) writer.append(edge.getDst() + " ");
                    else if (edge.getDst() == currentNode) writer.append(edge.getSrc() + " ");
                }
                writer.append("0\n");
            }
            writer.append(String.valueOf(totalWeight));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
