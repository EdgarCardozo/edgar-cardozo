package AbstractFactory;

//This class defines all necessary parameters to connect to a mysql database
public class MySQLConnection implements Connection {
    private static String driver = "MySQL";
    public void connect(){
        System.out.println("Connecting to the mysql database");
    }
}
