package Behaviour.Stratergy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        Student student1 = new Student("Balajothi", 21, 85);
        Student student2 = new Student("Ronaldo", 20, 90);
        Student student3 = new Student("Messi", 20, 78);
        List<Student> studentList= new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Sorting sorting = new Sorting();
        sorting.setStratergy(new NameSorting());
        sorting.executeStratergy(studentList);
    }
}
