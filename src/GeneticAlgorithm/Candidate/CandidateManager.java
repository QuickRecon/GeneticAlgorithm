package GeneticAlgorithm.Candidate;

import GeneticAlgorithm.Settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
            Candidates.get(i).StartSet.add(0);
            Candidates.get(i).Cycle = 1;
            Candidates.get(i).ConfigureCandidate();
        }
    }

    public void RunCandidates() {
        for (GeneticAlgorithm.Candidate.Candidate Candidate : Candidates) {
            if (Candidate.Cycle < Candidate.Lifetime) {
                int datapoint = new Random().nextInt();
                Candidate.StartSet.set(0, datapoint);
                ArrayList Dataset = Candidate.RunCandidate();
                double actual = Math.sin(datapoint);
                Candidate.Fitness = actual - (int) Dataset.get(0);
            }
        }
    }

    public void SortCandidates() {
        Collections.sort(Candidates, comparing(Candidate::GetFitness));
        Collections.reverse(Candidates);
        System.out.print("Generation: " + Generation + "\n");
        /*System.out.print("Max: " + Candidates.get(0).Fitness + "\n");
        System.out.print("Average: " + AverageFitness() + "\n");
        System.out.print("Min: " + Candidates.get(Candidates.size()-1).Fitness + "\n");*/
    }

    public void Reproduce() {
        Candidates.subList(Candidates.size() / 2, Candidates.size()).clear();
        for (int i = 0; i < (Settings.CANDIDATE_COUNT.getValue() / 2); i++) {
            Candidates.add(Candidates.get(i));
            Candidates.get(i).Mutate();
        }
    }

    public double AverageFitness() {
        double sum = 0;
        for (GeneticAlgorithm.Candidate.Candidate Candidate : Candidates) {
            sum += Candidate.Fitness;
        }
        return sum / Candidates.size();
    }

    public double MaxFitness() {
        double max = 0;
        for (GeneticAlgorithm.Candidate.Candidate Candidate : Candidates) {
            if (Candidate.Fitness > max) {
                max = Candidate.Fitness;
            }
        }
        return max;
    }

    public double MinFitness() {
        double min = Candidates.get(0).Fitness;
        for (GeneticAlgorithm.Candidate.Candidate Candidate : Candidates) {
            if (Candidate.Fitness < min) {
                min = Candidate.Fitness;
            }
        }
        return min;
    }
}
