package Behaviour.Stratergy;

import java.util.Collections;
import java.util.List;

public class NameSorting implements  SortingStratergy{
    public void sort(List<Student> studentList){
        Collections.sort(studentList, new SortByName());
        System.out.println("Based on Name");
        for(Student student:studentList){
            System.out.println(student);
        }
    }
}
