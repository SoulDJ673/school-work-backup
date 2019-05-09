/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensspringmvc;

import java.util.Map;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author souldj673
 */
@Controller
public class SevensController {

    @RequestMapping(value = "/luckySevens", method = RequestMethod.POST)
    public String luckySevens(HttpServletRequest request, Map<String, Object> model) {
//Check for 0 or negative money values & return to landing page if true
        if (Integer.parseInt(request.getParameter("dollarInput")) <= 0) {
            return "error";
        };

        //Var and Random Declaration and Initialization
        Random diceRoller = new Random();
        int dollars = Integer.parseInt(request.getParameter("dollarInput"));
        int maxMoney = dollars;
        int rolls = 0;
        int maxRolls = 0;

        while (dollars > 0) {

            //Roll dice and add total
            int rollOne = diceRoller.nextInt(6) + 1;
            int rollTwo = diceRoller.nextInt(6) + 1;
            int diceTotal = rollOne + rollTwo;
            rolls++;

            //Update Money
            if (diceTotal == 7) {
                dollars = dollars + 4;

                //Check if we had more than we had once!
                if (dollars > maxMoney) {
                    maxMoney = dollars;
                    maxRolls = rolls;
                }
            } else {
                dollars--;
            }
        }

        //If money is gone, end game
        model.put("betMoney", request.getParameter("dollarInput"));
        model.put("maxMoney", maxMoney);
        model.put("maxRolls", maxRolls);
        model.put("rolls", rolls);
        return "result";
    }
}
