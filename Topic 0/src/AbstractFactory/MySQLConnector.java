package AbstractFactory;

public class MySQLConnector extends Connector {
    public Connection createConnection(){
        System.out.println("Creating connection to a mySQL database");
        return new MySQLConnection();
    }
}
