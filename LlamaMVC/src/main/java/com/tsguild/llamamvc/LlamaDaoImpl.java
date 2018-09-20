package com.tsguild.llamamvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author souldj673
 */
public class LlamaDaoImpl implements LlamaDao {

    private Map<Integer, Llama> llamaHerd = new TreeMap<>();

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
