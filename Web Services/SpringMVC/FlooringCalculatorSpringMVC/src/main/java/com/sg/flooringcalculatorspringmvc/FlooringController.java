/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalculatorspringmvc;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author souldj673
 */
@Controller
public class FlooringController {

    @RequestMapping(value = "/flooringCalculator", method = RequestMethod.POST)
    public String flooringCalculator(HttpServletRequest request, Map<String, Object> model) {
        double width;
        double length;
        double price;

        //Taking care of empty strings & grabbing values from index.jsp
        if (request.getParameter("widthOfArea").isEmpty()) {
            width = 0.0;
        } else {
            width = Double.parseDouble(request.getParameter("widthOfArea"));
        }
        if (request.getParameter("lengthOfArea").isEmpty()) {
            length = 0.0;
        } else {
            length = Double.parseDouble(request.getParameter("lengthOfArea"));
        }
        if (request.getParameter("pricePerSqFoot").isEmpty()) {
            price = 0.0;
        } else {
            price = Double.parseDouble(request.getParameter("pricePerSqFoot"));
        }

        //Calculations
        double area = length * width;
        int buildRate = 20; //Team can build at 20 sq ft per hour
        double workTimeMinutes = ((area / buildRate) * 60);
        double workCharges = (workTimeMinutes / 15); // area / 20sqftPerHour multiplied by 60 minutes / 15 minute cycles
        int workChargeRounded = (int) Math.round(workCharges); //Rounds up to the next charge and converts to int
        double laborRate = 86.00; //Cost per hour of labor

        double laborCost = (workChargeRounded * laborRate);
        double materialCost = (length * width * price);
        double result = materialCost + laborCost;

        // Set all the results in the model Map so they
        // are available to result.jsp
        model.put("result", result);
        model.put("workTime", workTimeMinutes);
        model.put("laborCost", laborCost);
        model.put("materialCost", materialCost);
        return "result";
    }
}
