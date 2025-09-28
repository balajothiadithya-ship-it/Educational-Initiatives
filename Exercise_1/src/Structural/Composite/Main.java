package Structural.Composite;

public class Main {
    public static void main(String args[]){
        Component keyboard = new Leaf("keyboard", 1000);
        Component mouse = new Leaf("mouse", 1000);
        Component ram = new Leaf("ram", 4000);
        Component cpu = new Leaf("cpu", 5000);
        Composite cabinet = new Composite("Cabinet");
        Composite peri = new Composite("Peripheral Devices");
        Composite motherBoard = new Composite("Mother Board");
        Composite computer = new Composite("Computer");
        peri.addComponent(keyboard);
        peri.addComponent(mouse);
        motherBoard.addComponent(ram);
        motherBoard.addComponent(cpu);
        cabinet.addComponent(motherBoard);
        computer.addComponent(peri);
        computer.addComponent(cabinet);
        computer.showPrice();
    }
}
