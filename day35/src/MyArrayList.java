public class MyArrayList<T> {
   private T[] elem;
   private int usedSize;

    public MyArrayList() {
        this.elem = (T[])new Object[10];
        this.usedSize = 0;
    }
    public T get(int index) {
        return this.elem[index];
    }
    public void add(T t) {
        this.elem[this.usedSize] = t;
        this.usedSize++;
    }
}
