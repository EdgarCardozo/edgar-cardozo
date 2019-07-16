//Singleton Example
//This class will be the controller for database conecction
public class Login {
    private String username;
    private String password;
    private static Login instance;


    //Constructor
    private Login(String user,String pass){
        setUsername(user);
        setPassword(pass);
    }

    private void setPassword(String pass) {
        this.password=pass;
    }

    private void setUsername(String user) {
        this.username=user;
    }

    //Get the only object available
    public static Login getInstance(){
        return instance;
    }

    public static void login(String user, String pass){
        if(instance==null){
            instance=new Login(user,pass);
        }
    }

    public void showMessage(){
        System.out.println("Hello World! I'm a singleton object. The only in my class");
    }

    public void showInfo() {
        System.out.println("Username: "+this.getUsername());
        System.out.println("Password: "+this.getPassword());
    }

    private String getUsername() {
        return this.username;
    }

    private String getPassword() {
        return this.password;
    }
}
