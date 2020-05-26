import java.util.Stack;

public class TestSort {
    public int partition(int[] array,int left,int right) {
        int tmp = array[left];
        while(left < right) {
            while(left < right && array[right] >= tmp) {
                right--;
            }
            array[left] = array[right];
            while(left < right && array[left] <= tmp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        return left;
    }
    public void insert_Sort(int[] array,int start,int end) {
        for (int i = start+1; i <= end ; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= start; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public void three_num(int[] array,int left,int right) {
        int mid = (left + right)/2;
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
    public void quick(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        if(right - left + 1 <= 100) {
            insert_Sort(array, left, right);
            return;
        }
        three_num(array,left,right);
        int par = partition(array,left,right);
        quick(array,left,par-1);
        quick(array,par+1,right);
    }
    public void quickSort(int[] array) {
    quick(array,0,array.length-1);
}
    public void quickSort1(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length-1;
        stack.push(left);
        stack.push(right);
        while(!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            int par = partition(array,left,right);
            if(left + 1 < par) {
                stack.push(left);
                stack.push(par-1);
            }
            if(par + 1 < right) {
                stack.push(par+1);
                stack.push(right);
            }
        }
    }
    public static void merge(int[] array,int left,int mid,int right) {
        int s1 = left;
        int s2 = mid+1;
        int len = right-left+1;
        int[] ret = new int[len];
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
    public static void mergeInternal(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right)>>>1;
        mergeInternal(array,left,mid);
        mergeInternal(array,mid+1,right);
        merge(array,left,mid,right);
}
    public static void mergeSort(int[] array) {
        mergeInternal(array,0,array.length-1);
}
    public int carFleet(int target, int[] position, int[] speed) {
        double[] cars = new double[position.length];
        int k = 0;
        for(int i = 0;i < position.length;i++) {
            cars[k++] = (target - position[i])*1.0/speed[i];
        }
        for(int i = 1;i < position.length;i++) {
            int tmp = position[i];
            double t = cars[i];
            int j = i - 1;
            for(;j >= 0;j--) {
                if(position[j] > tmp) {
                    position[j+1] = position[j];
                    cars[j + 1] = cars[j];
                } else {
                    break;
                }
            }
            position[j+1] = tmp;
            cars[j+1] = t;
        }

        int count = 1;
        double pre = cars[cars.length-1];
        for(int i = cars.length-2;i >= 0;i--) {
            if(cars[i] > pre) {
                count++;
            }
            pre = cars[i];
        }
        return count;
    }
    public void mergeSort1(int[] array) {
        for (int gap = 1; gap < array.length; gap*=2) {
            mergeNor(array,gap);
        }
    }
    public void mergeNor(int[] array,int gap) {
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1 : array.length-1;
        int[] ret = new int[array.length];
        int k = 0;
        while(s2 < array.length) {
            while(s1 <= e1 && s2 <= e2) {
                if(array[s1] <= array[s2]) {
                    ret[k++] = array[s1++];
                } else {
                    ret[k++] = array[s2++];
                }
            }
            while(s1 <= e1) {
                ret[k++] = array[s1++];
            }
            while(s2 <= e2) {
                ret[k++] = array[s2++];
            }
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1 +1;
            e2 = s2+gap-1 < array.length ? s2+gap-1 : array.length-1;
        }
        while(s1 < array.length) {
            ret[k++] = array[s1++];
        }
        for (int i = 0; i < ret.length ; i++) {
            array[i] = ret[i];
        }
    }

}
