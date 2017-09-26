package GeneticAlgorithm;

/**
 * Created by aren on 10/06/17.
 */
public enum Settings {
    DEFAULT_NODE_WIDTH(5),
    DEFAULT_NODE_DEPTH(100),
    CANDIDATE_COUNT(50),
    SAMPLESIZE(100),
    MAXIMUM_CONSTANT_VALUE(100),
    CANDIDATE_LIFETIME(400),
    GENERATIONS(1000),
    /* Mutation Probability takes the form 1/x where x is the setting value */
    MUTATE_NODE_FORM(5),
    MUTATE_NODE_CONSTANT(5),
    MUTATE_NODE_SOURCES(5);


    private final int value;

    Settings(int newValue) {
        this.value = newValue;
    }

    public int getValue() {
        return this.value;
    }
}
