package Proxy;

import java.util.ArrayList;
import java.util.List;

//This class will be used as an interface between the real class and the class which calls it
public class ProxyInternet implements Database {
        private Database internet = new RealDatabase();
        private static List<String> databases;
        static{
            databases = new ArrayList<String>();
            databases.add("myhost.com");
            databases.add("anotherhost.com");
            databases.add("backuphost.com");
        }

        public void connectTo(String serverhost, String user, String pass) throws Exception
        {
            if(!databases.contains(serverhost) && !isValid(user))
            {
                throw new Exception("Access Denied! " + serverhost + " is not a database server");
            }

            internet.connectTo(serverhost,user,pass);
        }

    private boolean isValid(String verify) {
            if(true){
                System.out.println("The username is valid");
                return true;
            }
            return false;
    }

}
