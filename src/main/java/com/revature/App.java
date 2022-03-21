package com.revature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.server.Server;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        try {
            new Server().run();
        } catch (JsonProcessingException e) {
            System.err.println("Server failed to run");
        }
    }
}
