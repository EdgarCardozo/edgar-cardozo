package Proxy;

//This class make the connection to the server
public class RealInternet implements Internet{
    public void connectTo(String serverhost){
        System.out.println("Connecting to: "+ serverhost);
    }
}
