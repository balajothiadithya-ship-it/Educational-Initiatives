package Creational.Singleton;

public class Main {
    public static void main(String args[]){
        DataBaseConnection db1 = DataBaseConnection.getInstance();
        DataBaseConnection db2 = DataBaseConnection.getInstance();
        db1.query("Select * from User");
        db2.query("Insert into Values('Balajothi', 24, 'CSE')");
        System.out.println(db1 == db2);//true

    }
}
