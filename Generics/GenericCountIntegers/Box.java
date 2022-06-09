package Generics.GenericCountMethodDouble_06;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {


    private final List<T> value;

    public Box() {
        this.value=new ArrayList<>();
    }

    public void add(T value){
        this.value.add(value);
    }

    public long countGraterElements(T toCompare){
        return this.value.stream().filter(e-> e.compareTo(toCompare)>0).count();
    }
}
