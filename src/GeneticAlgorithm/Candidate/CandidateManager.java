package GeneticAlgorithm.Candidate;

import GeneticAlgorithm.Settings;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparing;

/**
 * Created by aren on 10/06/17.
 */
public class CandidateManager {
    public ArrayList<Candidate> Candidates;
    public int Generation = 0;

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
                DefineFitness(Candidate, Candidate.StartSet, Dataset);
            }
        }
    }

    public void DefineFitness(Candidate Candidate, ArrayList StartList, ArrayList EndList){
        // y = 10*log(x)*sin(10x)
        //TODO make line not horrible
        Candidate.Fitness = 10*(Math.log( (double) (int) EndList.get(0)))*(Math.sin((double) (int) EndList.get(0)));
        if(Double.isNaN(Candidate.Fitness)){Candidate.Fitness = 0;}
    }

    public void SortCandidates(){
        Collections.sort(Candidates, comparing(Candidate::GetFitness));
        Collections.reverse(Candidates);
        System.out.print("Generation: " + Generation + "\n");
        System.out.print("Max: " + Candidates.get(0).Fitness + "\n");
        System.out.print("Average: " + AverageFitness() + "\n");
        System.out.print("Min: " + Candidates.get(Candidates.size()-1).Fitness + "\n");
    }

    public void Reproduce(){
        Candidates.subList(Candidates.size()/2, Candidates.size()).clear();
        for(int i = 0; i < (Settings.CANDIDATE_COUNT.getValue()/2); i++){
            Candidates.add(Candidates.get(i));
            Candidates.get(i).Mutate();
        }
    }

    private double AverageFitness(){
        double sum = 0;
        for(int i = 0; i < Candidates.size(); i++){
            sum += Candidates.get(i).Fitness;
        }
        return sum/Candidates.size();
    }
}
