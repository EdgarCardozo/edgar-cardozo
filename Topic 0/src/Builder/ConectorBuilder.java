package Builder;

public class ConectorBuilder {

    public Connection createMySQLConnection(){
        Connection connection = new Connection();
        connection.setServer("MySQLserver");
        connection.setUser("UserForMySQL");
        connection.setPass("mypassword");
        return connection;
    }

    public Connection createPostgreSQLConnection(){
        Connection connection = new Connection();
        connection.setServer("PostgreSQLserver");
        connection.setUser("UserForPostgreSQL");
        connection.setPass("mypassword");
        return connection;
    }
}
