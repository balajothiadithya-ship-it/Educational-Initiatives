package Creational.factory;
//concrete Product
public class PDFDocument implements Document{
    @Override
    public String create(){
        return "PDF Document is created";
    }
}
