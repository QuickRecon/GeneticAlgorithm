package GeneticAlgorithm;

/**
 * Created by aren on 10/06/17.
 */
public enum Settings {
    DEFAULT_NODE_WIDTH(3),
    DEFAULT_NODE_DEPTH(30),
    CANDIDATE_COUNT(100),
    MAXIMUM_CONSTANT_VALUE(100),
    CANDIDATE_LIFETIME(400),
    GENERATIONS(10000),
    /* Mutation Probability takes the form 1/x where x is the setting value */
    MUTATE_NODE_FORM(4),
    MUTATE_NODE_CONSTANT(1),
    MUTATE_NODE_SOURCES(1);


    private final int value;

    Settings(int newValue) {
        this.value = newValue;
    }

    public int getValue() {
        return this.value;
    }
}
