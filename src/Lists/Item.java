package Lists;

public class Item <T extends Comparable<T>>{
    protected T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Item(T value) {
        this.value = value;
    }
}
