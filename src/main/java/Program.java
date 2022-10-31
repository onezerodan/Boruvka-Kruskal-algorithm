import alghorithm.KruskalAlgorithm;
import model.Edge;
import service.InputOutputService;

public class Program {
    public static void main(String[] args) {

        KruskalAlgorithm.runKruskalAlgorithm(InputOutputService.readGraph("in.txt"));

    }
}
