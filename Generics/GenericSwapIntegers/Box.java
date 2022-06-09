package Generics.GenericSwapMethodInteger_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box <T>{

    private List<T> value;

    public Box() {
        this.value = new ArrayList<>();
    }
    public void add(T value){
        this.value.add(value);
    }

    public void swap(int first ,int second){
        Collections.swap(this.value,first,second);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (T value : this.value) {
            output.append(String.format("%s: %s",value.getClass().getName(),value.toString())).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
