package Behaviour.Observer;

public interface System {

    public void uploadVideo(String title);

    public void removeSubscriber(Subscriber sub);

    public void addSubscriber(Subscriber sub);

    public void notifySubscribers();
}
