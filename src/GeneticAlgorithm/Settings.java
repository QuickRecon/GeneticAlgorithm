package GeneticAlgorithm;

/**
 * Created by aren on 10/06/17.
 */
public enum Settings {
    DEFAULT_NODE_WIDTH(3),
    DEFAULT_NODE_DEPTH(3),
    CANDIDATE_COUNT(1000);

    private final int value;

    Settings(int newValue) {
        this.value = newValue;
    }

    public int getValue() { return this.value; }
}
