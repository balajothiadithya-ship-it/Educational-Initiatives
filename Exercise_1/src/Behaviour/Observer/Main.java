package Behaviour.Observer;

public class Main {
    public static void main(String args[]){
        Channel channel1 = new Channel("UR Cristiano");
        Subscriber sub1 = new Subscriber("Balajothi");
        Subscriber sub2 = new Subscriber("Adithya");
        Subscriber sub3 = new Subscriber("George");
        Subscriber sub4 = new Subscriber("Dave");
        sub1.register(channel1);
        sub2.register(channel1);
        sub3.register(channel1);
        sub1.unRegister(channel1);
        sub4.register(channel1);
        channel1.uploadVideo("Lets welcome our Mystery Guest:Lionel Messi");

    }
}
