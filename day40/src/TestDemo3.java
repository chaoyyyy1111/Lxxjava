import java.util.ArrayList;

class Generic {
    public static <T extends Comparable<T>> T max(T[] array) {
        T tmp = array[0];
        for (int i = 1; i <array.length; i++) {
            if(array[i].compareTo(tmp) > 0) {
                tmp = array[i];
            }
        }
        return tmp;
    }
    public static <T> void Print(T[] array) {
        for (T val:array) {
            System.out.print(val + " ");

        }
        System.out.println();
    }
    public static <T> void Print1(ArrayList<T> list) {
        for (T val:list) {
            System.out.print(val + " ");

        }
        System.out.println();
    }
}
public class TestDemo3 {
    public static void main(String[] args) {
        Integer[] array = {3,2,4,5,10};
        //Generic<Integer> generic = new Generic<>();
        //System.out.println(generic.max(array));
        System.out.println(Generic.max(array));
        Generic.Print(array);
        String[] arr = {"hello","world","bit"};
        Generic.Print(arr);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("baby");
        Generic.Print1(arrayList);


    }
}
