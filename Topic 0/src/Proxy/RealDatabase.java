package Proxy;

//This class make the connection to the server
public class RealDatabase implements Database{
    public void connectTo(String serverhost,String user, String pass){
        System.out.println("Connecting to: "+ serverhost);
    }
}
