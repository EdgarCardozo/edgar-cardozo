package Proxy;

import java.util.ArrayList;
import java.util.List;

//This class will be used as an interface between the real class and the class which calls it
public class ProxyInternet implements Internet {
        private Internet internet = new RealInternet();
        private static List<String> bannedSites;
        //Static so that every instance of this class has the same values
        static
        {
            bannedSites = new ArrayList<String>();
            bannedSites.add("abc.com");
            bannedSites.add("def.com");
            bannedSites.add("ijk.com");
            bannedSites.add("lnm.com");
            bannedSites.add("asd.com");
        }


        public void connectTo(String serverhost) throws Exception
        {
            if(bannedSites.contains(serverhost.toLowerCase()))
            {
                throw new Exception("Access Denied!" + serverhost + " is a banned site");
            }

            internet.connectTo(serverhost);
        }

    }
