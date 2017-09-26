package GeneticAlgorithm.Candidate;

import java.util.ArrayList;

/**
 * Created by aren on 15/06/17.
 */
public class CollectivePool {
    private static ArrayList IntegerCollective;

    public static int Get(int index) {
        return (int) IntegerCollective.get(index);
    }

    public static void Add(int value) {
        IntegerCollective.add(value);
    }

    public static void Set(int index, int value) {
        IntegerCollective.set(index, value);
    }
}
