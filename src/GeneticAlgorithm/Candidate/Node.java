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

    public int ExecuteNode(){
        int input1 = (int) this.DataPool.get(this.DataPoolIndices[0]);
        int input2 = (int) this.DataPool.get(this.DataPoolIndices[1]);
        if(this.Mode == Operator.CONSTANT){
            return this.Constant;
        } else {
            return this.Mode.Operate(input1, input2);
        }
    }
    public void ConfigureNode(){
        int index = new Random().nextInt(Operator.values().length);
        this.Mode = Operator.values()[index];
        if(this.Mode == Operator.CONSTANT){
            this.SetConstant(new Random().nextInt(255));
        }
    }
    public void ConfigureSources(){
        this.DataPoolIndices = new int[2];
        this.DataPoolIndices[0] = new Random().nextInt(this.DataPool.size());
        this.DataPoolIndices[1] = new Random().nextInt(this.DataPool.size());
    }
    public void SetConstant(int Constant){
        this.Constant = Constant;
    }
}
