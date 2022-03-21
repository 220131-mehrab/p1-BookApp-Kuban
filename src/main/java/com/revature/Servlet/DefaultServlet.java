package com.revature.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class DefaultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getPathInfo();
        String resourceDir = "static";
//        InputStream file = getClass().getClassLoader().getResourceAsStream(resourceDir + filename);
//        String mimeType = getServletContext().getMimeType(filename);
//        resp.setContentType(mimeType);
//        IOUtils.copy(file, resp.getOutputStream());
        if (filename == null || filename.equals("/") || filename.equals("")) filename = "/index.html";
        InputStream file = getClass().getClassLoader().getResourceAsStream(resourceDir + filename);
        if (file == null) {
            file = getClass().getClassLoader().getResourceAsStream(resourceDir + "/index.html");
        }
        String mimeType = getServletContext().getMimeType(filename);
        resp.setContentType(mimeType);
        IOUtils.copy(file, resp.getOutputStream());
        //InputStream file = getClass().getClassLoader().getResourceAsStream(resourceDir + filename); //loads src data into backend from static folder
        //String mimeType = getServletContext().getMimeType(filename); //checks for type of file being imported
        //resp.setContentType(mimeType);
        //System.err.println(file);
    }
}
