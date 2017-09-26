package GeneticAlgorithm.Candidate;

import GeneticAlgorithm.Settings;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by aren on 10/06/17.
 */

public class Candidate {
    //TODO Implement Lifetimes
    final int Lifetime = Settings.CANDIDATE_LIFETIME.getValue();
    int Cycle;
    ArrayList StartSet;
    double Fitness;
    ArrayList<ArrayList<Node>> Nodes;

    void ConfigureCandidate() {
        Nodes = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < Settings.DEFAULT_NODE_DEPTH.getValue(); i++) {

            this.Nodes.add(i, new ArrayList<Node>());

            for (int j = 0; j < Settings.DEFAULT_NODE_WIDTH.getValue(); j++) {
                Nodes.get(i).add(j, new Node());
                Nodes.get(i).get(j).ConfigureNode();
                Nodes.get(i).get(j).DataPool = this.StartSet;
                Nodes.get(i).get(j).ConfigureSources();
            }
        }
    }

    ArrayList RunCandidate() {
        ArrayList currentSet = new ArrayList(StartSet);
        for (int i = 0; i < Nodes.size(); i++) {
            for (int j = 0; j < Nodes.get(i).size(); j++) {
                Node CurrentNode = Nodes.get(i).get(j);
                if (i == 0) {
                    CurrentNode.DataPool = new ArrayList(StartSet);
                } else {
                    CurrentNode.DataPool = new ArrayList(currentSet);
                }
                currentSet.clear();
                currentSet.add(CurrentNode.ExecuteNode());
            }
        }
        Cycle += 1;
        return currentSet;
    }

    void Mutate() {
        for (int i = 0; i < Nodes.size() - 1; i++) {
            for (int j = 0; j < Nodes.get(i).size(); j++) {
                Node Node = Nodes.get(i).get(j);
                if (1 == new Random().nextInt(Settings.MUTATE_NODE_CONSTANT.getValue())) {
                    Node.SetConstant(new Random().nextInt(Settings.MAXIMUM_CONSTANT_VALUE.getValue()));
                }
                if (1 == new Random().nextInt(Settings.MUTATE_NODE_FORM.getValue())) {
                    Node.ConfigureNode();
                }
                if (1 == new Random().nextInt(Settings.MUTATE_NODE_SOURCES.getValue())) {
                    Node.ConfigureSources();
                }
            }
        }
    }

    public double GetFitness() {
        return Fitness;
    }
}
