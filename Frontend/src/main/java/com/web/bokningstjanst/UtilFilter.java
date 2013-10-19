/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.bokningstjanst;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anon
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/tickets/*"})
public class UtilFilter implements Filter {
    
    /** Initial method just printing information to the Log to show status.
     * 
     * @param config is a link to the web.xml file
     * @throws ServletException 
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        Logger.getAnonymousLogger().log(Level.INFO,"Filter initialized");
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }
    
    /** The main filter method handling the requests.
     * 
     * @param req is the current request that triggered the filter.
     * @param res is the response we will allow
     * @param chain is just a chain that makes it possible to combine multiple filters.
     * @throws IOException
     * @throws ServletException 
     */
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        
        /*
         * Getting the IP address, of the network unit accessing the site.
         */
        
        String ipAddress = request.getRemoteAddr();
        
        /*
         * Filter listening on requests. Checks if the USER variable is set or not.
         * 
         * If it's not then the user in the current session is not logged into the system.
         * 
         */
        if (session == null || session.getAttribute("USER") == null) {
            System.out.println("Sending " +"IP "+ipAddress + " to the login screen, Time "+ new Date().toString()); //Prints the information about systems not currently logged on.
            response.sendRedirect(request.getContextPath() + "/util?view=login"); // No logged-in user found, so redirect to auth Servlet.
        } else {
            chain.doFilter(req, res); // Logged-in user found, so just continue request.
        }
    }
    
    /**
     * Cleans up 
     */
    
    @Override
    public void destroy() {
        Logger.getAnonymousLogger().log(Level.INFO,"Filter destoryed");
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }
}
