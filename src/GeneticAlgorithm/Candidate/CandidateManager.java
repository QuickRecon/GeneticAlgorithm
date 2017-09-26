package GeneticAlgorithm.Candidate;

import GeneticAlgorithm.Settings;

import java.lang.reflect.Array;
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
        Candidates = new ArrayList<>();
        for (int i = 0; i < Settings.CANDIDATE_COUNT.getValue(); i++) {
            Candidates.add(new Candidate());
            Candidates.get(i).StartSet = new ArrayList();
            Candidates.get(i).StartSet.add(0);
            Candidates.get(i).Cycle = 1;
            Candidates.get(i).ConfigureCandidate();
        }
    }

    public void RunCandidates() {
        int Samplesize = Settings.SAMPLESIZE.getValue();
        ArrayList<Double> Sample = new ArrayList<Double>();
        for (GeneticAlgorithm.Candidate.Candidate Candidate : Candidates) {
            if (/*Candidate.Cycle < Candidate.Lifetime*/ true) {
                for (int i = 0; i < Samplesize; i++) {
                    int datapoint = new Random().nextInt();
                    Candidate.StartSet.set(0, datapoint);
                    ArrayList Dataset = Candidate.RunCandidate();
                    double actual = 1000 * Math.sin(Math.toRadians(datapoint));
                    Sample.add(Math.abs(1 / (actual - (int) Dataset.get(0))));
                }
                double sum = 0;
                for (Double aSample : Sample) {
                    sum += aSample;
                }
                Candidate.Fitness = sum / Samplesize;
            }
        }
    }

    public void SortCandidates() {
        Candidates.sort(comparing(Candidate::GetFitness));
        Collections.reverse(Candidates);
        System.out.print("Generation: " + Generation + "\n");
        // TODO Impliment the below method in the CSVWriter
        /*System.out.print("Max: " + Candidates.get(0).Fitness + "\n");
        System.out.print("Average: " + AverageFitness() + "\n");
        System.out.print("Min: " + Candidates.get(Candidates.size()-1).Fitness + "\n");*/
    }

    public void Reproduce() {
        Candidates.subList(Candidates.size() / 2, Candidates.size()).clear();
        int half = Settings.CANDIDATE_COUNT.getValue() / 2;
        for (int i = 0; i < (Settings.CANDIDATE_COUNT.getValue() / 2); i++) {
            Candidates.add(new Candidate());
            Candidates.get(i + half).StartSet = new ArrayList();
            Candidates.get(i + half).StartSet.add(0);
            Candidates.get(i + half).Cycle = 1;
            Candidates.get(i + half).ConfigureCandidate();
            Candidates.get(i + half).Nodes = Candidates.get(i).Nodes;
            Candidates.get(i + half).Mutate();
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
