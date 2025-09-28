package Behaviour.Observer;

public class Youtube {
    public static void main(String args[]){
        Channel channel1 = new Channel("UR Cristiano");
        Subscriber sub1 = new Subscriber("Balajothi");
        Subscriber sub2 = new Subscriber("Adithya");
        Subscriber sub3 = new Subscriber("George");
        Subscriber sub4 = new Subscriber("Dave");
        sub1.subscribe(channel1);
        sub2.subscribe(channel1);
        sub3.subscribe(channel1);
        sub1.unSubscribe(channel1);
        sub4.subscribe(channel1);
        channel1.uploadVideo("Lets welcome our Mystery Guest:Lionel Messi");

    }
}
