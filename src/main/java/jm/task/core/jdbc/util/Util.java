package jm.task.core.jdbc.util;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.SQLException;

public class Util {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 5432;
    private static final String DEFAULT_DBNAME = "Learningdata";
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "root";

    public PGConnectionPoolDataSource getPGConnectionPoolDataSource() throws SQLException,
            ClassNotFoundException {

        return getPGConnectionPoolDataSource(
                DEFAULT_HOST,
                DEFAULT_PORT,
                DEFAULT_DBNAME,
                DEFAULT_USERNAME,
                DEFAULT_PASSWORD);
    }

    public PGConnectionPoolDataSource getPGConnectionPoolDataSource(
            String hostName,
            int port,
            String dbName,
            String userName,
            String password) {

        PGConnectionPoolDataSource dataSource = new PGConnectionPoolDataSource();
        dataSource.setServerNames(new String[]{hostName});
        dataSource.setDatabaseName(dbName);
        dataSource.setPortNumbers(new int[]{port});
        dataSource.setUser(userName);
        dataSource.setPassword(password);

        return dataSource;
    }
}
