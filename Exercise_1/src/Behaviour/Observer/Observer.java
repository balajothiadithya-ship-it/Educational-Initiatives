package Behaviour.Observer;

public interface Observer {
    public void update(Channel ch);
    public void register(Channel ch);
    public void unRegister(Channel ch);
}
