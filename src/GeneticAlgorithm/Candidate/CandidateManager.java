package GeneticAlgorithm.Candidate;

import GeneticAlgorithm.Settings;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparing;

/**
 * Created by aren on 10/06/17.
 */
public class CandidateManager {
    private ArrayList<Candidate> Candidates;
    private int Generation = 0;

    public void PrepareCandidates() {
        Candidates = new ArrayList<Candidate>();
        for (int i = 0; i < Settings.CANDIDATE_COUNT.getValue(); i++) {
            Candidates.add(new Candidate());
            Candidates.get(i).StartSet = new ArrayList();
            Candidates.get(i).StartSet.add(1);
            Candidates.get(i).StartSet.add(2);
            Candidates.get(i).StartSet.add(3);
            Candidates.get(i).Cycle = 1;
            Candidates.get(i).ConfigureCandidate();
        }
    }

    public void RunCandidates(){
        for(int i = 0; i < Candidates.size(); i++){
            Candidate Candidate = Candidates.get(i);
            if(Candidate.Cycle < Candidate.Lifetime){
                ArrayList Dataset = Candidate.RunCandidate();
                DefineFittness(Candidate, Candidate.StartSet, Dataset);
                SortCandidates();
            }
        }
    }

    public void DefineFittness(Candidate Candidate, ArrayList StartList, ArrayList EndList){
        // y = 10*log(x)*sin(10x)
        Candidate.Fitness = 10*(Math.log( (double) EndList.get(0)))*(Math.sin(10 * (double) EndList.get(0)));
    }

    public void SortCandidates(){
        Collections.sort(Candidates, comparing(Candidate::GetFitness));
        System.out.print("Generation" + Generation);
        System.out.print("Max:" + Candidates.get(0).Fitness);
        System.out.print("Min:" + Candidates.get(Candidates.size()-1).Fitness);
    }
}
