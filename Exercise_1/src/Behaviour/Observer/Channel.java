package Behaviour.Observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements System {
    String name;
    private String videoTitle;
    private final List<Subscriber> subs;
    Channel(String name){
        this.name = name;
        subs = new ArrayList<>();
    }
    public void setVideoTitle(String title){
        this.videoTitle = title;
    }
    public String getVideoTitle(){
        return this.videoTitle;
    }
    @Override
    public void addSubscriber(Subscriber sub){
        subs.add(sub);
    }
    @Override
    public void removeSubscriber(Subscriber sub){
        subs.remove(sub);
    }
    @Override
    public void uploadVideo(String title){
        this.setVideoTitle(title);
        notifySubscribers();
    }
    @Override
    public void notifySubscribers(){
        for(Subscriber s:subs){
            s.update(this);
        }
    }
}
