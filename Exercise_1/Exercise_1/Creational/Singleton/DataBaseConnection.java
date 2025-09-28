package Creational.Singleton;
//Ensures a single shared database connection across the entire Application
public class DataBaseConnection {
    static DataBaseConnection instance;
    private DataBaseConnection(){
        System.out.println("Connected to DataBase...");
    }
    //returns same instance every time
    public static DataBaseConnection getInstance(){
        if(instance == null){
            instance = new DataBaseConnection();
        }
        return instance;
    }
    public void query(String sql){
        System.out.println("Executing query:"+sql);
    }
}
