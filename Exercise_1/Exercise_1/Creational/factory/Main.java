package Creational.factory;

public class Main {
    public static void main(String args[]){
        DocumentFactory factoryWord = new WordFactory();
        Document word = factoryWord.FactoryMethod();
        System.out.println(word.create());// displays Word Document is created
        DocumentFactory factoryPDF = new PDFFactory();
        Document pdf = factoryPDF.FactoryMethod();
        System.out.println(pdf.create());//displays PDF Document is created

    }
}
