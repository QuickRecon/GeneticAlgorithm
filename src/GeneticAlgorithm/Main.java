package GeneticAlgorithm;

import GeneticAlgorithm.Candidate.CandidateManager;

/**
 * Created by aren on 10/06/17.
 */
public class Main {
    public static void main(String[] args) {
        CSVWriter CSVWriter = new CSVWriter("output");
        CandidateManager CandidateManager = new CandidateManager();
        CandidateManager.PrepareCandidates();
        for (int i = 0; i < Settings.GENERATIONS.getValue(); i++) {
            CandidateManager.Generation++;
            CandidateManager.RunCandidates();
            CandidateManager.SortCandidates();
            CandidateManager.Reproduce();
            CSVWriter.WriteGeneration(CandidateManager);
        }
        System.out.print("done");
    }
}
