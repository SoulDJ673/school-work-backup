package com.tsguild.llamamvc;

import java.util.List;

/**
 *
 * @author souldj673
 */
public interface LlamaDao {
    //C
    public Llama addLlama(Llama aLlama);
    
    //R
    public List<Llama> getAllLlamas();
    public Llama getLlama(int llamaId);
    
    //U
    public void editLlama(int oldId, Llama aLlama);
    
    //D
    public Llama removeLlama(int id);

    public void loadHerd();

    public void saveHerd();
}
