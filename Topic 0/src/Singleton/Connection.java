package Singleton;

//This is a singleton class
public class Connection {

    private String driver;
    private static Connection instance;

    //Constructor
    private Connection(String driver){
        this.setDriver(driver);
    }


    public static void Connection(String driver,String url, String user, String password) throws Exception{
        if(instance==null){
            if(url==null || user==null || password==null || driver==null){
                throw new Exception("Couldn't connect to the database");
            }
            instance= new Connection(driver);
        }
    }

    public void setDriver(String driver) {
        this.driver=driver;
    }

    public static Connection getInstance(){ return instance;    }

}

