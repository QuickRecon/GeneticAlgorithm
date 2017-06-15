package GeneticAlgorithm.Candidate;

import GeneticAlgorithm.Settings;

import java.util.ArrayList;

/**
 * Created by aren on 10/06/17.
 */
public class CandidateManager {
    private ArrayList<Candidate> Candidates;

    public void PrepareCandidates() {
        this.Candidates = new ArrayList<Candidate>();
        for (int i = 0; i < Settings.CANDIDATE_COUNT.getValue(); i++) {
            this.Candidates.add(new Candidate());
            this.Candidates.get(i).StartSet = new ArrayList();
            this.Candidates.get(i).StartSet.add(3);
            this.Candidates.get(i).StartSet.add(8);
            this.Candidates.get(i).ConfigureCandidate();
        }
    }
}
