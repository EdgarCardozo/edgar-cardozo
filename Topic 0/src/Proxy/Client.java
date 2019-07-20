package Proxy;

public class Client {
    public static void main (String[] args)
    {
        //The class uses the proxy clases instead of the real ones
        Internet internet = new ProxyInternet();
        try
        {
            internet.connectTo("stackoverflow.com");
            internet.connectTo("abc.com");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
