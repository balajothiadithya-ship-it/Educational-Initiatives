package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    int price;
    String name;
    List<Component> componentList = new ArrayList<>();
    Composite(String name){
        this.name = name;
    }
    public void addComponent(Component leaf){
        componentList.add(leaf);
    }
    @Override
    public void showPrice(){
        System.out.println(name);
        System.out.println("Consist of..");
        for(Component c:componentList){
            c.showPrice();
        }
    }
}
