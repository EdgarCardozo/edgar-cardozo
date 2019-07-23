package AbstractFactory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Asks user what to use
        System.out.println("Do you want to use a MySQL database? Y/N");
        String name="";
        Connector connector;
        while(!name.equals("Y") && !name.equals("N")) {
            //name = System.console().readLine();
            Scanner in = new Scanner(System.in);
            name = in.nextLine();
        }
        if(name.equals("Y")){
            connector = new MySQLConnector();
        }else{
            connector = new PostgreSQLConnector();
        }
        Connection connection = connector.createConnection();
        connection.connect();

    }
}
