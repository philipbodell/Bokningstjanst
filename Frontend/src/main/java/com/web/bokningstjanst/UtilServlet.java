/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.bokningstjanst;

import com.mycompany.booking.core.Competition;
import com.mycompany.booking.core.ContactMessages;
import com.mycompany.booking.core.Customer;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

                case "login":
                    //if (true){

                    if (Booking.INSTANCE.getCustomerRegistry().authenticate(request.getParameter("name"), request.getParameter("passwd"))) {
                        request.getSession().setAttribute("USER", request.getParameter("name"));
                        request.getSession().setMaxInactiveInterval(timeout); // Timeout interval
                        request.getSession().setAttribute("loggedin", true);
                        request.getSession().setAttribute("lname", Booking.INSTANCE.getCustomerRegistry().getLnameByEmail(request.getParameter("name")));
                        request.getSession().setAttribute("email", request.getParameter("name"));
                        request.getSession().setAttribute("fname", Booking.INSTANCE.getCustomerRegistry().getFnameByEmail(request.getParameter("name")));
                        //logger.severe(Booking.INSTANCE.getCustomerRegistry().getLnameByEmail(request.getParameter("name")));
                        response.sendRedirect("index.jspx");
                    } else {
                        request.getRequestDispatcher("index.jspx?authInvalid=true").forward(request, response);
                    }
                    break;
                case "logout": // When logging out send user back to index page.
                    request.getSession().invalidate();
                    response.sendRedirect("index.jspx");
                    break;
                case "fblogin":
                    request.getSession().setAttribute("fname", request.getParameter("fname"));
                    request.getSession().setAttribute("lname", request.getParameter("lname"));
                    request.getSession().setAttribute("loggedin", true);
                    request.getSession().setMaxInactiveInterval(timeout);
                    request.getSession().setAttribute("name", request.getParameter("fname") + " " + request.getParameter("lname"));
                    request.getRequestDispatcher("index.jspx").forward(request, response);
                    break;
                case "validate":
                    if (request.getSession().getAttribute("validationstring").equals(request.getParameter("validation"))) {
                        //add user to database

                        Booking.INSTANCE.getCustomerRegistry().add(new Customer(
                                (String) request.getSession().getAttribute("fname"),
                                (String) request.getSession().getAttribute("lname"),
                                (String) request.getSession().getAttribute("password"),
                                (String) request.getSession().getAttribute("pnum"),
                                (String) request.getSession().getAttribute("email")));
                        request.getSession().setAttribute("loggedin", true);
                        request.getRequestDispatcher("index.jspx?loggedIn=true").forward(request, response);
                    } else {
                        request.getRequestDispatcher("WEB-INF/jsp/notFound.jspx").forward(request, response);
                    }
                    break;
                case "resend":
                    request.getSession().setAttribute("validationstring", Mail.sendMail((String) request.getSession().getAttribute("email"), (String) request.getSession().getAttribute("password"), "validation"));
                    request.getRequestDispatcher("WEB-INF/jsp/register/validate.jspx").forward(request, response);
                    break;
                case "contact":
                    //Send email to ourselves
                    Mail.sendMail((String) request.getParameter("contact_email"), (String) request.getParameter("contact_message"), "contact");
                    Booking.INSTANCE.getContactMessagesRegistry().add(new ContactMessages(request.getParameter("contact_message"), request.getParameter("contact_email")));
                    request.getRequestDispatcher("WEB-INF/jsp/contact/contact.jspx").forward(request, response);
                    break;
                case "submitScore":
                    Booking.INSTANCE.getCompetitionCatalogue().add(new Competition(request.getParameter("fname"),
                            request.getParameter("lname"),
                            request.getParameter("phone"),
                            request.getParameter("mail"),
                            request.getParameter("score")));
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.severe(request.getParameter("fname")
                            + request.getParameter("lname")
                            + request.getParameter("phone")
                            + request.getParameter("mail")
                            + request.getParameter("score"));
                    /*request.getSession().setAttribute("fname", request.getParameter("fname"));
                    request.getSession().setAttribute("lname", request.getParameter("lname"));
                    request.getSession().setAttribute("email", request.getParameter("email"));
                    request.getSession().setAttribute("phone", request.getParameter("phone"));
                    request.getSession().setAttribute("score", request.getParameter("score"));*/
                    request.getRequestDispatcher("index.jspx").forward(request, response);
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
                case "register":
                    if (request.getSession(false) != null) {
                        request.getSession(false).invalidate();
                       }
                    request.getRequestDispatcher("WEB-INF/jsp/register/register.jspx").forward(request, response);
                    break;
                case "validate":

                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.severe("This what was stored" + request.getSession().getAttribute("captcha").toString() + request.getParameter("captchacode"));
                    if (!request.getSession().getAttribute("captcha").toString().equals(request.getParameter("captchacode"))) {
                        request.getRequestDispatcher("WEB-INF/jsp/register/register.jspx").forward(request, response);
                        break;
                    }
                    request.getSession().setAttribute("pnum", request.getParameter("pnum"));
                    request.getSession().setAttribute("fname", request.getParameter("fname"));
                    request.getSession().setAttribute("lname", request.getParameter("lname"));
                    request.getSession().setAttribute("password", request.getParameter("password"));
                    request.getSession().setAttribute("email", request.getParameter("email"));
                    request.getSession().setAttribute("validationstring", Mail.sendMail((String) request.getSession().getAttribute("email"), (String) request.getSession().getAttribute("password").toString(), "validation"));
                    if (request.getSession().getAttribute("validationstring").equals("error") ) {
                        request.getRequestDispatcher("WEB-INF/jsp/register/register.jspx").forward(request, response);
                        break;
                    }

                    request.getRequestDispatcher("WEB-INF/jsp/register/validate.jspx").forward(request, response);
                    break;

                case "gameover":
                    request.getSession().setAttribute("score", request.getParameter("score"));
                    request.getRequestDispatcher("WEB-INF/jsp/competitions/competitions.jspx").forward(request, response);
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
