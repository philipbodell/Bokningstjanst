
/*
package com.web.bokningstjanst;

import java.util.logging.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Logger.getAnonymousLogger().log(Level.INFO,"Putting Booking in application scope");
        sce.getServletContext().setAttribute("booking", Booking.INSTANCE);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Logger.getAnonymousLogger().log(Level.INFO,"Removing Booking in application scope");
        sce.getServletContext().removeAttribute("booking");
    }
}
*/