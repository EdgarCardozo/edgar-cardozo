package AbstractFactory;

//this class creates a postgresql connection
public class PostgreSQLConnector extends Connector {
    public Connection createConnection(){
        System.out.println("Creating connection to a postgresql database");
        return new PostgreSQLConnection();
    }
}
