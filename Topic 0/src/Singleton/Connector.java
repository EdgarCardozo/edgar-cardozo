package Singleton;

public class Connector {

    private static Connection con;
    private static final String driver = "myDriver";
    private static final String user = "root";
    private static final String pass = "1234";
    private static final String url = "localhost:3306/myDB";

    public static void main(String[] args){
        System.out.println("The app will try to connect to the database using...");
        System.out.println("driver: "+ driver);
        System.out.println("user: "+ user);
        System.out.println("pass: "+ pass);
        System.out.println("url: "+url);

        try{
            Connection.Connection(driver,url,user,pass);
            con = Connection.getInstance();

        }catch(Exception e){
            System.out.println("Unable to connect to the database");
        }

    }

}
