import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;

class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
public class TestMain {
    public static void main(String[] args) {
          A<String> a = new A("lxx");
          System.out.println(a.get());
          A<Integer> b = new A(3);
          System.out.println(b.get());
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
    }
}
