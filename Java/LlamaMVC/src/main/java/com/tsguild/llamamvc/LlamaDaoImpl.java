package com.tsguild.llamamvc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author souldj673
 */
public class LlamaDaoImpl implements LlamaDao {

    private Map<Integer, Llama> llamaHerd = new TreeMap<>();
    private final String DELIMITER = "::";

    /**
     * This method takes a Llama and turns it into a single line text
     * representation to allow being saved into a file, database, etc.
     *
     * The text is organized as follows:
     * llamaID::llamaName::llamaAge::llamaWeight::llamaColor::llamaWoolType::
     * llamaNumHair::llamaOverBP::llamaUnderBP::llamaSpitRange::llamaOmegaSpit::
     * llamaTongueLength::llamaKick::llamaGPA::llamaHangoutSpot
     *
     * @param llamaToTextify - Llama to be represented by the line of text
     */
    public String marshallLlama(Llama llamaToTextify) {
        String llamaText = "";

        //Stringify
        llamaText = llamaText + llamaToTextify.getId();
        llamaText += DELIMITER + llamaToTextify.getName();
        llamaText += DELIMITER + llamaToTextify.getAge();
        llamaText += DELIMITER + llamaToTextify.getWeight();
        llamaText += DELIMITER + llamaToTextify.getColor();
        llamaText += DELIMITER + llamaToTextify.getWoolType();
        llamaText += DELIMITER + llamaToTextify.getNumHairs();
        llamaText += DELIMITER + llamaToTextify.getOverBP();
        llamaText += DELIMITER + llamaToTextify.getUnderBP();
        llamaText += DELIMITER + llamaToTextify.getSpitRange();
        llamaText += DELIMITER + llamaToTextify.getOmegaSpit();
        llamaText += DELIMITER + llamaToTextify.getTongueLength();
        llamaText += DELIMITER + llamaToTextify.isLikesToKickJames();
        llamaText += DELIMITER + llamaToTextify.getGpa();
        llamaText += DELIMITER + llamaToTextify.getFavHangoutSpot();

        return llamaText;
    }

    /**
     * This is the inverse of marshallLlama. A line of text is turned back into
     * a Llama.
     *
     * @param aLlamaLine - The text version of a llama, found in LlamaHerd.txt
     * @return The Llama that was represented by the line of text
     */
    public Llama unmarshallLlama(String aLlamaLine) {
        //split the line
        String[] llamaBits = aLlamaLine.split(DELIMITER);

        //Blank Llama Creation
        Llama blankLlama = new Llama();

        //Indexing
        blankLlama.setId(Integer.parseInt(llamaBits[0]));
        blankLlama.setName(llamaBits[1]);
        blankLlama.setAge(Integer.parseInt(llamaBits[2]));
        blankLlama.setWeight(Integer.parseInt(llamaBits[3]));
        blankLlama.setColor(llamaBits[4]);
        blankLlama.setWoolType(llamaBits[5]);
        blankLlama.setNumHairs(Long.parseLong(llamaBits[6]));
        blankLlama.setOverBP(Integer.parseInt(llamaBits[7]));
        blankLlama.setUnderBP(Integer.parseInt(llamaBits[8]));
        blankLlama.setSpitRange(Integer.parseInt(llamaBits[8]));
        blankLlama.setOmegaSpit(Double.parseDouble(llamaBits[9]));
        blankLlama.setTongueLength(Double.parseDouble(llamaBits[10]));
        blankLlama.setLikesToKickJames(Boolean.parseBoolean(llamaBits[11]));
        blankLlama.setGpa(Double.parseDouble(llamaBits[12]));
        blankLlama.setFavHangoutSpot(llamaBits[13]);

        return blankLlama;

    }

    /**
     * Iterates through a generated list used to house the llamas in memory,
     * marshall all llamas with marshallLlama method and write them to
     * LlamaHerd.txt
     *
     * @throws java.io.IOException
     */
    public void saveAllLlamas() throws IOException {
        //Setup the file
        PrintWriter writer = new PrintWriter(new FileWriter("LlamaHerd.txt"));

        //Assemble
        List<Llama> allLlamas = this.getAllLlamas();

        //Iteration
        for (Llama aLlama : allLlamas) {
            //Marshall Llama
            String llamaText = this.marshallLlama(aLlama);
            //Save to file
            writer.println(llamaText);
        }
        //Polite
        writer.flush();
        writer.close();
    }

    public void readAllLlamas() throws FileNotFoundException {
        //Scanner Opening
        Scanner fileParser = new Scanner(new BufferedReader(
                new FileReader("LlamaHerd.txt")));

        //File Reader Setup
        String fileName = "LlamaHerd.txt";

        //File Breakdown
        while (fileParser.hasNextLine()) {
            String fileLine = fileParser.nextLine(); //Get Line
            Llama fileLlama = this.unmarshallLlama(fileLine); // Line to Llama
            this.llamaHerd.put(fileLlama.getId(), fileLlama); // Store in herd
        }

    }

    @Override
    public Llama addLlama(Llama aLlama) {
        //We are given a llama, and all llamas are organized by uuids
        llamaHerd.put(aLlama.getId(), aLlama);

        return aLlama;
    }

    @Override
    public List<Llama> getAllLlamas() {
        //Need to return all llamas, all llamas stay in the map
        //get all llamas from map via .values
        Collection<Llama> allLlamas = llamaHerd.values();

        //We must return a list.  Conversion of Collection to List
        List<Llama> llamasInAList = new ArrayList<>(allLlamas);
        return llamasInAList;
    }

    @Override
    public Llama getLlama(int llamaId) {
        //This one is easy.  Use given key to get value (Llama), return Llama
        return llamaHerd.get(llamaId);
    }

    @Override
    public void editLlama(int oldId, Llama changedLlama) {
        //Only if oldId and currentId are the same
        if (changedLlama.getId() == oldId) {
            llamaHerd.replace(oldId, changedLlama);
        } else {
            //The Id has changed
            llamaHerd.remove(oldId); //Remove Llama from old location
            llamaHerd.put(changedLlama.getId(), changedLlama); //Add Llama to new location
        }
    }

    @Override
    public Llama removeLlama(int id) {
        //.remove also returns the value deleted from the map.  This is good for delete verification
        return llamaHerd.remove(id); //Sad Llama
    }

}
