package AbstractFactory;

public class FactoryProducer {
    public static Connector getConnector(boolean isMySQL){
        if(isMySQL){
            return new MySQLConnector();
        }else{
            return new PostgreSQLConnector();
        }
    }
}
