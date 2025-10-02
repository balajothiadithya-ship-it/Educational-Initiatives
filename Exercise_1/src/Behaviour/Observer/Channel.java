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
    public void addUser(Subscriber sub){
        subs.add(sub);
    }
    @Override
    public void removeUser(Subscriber sub){
        subs.remove(sub);
    }

    public void uploadVideo(String title){
        this.setVideoTitle(title);
        notifyUsers();
    }
    @Override
    public void notifyUsers(){
        for(Subscriber s:subs){
            s.update(this);
        }
    }
}
