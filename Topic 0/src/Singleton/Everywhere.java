package Singleton;

public class Everywhere {
    public static void main(String[] args) {
        //Singleton.Login first
        Login.login("newUser","newPass");

        //Get the only object in the program
        Login object = Login.getInstance();

        //show the message that Singleton.Login contains
        object.showMessage();

        //show attributes
        object.showInfo();
    }
}
