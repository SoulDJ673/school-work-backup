/*
 * Copyright (C) 2018 souldj673
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tsguild.llamamvc;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class LlamaServiceImpl implements LlamaService {

    private LlamaDao llamaWrangler;

    @Override
    public void pastureLlamas() throws LlamaPersistenceException {
        //Get Llamas from barn to be examined
        this.llamaWrangler.loadHerd();
    }

    @Override
    public void stableLlamas() throws LlamaPersistenceException {
        //Put all Llamas to bed
        this.llamaWrangler.saveHerd();
    }

    @Override
    public List<Llama> getLlamaHerd() {
        List<Llama> llamaHerd = this.llamaWrangler.getAllLlamas();
        return llamaHerd;
    }

    @Override
    public Llama getLlama(int id) {
        return this.llamaWrangler.getLlama(id);
    }

    @Override
    public Llama dyeLlama(String color, int llamaID) throws NonExistantLlamaException, AlreadyThatColorException {

        Llama llamaToDye = this.llamaWrangler.getLlama(llamaID);

        //Llama could be null, check
        //Get current color
        String currentColor = llamaToDye.getColor();

        //Llama could already be this color
        //Check
        llamaToDye.setColor(color);

        //make sure wrangler has new llama
        this.llamaWrangler.editLlama(llamaID, llamaToDye);

        return llamaToDye;
    }

    @Override
    public BigDecimal shearLlama(int llamaID) {
        Llama llamaToShear = this.llamaWrangler.getLlama(llamaID);

        //Could be null, check
        validateExistance(llamaToShear);
        
        //Get Wool length
        BigDecimal woolToShear = llamaToShear.getWoolLength();

        //Check if this is enough
        llamaToShear.setWoolLength(BigDecimal.ZERO);
        return woolToShear;
    }

    private void validateExistance(Llama llama) throws NonExistantLlamaException {
        if (llama == null) {
            throw new NonExistantLlamaException("Looked for a Llama, found nothing.");
        }
    }

    private void validateWoolLength(Llama llama) throws WoolTooShortException {

        BigDecimal woolLength = llama.getWoolLength();
        BigDecimal shearLimit = BigDecimal.ZERO;

        //Throw exception if woolLength is less than shearLimit -# Less // 0 Equal // +# Greater
        int comparison = woolLength.compareTo(shearLimit);
        if (comparison < 1) {
            throw new WoolTooShortException("This llama is already shorn");
        }

    }
    
    private void validateLlamaCanDye(String color, Llama llama) throws AlreadyThatColorException {
        //Get Llama color
        String llamaColor = llama.getColor();
        
        //Throw exception if same color
        if(llamaColor.equalsIgnoreCase(color)) {
            throw new AlreadyThatColorException("The llama is already that color!");
        }
    }

}
