package model;

public class GuestUser extends User{
    private boolean isRegistered;
    public GuestUser(String name) {
        super(name);
        isRegistered = false;
    }

    public void register(String name, String email, String pass){
        isRegistered = true;
    }
}
