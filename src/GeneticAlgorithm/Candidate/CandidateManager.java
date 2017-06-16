package GeneticAlgorithm.Candidate;

import GeneticAlgorithm.Settings;

import java.util.ArrayList;

/**
 * Created by aren on 10/06/17.
 */
public class CandidateManager {
    private ArrayList<Candidate> Candidates;

    public void PrepareCandidates() {
        Candidates = new ArrayList<Candidate>();
        for (int i = 0; i < Settings.CANDIDATE_COUNT.getValue(); i++) {
            Candidates.add(new Candidate());
            Candidates.get(i).StartSet = new ArrayList();
            Candidates.get(i).StartSet.add(3);
            Candidates.get(i).StartSet.add(8);
            Candidates.get(i).Cycle = 1;
            Candidates.get(i).ConfigureCandidate();
        }
    }

    public void RunCandidates(){
        for(int i = 0; i < Candidates.size(); i++){
            Candidate Candidate = Candidates.get(i);
            if(Candidate.Cycle < Candidate.Lifetime){
                ArrayList Dataset = Candidate.RunCandidate();
            }
        }
    }

    public void DefineFittness(ArrayList StartList, ArrayList EndList){

    }
}
