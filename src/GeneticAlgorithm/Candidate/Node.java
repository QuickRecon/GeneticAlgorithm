package GeneticAlgorithm.Candidate;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Aren on 10/06/17.
 */
public class Node {

    private Operator Mode;

    public ArrayList DataPool;
    private int[] DataPoolIndices;

    private int Constant;

    public int ExecuteNode() {
        int input1 = (int) DataPool.get(DataPoolIndices[0]);
        int input2 = (int) DataPool.get(DataPoolIndices[1]);
        if (Mode == Operator.CONSTANT) {
            return Constant;
        } else {
            return Mode.Operate(input1, input2);
        }
    }

    public void ConfigureNode() {
        int index = new Random().nextInt(Operator.values().length);
        Mode = Operator.values()[index];
        if (Mode == Operator.CONSTANT) {
            SetConstant(new Random().nextInt(255));
        }
    }

    public void ConfigureSources() {
        DataPoolIndices = new int[2];
        try {
            DataPoolIndices[0] = new Random().nextInt(DataPool.size() - 2);
            DataPoolIndices[1] = new Random().nextInt(DataPool.size() - 2);
        } catch (IllegalArgumentException e){
            DataPoolIndices[0] = 0;
            DataPoolIndices[1] = 0;
        }
    }

    public void SetConstant(int Constant) {
        this.Constant = Constant;
    }
}
