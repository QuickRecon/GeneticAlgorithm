package GeneticAlgorithm.Candidate;

import java.util.ArrayList;

/**
 * Created by aren on 15/06/17.
 */
class CollectivePool {
    private static ArrayList IntegerCollective;

    static int Get(int index) {
        return (int) IntegerCollective.get(index);
    }

    static void Add(int value) {
        IntegerCollective.add(value);
    }

    static void Set(int index, int value) {
        IntegerCollective.set(index, value);
    }
}
