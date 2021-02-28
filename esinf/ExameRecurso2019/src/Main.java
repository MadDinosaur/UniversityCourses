import java.util.*;

public class Main {
    public static void main(String[] args) {
        Double[] pesos = {4.0, 8.0, 2.0, 1.0, 7.0, 6.0, 1.0, 4.0, 5.0, 2.0};
        Map<Integer, LinkedList<Double>> paletes = new HashMap<>();
        System.out.println("Exercício 1 :");
        System.out.printf("Taxa média de ocupação = %.2f\n", packing(10, Arrays.asList(pesos), paletes));
        for (Map.Entry<Integer, LinkedList<Double>> palete : paletes.entrySet()) {
            System.out.printf("Palete " + palete.getKey() + " --> " + Arrays.toString(palete.getValue().toArray()) + "\n");
        }

        System.out.printf("\nExercício 2 :\n");
        System.out.println("(Hello!, Hello) --> " + mistery("Hello!", "Hello"));
        System.out.println("(Hello, World) --> " + mistery("Hello", "World"));
        System.out.println("(Oh, Hello!, Hello) --> " + mistery("Oh, Hello!", "Hello"));

        System.out.printf("\nExercício 2 : \n");
        Tree<Integer> tree = new Tree<>();
        tree.insert(60);
        tree.insert(32);
        tree.insert(80);
        tree.insert(19);
        tree.insert(34);
        tree.insert(89);
        tree.insert(1);
        System.out.println(Arrays.toString(tree.inverseByLevel().toArray()));
    }

    public static double packing(double capac, List<Double> pesos, Map<Integer, LinkedList<Double>> paletes) {
        Collections.sort(pesos, Comparator.reverseOrder());
        Map<Integer, Double> paletesCapac = new HashMap<>();

        paletes.put(1, new LinkedList<>());
        paletesCapac.put(1, 0.0);

        for (double peso : pesos) {
            for (int i = 1; i <= paletes.size(); i++) {
                int paleteID = i;
                double currentCapac = paletesCapac.get(paleteID);

                if (capac >= currentCapac + peso) {
                    paletes.get(paleteID).add(peso);
                    paletesCapac.put(paleteID, currentCapac + peso);
                    break;
                } else if (!paletes.containsKey(paleteID + 1)) {
                    paletes.put(paleteID + 1, new LinkedList<>());
                    paletesCapac.put(paleteID + 1, 0.0);
                }
            }
        }

        double sum = 0;
        for (double occupiedCapac : paletesCapac.values()) {
            sum += occupiedCapac;
        }
        return sum / capac / paletes.size();
    }

    public static int mistery(String tt, String pp) {

        for (int i = 0; i <= tt.length() - pp.length(); i++) {
            int j = 0;
            while (j < pp.length() && tt.charAt(i + j) == pp.charAt(j)) {
                j++;
            }
            if (j == pp.length())
                return i;
        }
        return -1;
    }
}
