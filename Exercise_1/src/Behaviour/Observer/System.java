package Behaviour.Observer;

public interface System {



    public void removeUser(Subscriber sub);

    public void addUser(Subscriber sub);

    public void notifyUsers();
}
