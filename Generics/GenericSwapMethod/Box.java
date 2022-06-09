package Generics.GenericSwapMethodString_03;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private final List<T> value;

    public Box() {
        this.value = new ArrayList<>();
    }

    public void add(T value) {
        this.value.add(value);
    }

    public void swap(int first, int second) {
        T current = this.value.get(first);
        this.value.set(first, this.value.get(second));
        this.value.set(second, current);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : value) {
            sb.append(String.format("%s: %s", t.getClass().getName(), t.toString())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
