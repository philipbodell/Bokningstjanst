/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.bokningstjanst;

import com.mycompany.booking.core.Ticket;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Patrik
 */
@WebServlet(name = "BookingServlet", urlPatterns = {"/ticket/*"})
public class TicketServlet extends HttpServlet {

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

        //Get the view parameter.
        String view = request.getParameter("view");
        //Used when ticket of some sort should be handeled
        String tickets = request.getParameter("tickets");
        if (view != null) {
            switch (view) {
                case "train":
                    request.getSession().setAttribute("DEPARTURES", Booking.INSTANCE.getDepartureCatalogue().getDeparturesByType("Train"));
                    request.getSession().setAttribute("DESTINATIONS", Booking.INSTANCE.getDepartureCatalogue().getDestinationsByType("Train"));
                    if (request.getSession().getAttribute("loggedin") == null) {
                        request.getRequestDispatcher("WEB-INF/jsp/needToLogin.jspx").forward(request, response);
                    } else if ((boolean) request.getSession().getAttribute("loggedin")) {
                        request.getRequestDispatcher("WEB-INF/jsp/ticket/train.jspx").forward(request, response);
                    } else {
                        request.getRequestDispatcher("WEB-INF/jsp/needToLogin.jspx").forward(request, response);
                    }
                    break;
                case "flight":
                    request.getSession().setAttribute("DEPARTURES", Booking.INSTANCE.getDepartureCatalogue().getDeparturesByType("Flight"));
                    request.getSession().setAttribute("DESTINATIONS", Booking.INSTANCE.getDepartureCatalogue().getDestinationsByType("Flight"));
                    if (request.getSession().getAttribute("loggedin") == null) {
                        request.getRequestDispatcher("WEB-INF/jsp/needToLogin.jspx").forward(request, response);
                    } else if ((boolean) request.getSession().getAttribute("loggedin")) {
                        request.getRequestDispatcher("WEB-INF/jsp/ticket/flight.jspx").forward(request, response);
                    } else {
                        request.getRequestDispatcher("WEB-INF/jsp/needToLogin.jspx").forward(request, response);
                    }
                    break;
                case "bus":
                    request.getSession().setAttribute("DEPARTURES", Booking.INSTANCE.getDepartureCatalogue().getDeparturesByType("Bus"));
                    request.getSession().setAttribute("DESTINATIONS", Booking.INSTANCE.getDepartureCatalogue().getDestinationsByType("Bus"));
                    if (request.getSession().getAttribute("loggedin") == null) {
                        request.getRequestDispatcher("WEB-INF/jsp/needToLogin.jspx").forward(request, response);
                    } else if ((boolean) request.getSession().getAttribute("loggedin")) {
                        request.getRequestDispatcher("WEB-INF/jsp/ticket/bus.jspx").forward(request, response);
                    } else {
                        request.getRequestDispatcher("WEB-INF/jsp/needToLogin.jspx").forward(request, response);
                    }
                    break;
                case "boat":
                    request.getSession().setAttribute("DEPARTURES", Booking.INSTANCE.getDepartureCatalogue().getDeparturesByType("Boat"));
                    request.getSession().setAttribute("DESTINATIONS", Booking.INSTANCE.getDepartureCatalogue().getDestinationsByType("Boat"));
                    if (request.getSession().getAttribute("loggedin") == null) {
                        request.getRequestDispatcher("WEB-INF/jsp/needToLogin.jspx").forward(request, response);
                    } else if ((boolean) request.getSession().getAttribute("loggedin")) {
                        request.getRequestDispatcher("WEB-INF/jsp/ticket/boat.jspx").forward(request, response);
                    } else {
                        request.getRequestDispatcher("WEB-INF/jsp/needToLogin.jspx").forward(request, response);
                    }
                    break;
            }
        }
        if (tickets != null) {
            switch (tickets) {
                case "chooseDeparture":
                    request.getSession().setAttribute("MATCHING_DEST", Booking.INSTANCE.getDepartureCatalogue()
                            .getMatchingDeparture(request.getParameter("departure"), request.getParameter("destination")));
                    request.getRequestDispatcher("WEB-INF/jsp/ticket/allDepartures.jspx").forward(request, response);
                    break;
                case "Confirm":
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(60);
                    request.getSession().setAttribute("DEP", Booking.INSTANCE.getDepartureCatalogue().getById(Long.valueOf(request.getParameter("id"))));
                    request.getRequestDispatcher("WEB-INF/jsp/ticket/ticketValidation.jspx").forward(request, response);
                    break;
                case "Payment":
                    //Check so the session has not died
                    if (request.getSession(false) != null) {
                        request.getSession().setAttribute("DEP", Booking.INSTANCE.getDepartureCatalogue().getById(Long.valueOf(request.getParameter("id"))));
                        request.getRequestDispatcher("WEB-INF/jsp/ticket/payment.jspx").forward(request, response);
                    } else {
                        request.getRequestDispatcher("index.jspx").forward(request, response);
                    }
                    break;
                case "PaymentSuccess":
                    Booking.INSTANCE.getTicketCatalogue().add(new Ticket(
                            request.getParameter("departurelocation"),
                            request.getParameter("destination"),
                            request.getParameter("departuredate"),
                            request.getParameter("departuretime"),
                            request.getParameter("type"),
                            Integer.valueOf(request.getParameter("price")),
                            Booking.INSTANCE.getCustomerRegistry().getIdByEmail(request.getSession().getAttribute("email").toString()),
                            request.getParameter("code")));
                    Mail.sendMail((String) request.getSession()
                            .getAttribute("email"), "Name: \n" + request.getSession().getAttribute("fname") + " " + request.getSession().getAttribute("lname") + "\n"
                            + "Departure Location: \n" + request.getParameter("departurelocation") + "\n"
                            + "Destination: \n" + request.getParameter("destination") + "\n"
                            + "Date: \n" + request.getParameter("departuredate") + "\n"
                            + "Traveltime: \n" + request.getParameter("departuretime") + "\n"
                            + "Price: \n" + request.getParameter("price") + ":-\n", "ticket"
                            + "Discount code: \n" + request.getParameter("code"));
                    request.getRequestDispatcher("WEB-INF/jsp/ticket/paymentSuccess.jspx").forward(request, response);
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
        return "Handles action and view requests in ticket pages. ";
    }// </editor-fold>
}
