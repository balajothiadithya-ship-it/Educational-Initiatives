package Behaviour.Stratergy;

import java.util.Collections;
import java.util.List;

public class MarksSorting implements SortingStratergy{
    @Override
    public void sort(List<Student> studentList){
        Collections.sort(studentList, new SortByMarks());
        System.out.println("Based on Mark");
        for(Student student:studentList){
            System.out.println(student);
        }
    }
}
