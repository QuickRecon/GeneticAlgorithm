package GeneticAlgorithm;

import GeneticAlgorithm.Candidate.CandidateManager;

/**
 * Created by aren on 10/06/17.
 */
public class Main {
    public static void main(String[] args) {
        CandidateManager CandidateManager = new CandidateManager();
        CandidateManager.PrepareCandidates();
        System.out.print("done");
    }
}