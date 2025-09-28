package Behaviour.Stratergy;

import java.util.Collections;
import java.util.List;

public class AgeSorting implements  SortingStratergy{
    @Override
    public void sort(List<Student> studentList){
        Collections.sort(studentList, new SortByAge());
        System.out.println("Based on Age");
        for(Student student:studentList){
            System.out.println(student);
        }
    }
}
