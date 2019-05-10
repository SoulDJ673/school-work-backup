/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipcalculatorspringmvc;

import java.math.BigDecimal;
import java.util.Map;
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
public class TipCalcController {

    @RequestMapping(value = "/calculateTip", method = RequestMethod.POST)
    public String calculateTip(HttpServletRequest request, Map<String, Object> model) {

        //Grab inputs
        String billInvalid = request.getParameter("billAmount");
        String percentageInvalid = request.getParameter("tipPercentage");

        //Validate Input & Conversion
        //Bill
        billInvalid = billInvalid.trim().replace("$", "");
        BigDecimal bill = new BigDecimal(billInvalid);
        if (bill.compareTo(BigDecimal.ZERO) < 0) {
            return "negativeMoney";
        }
        //Percent
        percentageInvalid = percentageInvalid.trim().replace("%", "");
        double percentage = Double.parseDouble(percentageInvalid);
        if (percentage < 0) {
            return "negativePercent";
        }

        //Multiply
        BigDecimal tip = bill.multiply(new BigDecimal(percentage).movePointLeft(2));

        //Package and sendoff
        model.put("amount", bill.setScale(2).toString());
        model.put("percentage", percentage);
        model.put("tip", tip.setScale(2).toString());
        model.put("totalBill", bill.add(tip).setScale(2).toString());

        return "result";
    }

}
