import java.util.Arrays;

public class MyArrayList {
private int[] elem;
private int usedSize;
private static final int intCapacity = 10;
    public int[] getElem() {
        return elem;
    }
    public void setElem(int[] elem) {
        this.elem = elem;
    }
    public int getUsedSize() {
        return usedSize;
    }
    public void setUsedSize(int usedSize) {

        this.usedSize = usedSize;
    }
    public MyArrayList()  {
    this.elem = new int[intCapacity];
    this.usedSize = 0;
    }
    public boolean isFull() {
        return this.usedSize == elem.length;
    }
//添加数据
public void add(int pos,int data) {
    if(pos < 0 || pos > this.usedSize) {
        throw new RuntimeException("pos位置不合法");
    }
    if (isFull()) {
        this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
    }
    for (int i = this.usedSize-1; i >= pos; i--) {
        this.elem[i+1] = this.elem[i];
    }
        this.elem[pos] = data;
        this.usedSize++;
}
//打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
}
//判断是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
}
//查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        throw new RuntimeException("找不到");
    }
    private boolean isEmpty() {

        return this.usedSize == 0;
    }
    //获取pos位置的元素
    public int getPos(int pos) {
        if(isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        if(pos < 0 || pos>= this.usedSize) {
            throw new RuntimeException("pos位置不合法");
        }
        return this.elem[pos];
}
//删除第一次出现的关键字
    public void remove(int toRemove) {
        if(isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        int tmp = search(toRemove);
        for (int i = tmp; i < this.usedSize-1 ; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
}
//清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
    public void setPos(int pos,int value) {
        if(pos < 0 || pos >= this.usedSize) {
            throw new RuntimeException("pos位置不合法");
        }
        this.elem[pos] = value;
    }
}
