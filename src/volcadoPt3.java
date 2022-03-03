import java.util.*;
import java.io.*;
public class volcadoPt3 {
    private String[] files ;
    private  ArrayList<tripleta> tripletas;




    public volcadoPt3(){
        files = new String[]{"./mx-amazon-devices.csv", "./mx-automotive.csv", "./mx-baby.csv", "./mx-books.csv",
                "./mx-digital-text.csv", "./mx-dvd.csv", "./mx-electronics.csv", "./mx-grocery.csv",
                "./mx-handmade.csv", "./mx-hpc.csv", "./mx-kitchen.csv", "./mx-music.csv",
                "./mx-musical-instruments.csv", "./mx-officeproduct.csv","./mx-pet-supplies.csv",
                "./mx-shoes.csv", "./mx-software.csv", "./mx-sports.csv", "./mx-tools.csv",
                "./mx-toys.csv", "./mx-videogames.csv"};
        tripletas = new ArrayList<>();
    }
    public void toMaxPQ(){

        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("MaxPQ_out.txt",false));
            BufferedReader reader;
            for (String fl : files) {
                ArrayList<tripleta> tripletas = new ArrayList<>();
                ArrayList<ArrayList<String>> dataset = new ArrayList<>();
                String category = fl.substring(5, fl.length() - 4);
                reader = new BufferedReader(new FileReader(fl));

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
                Heap MaxPQ = new Heap();
                for(tripleta tpt: tripletas){
                    MaxPQ.insert(tpt);
                }
                int cout=0;
                int aux = MaxPQ.size();
                writer.write("Los tres mas y menos vendidos de "+ category+":" +"\n");
                while(!MaxPQ.empty()){
                    tripleta tmp = MaxPQ.delMax();
                    if(cout < 3){
                        writer.write(tmp.getCategory()+"||"+tmp.getName()+"||"+tmp.getQuantity()+ "\n");
                    }
                    if(cout >= aux-3){
                        writer.write(tmp.getCategory()+"||"+tmp.getName()+"||"+tmp.getQuantity()+ "\n");
                    }
                    cout++;
                }
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void print(){
        for (tripleta t : this.tripletas) {
            System.out.println(t.getCategory()+"||"+t.getName()+"||"+t.getQuantity());
        }
    }


}
