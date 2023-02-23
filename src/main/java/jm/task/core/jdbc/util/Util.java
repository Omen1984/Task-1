package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    public Connection getPostgresConnection() throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";
        String port = "5432";
        String dbName = "Learningdata";
        String userName = "root";
        String password = "root";

        return getPostgresConnection(hostName, port, dbName, userName, password);
    }

    public Connection getPostgresConnection(String hostName, String port, String dbName, String userName, String password)
            throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);

        String url = String.format("jdbc:postgresql://%s:%s/%s", hostName, port, dbName);

        Connection db = DriverManager.getConnection(url, props);

        return db;
    }
}
