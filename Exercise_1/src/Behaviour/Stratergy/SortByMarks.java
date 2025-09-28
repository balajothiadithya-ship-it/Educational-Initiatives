package Behaviour.Stratergy;

import java.util.Comparator;

public class SortByMarks implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2){
        return student1.getAvgMarks()- student2.getAvgMarks();
    }
}
