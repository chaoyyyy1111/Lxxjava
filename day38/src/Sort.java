public class Sort {
public void insertSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
        int tmp = array[i];
        int j = i-1;
        for (; j >= 0 ; j--) {
            if(array[j] > tmp) {
                array[j+1] = array[j];
            } else {
                break;
            }
            array[j+1] = tmp;
        }
    }
}
public void shellSort(int[] array ,int gap) {
    for (int i = gap; i < array.length ; i++) {
        int tmp = array[i];
        int j = i-gap;
        for(;j >= 0;j-=gap) {
            if(array[j] > tmp) {
                array[j+gap] = array[j];
            } else {
                break;
            }
        }
        array[j+gap] = tmp;
    }
}
public void selectSort(int[] array) {
    for (int i = 0; i < array.length-1; i++) {
        for (int j = i+1; j < array.length ; j++) {
            if(array[i] > array[j]) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }
}
public void adjustDown(int[] array,int root,int len) {
    int parent = root;
    int child = 2*parent + 1;
    while(child < len) {
        if(child + 1 < len && array[child + 1] > array[child]) {
            child++;
        }
        if(array[parent] > array[child]) {
            int tmp = array[parent];
            array[parent] = array[child];
            array[child] = tmp;
            parent = child;
            child = 2*parent + 1;
        } else {
            break;
        }
    }

}
public void createHeap(int[] array) {
    for (int i = (array.length-2)/2; i >= 0 ; i--) {
        adjustDown(array,i,array.length);
    }
}
public void heapSort(int[] array) {
    int end = array.length-1;
    while(end > 0) {
        int tmp = array[0];
        array[0] = array[end];
        array[end] = tmp;
        adjustDown(array,0,end);
        end--;
    }
}
public void bubbleSort(int[] array) {
    for (int i = 0; i < array.length-1 ; i++) {
        boolean flag = true;
        for (int j = 0; j < array.length-1-i; j++) {
            if(array[j] > array[j+1]) {
                int tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
                flag = false;
            }
        }
        if(flag) {
            break;
        }
    }
}
}
