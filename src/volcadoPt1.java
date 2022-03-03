import java.util.*;
import java.io.*;
public class volcadoPt1 {
    private String files ;
    private  ArrayList<tripleta> tripletas;
    private Insert ordenamiento;
    private Quick quick;
    private HeapSort HS;



    public volcadoPt1(){
        files = "./mx-amazon-devices.csv";
        tripletas = new ArrayList<>();
        ordenamiento = new Insert();
        quick= new Quick();
        HS = new HeapSort();

    }

    private void toTripletasDevices(){
        try {
            BufferedReader reader;

            ArrayList<ArrayList<String>> dataset = new ArrayList<>();
            String category = files.substring(5, files.length() - 4);
            reader = new BufferedReader(new FileReader(files));

            String line = reader.readLine();

            while (line != null){
                ArrayList<String> parsing1 = new ArrayList<>();
                String[] row1;
                row1 = line.split("\\|",-1);
                for(String x : row1){
                    parsing1.add(x);
                }
                dataset.add(parsing1);
                line = reader.readLine();
            }
            for(int progress_index = 1; progress_index < dataset.size(); progress_index++){
                String prod_name = dataset.get(progress_index).get(3);
                boolean found = false;
                for(tripleta search : tripletas){
                    if(search.getName().equals(prod_name)){
                        found = true;
                        search.incQuantity();
                    }
                }
                if(found != true){
                    tripleta new_tripleta = new tripleta(prod_name, category);
                    tripletas.add(new_tripleta);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void intSort(){
        this.toTripletasDevices();
        long startTime = System.nanoTime();
        ordenamiento.sort(tripletas);
        long endTime = System.nanoTime();
        System.out.println("Duración Insertion Sort: " + (endTime-startTime)/1e6 + " ms");
        System.out.println("Operaciones fundamentales Insertion Sort: "+ ordenamiento.getContador());
    }

    public void quickSort(){
        this.toTripletasDevices();
        long startTime = System.nanoTime();
        this.quick.quickSort(this.tripletas,0, this.tripletas.size()-1);
        long endTime = System.nanoTime();
        System.out.println("Duración Quick Sort: " + (endTime-startTime)/1e6 + " ms");
        System.out.println("Operaciones fundamentales Quick Sort: "+ quick.getContador());
    }
    public void HeapSort(){
        this.toTripletasDevices();
        long startTime = System.nanoTime();
        this.HS.sort(this.tripletas);
        long endTime = System.nanoTime();
        System.out.println("Duración HeapSort: " + (endTime-startTime)/1e6 + " ms");
        System.out.println("Operaciones fundamentales Heap Sort: "+ HS.getContador());
    }
    public void print(){
        for (tripleta t : this.tripletas) {
            System.out.println(t.getCategory()+"||"+t.getName()+"||"+t.getQuantity());
        }
    }
}
