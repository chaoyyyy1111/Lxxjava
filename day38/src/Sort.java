import java.util.Arrays;
import java.util.Stack;

public class Sort {
    public static void insertSort(int[] array) {
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
public static void insert_Sort(int[] array,int start,int end) {
            for (int i = start+1; i <= end ; i++) {
                int tmp = array[start+1];
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
        public static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        }
        public static void three_num(int[] array,int left,int right) {
        int mid = (left+right)>>>1;
        if(array[mid] > array[left]) {
           swap(array,mid,left);
        }
        if(array[mid] > array[right]) {
            swap(array,mid,right);
        }
        if(array[left] > array[right]) {
            swap(array,left,right);
        }
        }
        public static int partition(int[] array,int low,int high) {
        int tmp = array[low];
        while(low < high) {
            while(low < high && array[high] >= array[low]) {
                high--;
            }
            array[low] = array[high];
            while(low < high && array[low] <= array[high]) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
     }
     public static void quick(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        if(right-left+1 <= 100) {
            insert_Sort(array,left,right);
            return;
        }
        three_num(array,left,right);
        int par = partition(array,left,right);
        quick(array,left,par-1);
        quick(array,par+1,right);
     }
     public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
     }
     public static void quickSort1(int[] array) {
         Stack<Integer> stack = new Stack<>();

         int left = 0;
         int right = array.length-1;

         int par = partition(array,left,right);

         if(par > left+1) {
             stack.push(left);
             stack.push(par-1);
         }
         if(par < right-1) {
             stack.push(par+1);
             stack.push(right);
         }
         while (!stack.empty()) {
             right = stack.pop();
             left = stack.pop();
             par = partition(array, left, right);

             if (par > left + 1) {
                 stack.push(left);
                 stack.push(par - 1);
             }
             if (par < right - 1) {
                 stack.push(par + 1);
                 stack.push(right);
             }
         }
     }
     public void merge(int[] array,int left,int mid,int right) {
          int s1 = left;
          int s2 = mid+1;
          int[] ret = new int[right-left+1];
          int i = 0;
          while(s1 <= mid && s2 <= right) {
              if(array[s1] <= array[s2]) {
                  ret[i++] = array[s1++];
              } else {
                  ret[i++] = array[s2++];
              }
          }
          while(s1 <= mid) {
              ret[i++] = array[s1++];
          }
          while(s2 <= right) {
              ret[i++] = array[s2++];
          }
         for (int j = 0; j < ret.length ; j++) {
             array[j+left] = ret[j];
         }
     }
     public void mergeSortInternal(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) /2;
        mergeSortInternal(array,left,mid);
        mergeSortInternal(array,mid+1,right);
        merge(array,left,mid,right);
    }
     public void mergeSort(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }
    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));

    }
}
