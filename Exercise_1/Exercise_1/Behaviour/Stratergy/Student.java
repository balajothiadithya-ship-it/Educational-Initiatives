package Behaviour.Stratergy;

public class Student {
    private String name;
    private int age;
    private int avgMarks;
    Student(String name, int age, int avgMarks){
        this.name = name;
        this.age = age;
        this.avgMarks = avgMarks;
    }
    @Override
    public String toString(){
        return this.name+" "+this.age+" "+this.avgMarks;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAvgMarks() {
        return avgMarks;
    }

    public void setAvgMarks(int avgMarks) {
        this.avgMarks = avgMarks;
    }
}
