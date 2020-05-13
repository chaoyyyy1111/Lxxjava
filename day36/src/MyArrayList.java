import java.util.Arrays;

public class MyArrayList {
    private int[] elem;
    private int usedSize;
    public MyArrayList() {
    this.elem = new int[30];
    this.usedSize = 0;
}

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public void add(int pos,int val) throws RuntimeException{
        if(pos < 0 || pos > usedSize) {
            throw new RuntimeException("pos不合法");
        }
        if(this.elem.length == usedSize) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        for (int i = usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = val;
        this.usedSize++;
    }
    public void display() {
        for (int i = 0; i < usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    public boolean contains(int val) {
        for (int i = 0; i < usedSize; i++) {
            if(this.elem[i] == val) {
                return true;
            }
        }
        return false;
    }
    public int Search(int val) {
        for (int i = 0; i < usedSize; i++) {
            if(this.elem[i] == val) {
                return i;
            }
        }
        return -1;
    }
    public int getPos(int pos) throws RuntimeException {
        if(this.usedSize == 0) {
            throw new RuntimeException("顺序表为空");
        }
        if(pos < 0 || pos >= usedSize) {
            throw new RuntimeException("pos位置不合法");
        }
        return this.elem[pos];
    }
    public void Remove(int toRemove) throws RuntimeException {
        if(this.usedSize == 0) {
            throw new RuntimeException("顺序表为空");
        }
        int index = Search(toRemove);
        if(index == -1) {
            throw new RuntimeException("不存在要删除的数字");
        }
        for (int i = index; i < usedSize-1 ; i++) {
            this.elem[i] = this.elem[i+1];
            this.usedSize--;
        }
    }
    public void clear() {
        this.usedSize = 0;
    }
    public void setPos(int pos,int val) throws RuntimeException {
        if(pos < 0 || pos >= this.usedSize) {
            throw new RuntimeException("pos位置不合法");
        }
        this.elem[pos] = val;
    }

}
