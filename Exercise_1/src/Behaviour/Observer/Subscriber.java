package Behaviour.Observer;

import java.lang.System;

public class Subscriber implements  Observer{
    String name;
    //Channel channel;
    Subscriber(String name){
        this.name = name;
    }
    @Override
    public void subscribe(Channel ch){

        ch.addSubscriber(this);
    }
    @Override
    public void unSubscribe(Channel ch){

        ch.removeSubscriber(this);
    }
    @Override
    public void update(Channel ch){
        System.out.println("Hey "+this.name+" New Video: "+ch.getVideoTitle()+" Uploaded by "+ch.name);
    }
}
