package Proxy;

public class Client {
    public static void main (String[] args)
    {
        //The class uses the proxy clases instead of the real ones
        Database database = new ProxyDatabase();
        try
        {
            database.connectTo("myhost.com","myuser","mypass");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
