package AbstractFactory;

//This class will define every necessary parameter to connect with a postgresql database
public class PostgreSQLConnection implements Connection{
        private static String driver = "PostgreSQL";
        public void connect(){
            System.out.println("Connecting to the postgreSQL database");
        }
}
