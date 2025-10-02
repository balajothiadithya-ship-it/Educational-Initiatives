package Behaviour.Observer;

import java.lang.System;

public class Subscriber implements  Observer{
    String name;
    //Channel channel;
    Subscriber(String name){
        this.name = name;
    }
    @Override
    public void register(Channel ch){

        ch.addUser(this);
    }
    @Override
    public void unRegister(Channel ch){

        ch.removeUser(this);
    }
    @Override
    public void update(Channel ch){
        System.out.println("Hey "+this.name+" New Video: "+ch.getVideoTitle()+" Uploaded by "+ch.name);
    }
}
