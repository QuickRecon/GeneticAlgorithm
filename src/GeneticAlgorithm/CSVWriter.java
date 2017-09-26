package GeneticAlgorithm;

import GeneticAlgorithm.Candidate.Candidate;
import GeneticAlgorithm.Candidate.CandidateManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by aren on 25/06/17.
 */
public class CSVWriter {
    private String filename;
    private FileWriter file;

    CSVWriter(String filename) {
        this.filename = filename;
        try {
            file = new FileWriter(filename);
            file.append("Average Fitness,MaxFitness,MinFitness,Candidate Values\n");
        } catch (IOException e) {
            System.out.print("IO Exception \n");
        }
    }

    public void WriteGeneration(CandidateManager candidateManager) {
        try {
            file.append(candidateManager.AverageFitness() + "," + candidateManager.MaxFitness() + "," + candidateManager.MinFitness());
            for (int i = 0; i < candidateManager.Candidates.size(); i++) {
                file.append(',');
                double fitness = candidateManager.Candidates.get(i).GetFitness();
                file.append(Double.toString(fitness));
            }
            file.append('\n');
        } catch (IOException e) {
            System.out.print("IO Exception \n");
        }
    }
}
