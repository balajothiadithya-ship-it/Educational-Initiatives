package Behaviour.Stratergy;


import java.util.Comparator;


class SortByName implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2){

        return student1.getName().compareTo(student2.getName());
    }

}
