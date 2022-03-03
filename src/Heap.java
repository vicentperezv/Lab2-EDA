import java.util.ArrayList;

public class Heap{
    private tripleta[] data;
    private int cantidad;
    private int size =10;

    public Heap(){
        this.data = new tripleta[this.size];
        this.cantidad = 0;

    }
    private boolean less(int i, int j){
         return this.data[i].compareTo(this.data[j])>0;
    }
    private void exch(int i, int j){
       tripleta tmp = this.data[i];
        this.data[i]=this.data[j];
        this.data[j]=tmp;
    }
    private void swim(int k){
        while(k>1 && this.less(k/2,k)){
            this.exch(k/2,k);
            k /=2;
        }
    }
    private void sink(int k){
        while(2*k <= this.cantidad){
            int j = 2*k;
            if(j < this.cantidad && this.less(j, j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }
    private void realloc(){
        this.size *= 2;
        tripleta[] data1 = new tripleta[this.size];
        for(int i=0; i <= this.cantidad; i++){
            data1[i] = this.data[i];
        }
        this.data = data1;
    }
    public void insert(tripleta palabra){
        if((this.cantidad + 1) >= this.size) this.realloc();
        this.data[++this.cantidad] = palabra;
        this.swim(this.cantidad);
    }
    public tripleta delMax(){
        tripleta tmp = this.data[1];
        this.exch(1,this.cantidad--);
        this.sink(1);
        return tmp;
    }

    public int size() {
        return cantidad;
    }

    public boolean empty(){
        return this.cantidad == 0;
    }
    public void sort(ArrayList<tripleta> tpts){
        int n =tpts.size()-1;

        for(int i = n; i>=0;i--){
            tpts.set(i,this.delMax());
        }
    }
}
