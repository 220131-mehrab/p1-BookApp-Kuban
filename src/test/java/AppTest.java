import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.Servlet.BooksServlet;
import com.revature.Servlet.DefaultServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class AppTest {

    @Test
    public void ServletGetTest() throws LifecycleException, JsonProcessingException {
        Tomcat server = new Tomcat();
        server.getConnector();
        server.addContext("", null);


        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test;INIT=runscript from 'classpath:schema.sql'", "sa", "");
        } catch (SQLException e) {
            System.err.println("Connection to DB failed");
            e.printStackTrace();
        }

        server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("", "booksServlet", new BooksServlet(connection)).addMapping("/books");

        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
            System.err.println("Failed to start");
        }
        server.stop();
        System.out.println("Success");
    }
}
