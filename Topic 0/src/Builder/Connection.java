package Builder;

public class Connection {
    private String server;
    private String user;
    private String pass;

    //Setters
    public void setUser(String url) {
        this.user = url;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setServer(String server){
        this.server=server;
    }
    //Getters
    public String getServer() {
        return server;
    }
    public String getUser() {
        return user;
    }
    public String getPass() {
        return pass;
    }
    public void connect(){
        System.out.println("Connecting to "+this.getServer()+"...");
    }
}
