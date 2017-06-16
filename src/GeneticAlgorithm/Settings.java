package GeneticAlgorithm;

/**
 * Created by aren on 10/06/17.
 */
public enum Settings {
    DEFAULT_NODE_WIDTH(3),
    DEFAULT_NODE_DEPTH(30),
    CANDIDATE_COUNT(1000),
    MAXIMUM_CONSTANT_VALUE(100),
    CANDIDATE_LIFETIME(400),
    /* Mutation Probability takes the form 1/x where x is the setting value */
    MUTATE_NODE_FORM(10),
    MUTATE_NODE_CONSTANT(25),
    MUTATE_NODE_SOURCES(25);


    private final int value;

    Settings(int newValue) {
        this.value = newValue;
    }

    public int getValue() {
        return this.value;
    }
}
