package Proxy;

public interface Database{
    public void connectTo(String serverhost, String user, String pass) throws Exception;
}
