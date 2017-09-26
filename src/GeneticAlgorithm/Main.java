package GeneticAlgorithm;

import GeneticAlgorithm.Candidate.CandidateManager;

/**
 * Created by aren on 10/06/17.
 */
public class Main {
    public static void main(String[] args) {
        CSVWriter CSVWriter = new CSVWriter("output.csv");
        CandidateManager CandidateManager = new CandidateManager();
        CandidateManager.PrepareCandidates();
        for (int i = 0; i < Settings.GENERATIONS.getValue(); i++) {
            CandidateManager.Generation++;
            CandidateManager.RunCandidates();
            CandidateManager.SortCandidates();
            CSVWriter.WriteGeneration(CandidateManager);
            CandidateManager.Reproduce();
        }
        System.out.print("done");
    }
}
