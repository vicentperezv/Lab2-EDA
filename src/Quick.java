import java.util.ArrayList;
public class  Quick {
    private int contador = 0;
    public void swap(ArrayList <tripleta> tpt, int i, int j)
    {

        tripleta temp = tpt.get(i);//3 OE
        tpt.set(i,tpt.get(j));//3 OE
        tpt.set(j,temp);// 2 OE
        this.contador = this.contador +8;
    }
    public int partition(ArrayList <tripleta> tpt, int low, int high) {
        tripleta pivot = tpt.get(high);//3 OE

        int i = (low - 1);//3OE

        for(int j = low; j <= high - 1;j++ ){// 5 OE
            if (tpt.get(j).getQuantity() > pivot.getQuantity()){//5OE _
                i++; // 1 OE
                swap(tpt, i, j);//1OE
            }
            this.contador = this.contador +12;
        }
        swap(tpt, i + 1, high); //1OE
        this.contador= this.contador+9;
        return (i + 1);//2OE
    }
    public void quickSort(ArrayList <tripleta> tpt, int low, int high) {
        if (low < high){// 1OE
            int pi = partition(tpt, low, high);//3OE

            quickSort(tpt, low, pi - 1);//1OE
            quickSort(tpt, pi + 1, high);//1OE
            this.contador=this.contador +6;
        }
    }
    public int getContador(){
        return this.contador;
    }
}
