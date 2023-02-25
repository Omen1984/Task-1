package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_PORT = "5432";
    private static final String DEFAULT_DBNAME = "Learningdata";
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "root";
    private static final String DEFAULT_DRIVER = "org.postgresql.Driver";
    public Connection getPostgresConnection() throws SQLException,
            ClassNotFoundException {

        return getPostgresConnection(
                DEFAULT_DRIVER,
                DEFAULT_HOST,
                DEFAULT_PORT,
                DEFAULT_DBNAME,
                DEFAULT_USERNAME,
                DEFAULT_PASSWORD);
    }

    public Connection getPostgresConnection(
            String driver,
            String hostName,
            String port,
            String dbName,
            String userName,
            String password) throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);

        String url = String.format("jdbc:postgresql://%s:%s/%s", hostName, port, dbName);

        Connection db = DriverManager.getConnection(url, props);

        return db;
    }
}
