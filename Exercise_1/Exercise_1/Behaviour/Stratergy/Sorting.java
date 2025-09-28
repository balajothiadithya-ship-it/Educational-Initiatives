package Behaviour.Stratergy;

import java.util.List;

//context
public class Sorting {
    private SortingStratergy stratergy;
    public void setStratergy(SortingStratergy stratergy){
        this.stratergy = stratergy;
    }
    public void executeStratergy(List<Student> studentList){

        stratergy.sort(studentList);
    }
}
