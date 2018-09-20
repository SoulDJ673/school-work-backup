/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.llamamvc;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class LlamaDaoImplTest {

    public LlamaDaoImplTest() {
    }

    @Test
    public void testSomeMethod() {
        //Build the DAO
        LlamaDao myTestDao;
        myTestDao = new LlamaDaoImpl();

        //Now build some llamas 
        Llama llamaOne = new Llama();
        llamaOne.setId(1);

        Llama llamaTwo = new Llama();
        llamaTwo.setId(2);
        
        Llama llamaThree = new Llama();
        llamaThree.setId(3);
        
        Llama llamaFour = new Llama();
        llamaFour.setId(4);
        
        //Put them in the Dao
        myTestDao.addLlama(llamaOne);
        myTestDao.addLlama(llamaTwo);
        myTestDao.addLlama(llamaThree);
        myTestDao.addLlama(llamaFour);
        
        //Checking...
        List<Llama> daoLlamas = myTestDao.getAllLlamas();
        Assert.assertEquals("Should be four llamas!", 4, daoLlamas.size());
    }

}
