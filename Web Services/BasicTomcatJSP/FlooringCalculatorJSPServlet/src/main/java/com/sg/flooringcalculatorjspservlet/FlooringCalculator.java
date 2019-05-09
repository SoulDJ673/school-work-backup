/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalculatorjspservlet;

import java.io.IOException;
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
@WebServlet(name = "FlooringCalculator", urlPatterns = {"/FlooringCalculator"})
public class FlooringCalculator extends HttpServlet {

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

        //Setting attribute because permissions
        request.setAttribute("result", result);
        request.setAttribute("workTime", workTimeMinutes);
        request.setAttribute("laborCost", laborCost);
        request.setAttribute("materialCost", materialCost);

        //Use Request Dispatcher for result.jsp to forward request
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
