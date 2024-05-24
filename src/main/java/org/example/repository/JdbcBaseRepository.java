package org.example.repository;

import org.example.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class JdbcBaseRepository {
    private static Connection connection;
    protected Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        ApplicationProperties.DB_URL,
                        ApplicationProperties.DB_USERNAME,
                        ApplicationProperties.DB_PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return connection;
    };



}
