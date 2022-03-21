package com.revature.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.Servlet.BooksServlet;
import com.revature.Servlet.DefaultServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {
    Logger logger = LoggerFactory.getLogger(Server.class);
    Tomcat server;

    // Run server
    public Server() throws JsonProcessingException, SQLException {
        server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:schema.sql'", "sa", "");
        //"jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:schema.sql'";
        //new DatabaseController().BuildDatabase();
        // Default and Books Servlets
        server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("", "booksServlet", new BooksServlet(connection)).addMapping("/books");
    }


    public void run() {
        try {
            server.start();
        } catch (LifecycleException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}
