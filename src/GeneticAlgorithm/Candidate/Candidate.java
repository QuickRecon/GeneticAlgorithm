package GeneticAlgorithm.Candidate;

import GeneticAlgorithm.Settings;
import java.util.ArrayList;

/**
 * Created by aren on 10/06/17.
 */
public class Candidate {
    protected int Fitness;
    private ArrayList<ArrayList<Node>> Nodes;
    public ArrayList StartSet;
    public ArrayList CurrentSet;

    public void ConfigureCandidate(){
        this.Nodes = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < Settings.DEFAULT_NODE_DEPTH.getValue(); i++) {

            this.Nodes.add(i,new ArrayList<Node>());

            for(int j = 0; j < Settings.DEFAULT_NODE_WIDTH.getValue(); j++){
                this.Nodes.get(i).add(j, new Node());
                this.Nodes.get(i).get(j).ConfigureNode();
                this.Nodes.get(i).get(j).DataPool = this.StartSet;
                this.Nodes.get(i).get(j).ConfigureSources();
            }
        }
    }
    public ArrayList RunCandidate(){
        for(int i = 0; i < this.Nodes.size(); i++){
            for(int j = 0; j < this.Nodes.get(i).size(); j++){
                Node CurrentNode = this.Nodes.get(i).get(j);
                if(i == 0){
                    CurrentNode.DataPool = this.StartSet;
                } else {
                    CurrentNode.DataPool = this.CurrentSet;
                }
                this.CurrentSet.clear();
                this.CurrentSet.add(j, CurrentNode.ExecuteNode());
            }
        }
        return this.CurrentSet;
    }
}