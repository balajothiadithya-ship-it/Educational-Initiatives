package Behaviour.Observer;

public interface Observer {
    public void update(Channel ch);
    public void subscribe(Channel ch);
    public void unSubscribe(Channel ch);
}
