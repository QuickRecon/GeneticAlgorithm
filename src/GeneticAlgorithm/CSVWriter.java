package GeneticAlgorithm;

import GeneticAlgorithm.Candidate.Candidate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by aren on 25/06/17.
 */
public class CSVWriter {
    public String filename;
    private FileWriter file;

    CSVWriter(String filename) {
        this.filename = filename;
        try {
            file = new FileWriter(filename);
        } catch (IOException e) {
            System.out.print("IO Exception \n");
        }
    }

    public void WriteGeneration(ArrayList<Candidate> Candidates){
        try {
            for (int i = 0; i < Candidates.size(); i++) {
                double fitness = Candidates.get(i).GetFitness();
                file.append(Double.toString(fitness));
                file.append(',');
            }
            file.append('\n');
        } catch (IOException e){
            System.out.print("IO Exception \n");
        }
    }
}
