package Builder;

public class BuilderTester {
    public static void main(String[] args){
        //Creates a connector
        ConectorBuilder connector = new ConectorBuilder();
        //Creates the MySQL connection
        Connection connection = connector.createMySQLConnection();
        //Do the Builder.Connection
        connection.connect();
        //Test the creation of the PostgreSQL connection
        connection = connector.createPostgreSQLConnection();
        //Do the connection
        connection.connect();
    }
}
