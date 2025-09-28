package Creational.factory;
//concrete Product Factory
public class PDFFactory extends DocumentFactory{
    @Override
    public Document FactoryMethod(){
        return new PDFDocument();
    }
}
