package Creational.factory;
//concrete Product Factory
public class WordFactory extends  DocumentFactory{
    @Override
    public Document FactoryMethod(){
        return new WordDocument();
    }
}
