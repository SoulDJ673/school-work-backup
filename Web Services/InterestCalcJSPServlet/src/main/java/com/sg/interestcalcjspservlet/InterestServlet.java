/*
 * Copyright (C) 2019 souldj673
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
package com.sg.interestcalcjspservlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author souldj673
 */
@WebServlet(name = "InterestServlet", urlPatterns = {"/InterestServlet"})
public class InterestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Strip unneccessary symbol or text content
        String rate = request.getParameter("rate");
        rate = rate.replace("%", "");
        rate = rate.trim();
        String initialPrinciple = request.getParameter("initPrinciple");
        initialPrinciple = initialPrinciple.replace("$", "");
        initialPrinciple = initialPrinciple.trim();

        //Data Containers
        int yearsToHold = Integer.parseInt(request.getParameter("yearsHeld"));
        BigDecimal[] products = new BigDecimal[yearsToHold * 4];
        BigDecimal[] principles = new BigDecimal[yearsToHold * 4];

        //Math
        double annualInterestRate = Double.parseDouble(rate);
        double quarterlyRate = annualInterestRate / 4;
        for (int quarter = 0; quarter < yearsToHold * 4; quarter++) {
            BigDecimal principle;
            BigDecimal interest;
            BigDecimal result;

            if (quarter == 0) {
                //Grab principle from request if this is the first run through
                principle = new BigDecimal(initialPrinciple);
            } else {
                principle = products[quarter - 1];
            }
            //Interest
            interest = principle.multiply(new BigDecimal((quarterlyRate / 100)));

            result = principle.add(interest);

            //Add back to arrays
            principles[quarter] = principle;
            products[quarter] = result;
        }

        //Package up relevant data
        Map<Integer, Double> yearlyPrinciples = new TreeMap<>();
        Map<Integer, Double> yearlyResults = new TreeMap<>();
        for (int quarter = 0; quarter <= yearsToHold * 4; quarter = quarter + 4) {
            try {
                if (quarter == 0) {
                    yearlyPrinciples.put(quarter / 4, principles[quarter].doubleValue());
                    yearlyResults.put(quarter / 4, products[quarter].doubleValue());
                } else if (quarter > 0) {
                    yearlyPrinciples.put(quarter / 4, principles[quarter - 1].doubleValue());
                    yearlyResults.put(quarter / 4, products[quarter - 1].doubleValue());
                }
            } catch (Exception e) {
                continue;
            }
        }
        
        

        //Send data off to result page
        request.setAttribute("principles", yearlyPrinciples);
        request.setAttribute("products", yearlyResults);
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
