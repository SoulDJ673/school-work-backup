/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipcalculatorspringmvc;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
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
public class TipCalcController {

    @RequestMapping(value = "/calculateTip", method = RequestMethod.POST)
    public String calculateTip(HttpServletRequest request, Map<String, Object> model) {

        //Grab inputs
        String billInvalid = request.getParameter("billAmount");
        String percentageInvalid = request.getParameter("tipPercentage");

        //Validate Input & Conversion
        //Bill
        billInvalid = billInvalid.trim().replace("$", "");
        BigDecimal bill;
        try {
            bill = new BigDecimal(billInvalid);
            if (bill.compareTo(BigDecimal.ZERO) < 0) {
                return "invalidMoney";
            }
        } catch (NumberFormatException e) {
            return "invalidMoney";
        }
        //Percent
        percentageInvalid = percentageInvalid.trim().replace("%", "");
        double percentage;
        try {
            percentage = Double.parseDouble(percentageInvalid);
            if (percentage < 0) {
                return "invalidPercentage";
            }
        } catch (NumberFormatException e) {
            return "invalidPercentage";
        }

        //Multiply
        BigDecimal tip = bill.multiply(new BigDecimal(percentage).movePointLeft(2));

        //Package and sendoff
        model.put("amount", bill.setScale(2).toString());
        model.put("percentage", percentage);
        model.put("tip", tip.setScale(2, HALF_UP).toString());
        model.put("totalBill", bill.add(tip).setScale(2, HALF_UP).toString());

        return "result";
    }

}
