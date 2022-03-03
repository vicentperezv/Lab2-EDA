import java.util.*;

public class HeapSort {
    private int contador=0;
    public void sort(ArrayList<tripleta> arr)
    {
        int n = arr.size(); //3 OE

        for (int i = n / 2 - 1; i >= 0; i--) {//5OE
            heapify(arr, n, i);//1OE
            this.contador= this.contador +6;
        }
        for (int i = n - 1; i > 0; i--) {//5OE

            tripleta temp = arr.get(0); //3OE
            arr.set(0,arr.get(i)); //3OE
            arr.set(i,temp);//2OE
            heapify(arr, i, 0);//1OE
            this.contador=this.contador+14;
        }
    }

    void heapify(ArrayList<tripleta> arr, int n, int i)
    {
        int largest = i;//2OE
        int l = 2 * i + 1; //4OE
        int r = 2 * i + 2;//4OE

        if (l < n && arr.get(l).getQuantity()<arr.get(largest).getQuantity())//7OE
            largest = l;//1OE

        if (r < n && arr.get(r).getQuantity()<arr.get(largest).getQuantity())//7OE
            largest = r;//1OE

        if (largest != i) { // 1 OE
            tripleta swap = arr.get(i);//3OE
            arr.set(i,arr.get(largest));//3OE
            arr.set(largest,swap);//2OE

            heapify(arr, n, largest);//1OE
        }
        this.contador=this.contador+36;
    }

    public int getContador() {
        return contador;
    }
}
