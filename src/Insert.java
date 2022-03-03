import java.util.*;
public class Insert {
    private int contador=0;
    public void sort(ArrayList<tripleta> tpt){

        for (int i=0; i < tpt.size () - 1; i++) //5OE
        {
            int largo = 0;//2 OE
            for (int j=largo + 1; j < tpt.size () - i; j++)//5
            {
                if ((tpt.get (largo)).compareTo(tpt.get (j)) < 0)//4OE
                {
                    largo = j;//1OE
                }
                this.contador=contador+10;
            }
            tripleta tempTrip = tpt.get (tpt.size () - 1 - i);//5OE
            tpt.set (tpt.size () - 1 - i, tpt.get (largo));//4OE
            tpt.set (largo, tempTrip);//1OE
            this.contador=contador+17;
        }
    }
    public int getContador(){
        return this.contador;
    }
}
