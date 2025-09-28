package Creational.factory;
//concrete Product


public class WordDocument implements Document {
    @Override
    public String create(){
        return "Word Document is created";
    }
}
