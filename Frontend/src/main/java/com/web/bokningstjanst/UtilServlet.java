/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.bokningstjanst;

import com.mycompany.booking.core.JPABooking;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Authentication Servlet.
 *
 * Handling all requests involving user authentication.
 *
 *
 * @author anon
 */
@WebServlet(name = "UtilServlet", urlPatterns = {"/util"})
public final class UtilServlet extends HttpServlet {

    /*
     *  Time out interval variable 5 * 60 seconds = 5 min timeout
     *  Also listed in web.xml
     */
    private final static int timeout = 5 * 60;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        String view = request.getParameter("view");

       
        
        if (action != null) {
            switch (action) {
                /*
                 * 
                 */
                
                
                
                case "login":
                    //if (true){
                    if (((JPABooking) request.getServletContext().getAttribute(Keys.BOOKING.toString())).getCustomerRegistry().authenticate(request.getParameter("name"), request.getParameter("passwd"))) {
                        request.getSession().setAttribute("USER", request.getParameter("name"));
                        request.getSession().setMaxInactiveInterval(timeout); // Timeout interval
                        response.sendRedirect("index.jspx");
                    } else {
                        request.getRequestDispatcher("index.jspx?authInvalid=true").forward(request, response);
                    }
                    break;
                    
                    
            }

        }
        /*
         * Redirect new unauthenticated users to the login page.
         */
        if (view != null) {
            switch (view) {
                case "login":
                    request.getRequestDispatcher("index.jspx").forward(request, response);
                    break;
                default:
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
