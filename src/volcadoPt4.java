import java.util.*;
import java.io.*;

public class volcadoPt4 {
    private String[] files ;
    private  ArrayList<tripleta> tripletas;
    private BST BST;


    public volcadoPt4(){
        files = new String[]{"./mx-amazon-devices.csv", "./mx-automotive.csv", "./mx-baby.csv", "./mx-books.csv",
                "./mx-digital-text.csv", "./mx-dvd.csv", "./mx-electronics.csv", "./mx-grocery.csv",
                "./mx-handmade.csv", "./mx-hpc.csv", "./mx-kitchen.csv", "./mx-music.csv",
                "./mx-musical-instruments.csv", "./mx-officeproduct.csv","./mx-pet-supplies.csv",
                "./mx-shoes.csv", "./mx-software.csv", "./mx-sports.csv", "./mx-tools.csv",
                "./mx-toys.csv", "./mx-videogames.csv"};
        tripletas = new ArrayList<>();
        BST = new BST();
    }

    private void toBST() {

        try {
            BufferedReader reader;
            for (String fl : files) {
                ArrayList<ArrayList<String>> dataset = new ArrayList<>();
                String category = fl.substring(5, fl.length() - 4);
                reader = new BufferedReader(new FileReader(fl));

                String line = reader.readLine();

                while (line != null) {
                    ArrayList<String> parsing1 = new ArrayList<>();
                    String[] row1;
                    row1 = line.split("\\|", -1);
                    for (String x : row1) {
                        parsing1.add(x);
                    }
                    dataset.add(parsing1);
                    line = reader.readLine();
                }
                for (int progress_index = 1; progress_index < dataset.size(); progress_index++) {
                    String prod_name = dataset.get(progress_index).get(3);
                    boolean found = false;
                    for (tripleta search : tripletas) {
                        if (search.getName().equals(prod_name)) {
                            found = true;
                            search.incQuantity();
                        }
                    }
                    if (found != true) {
                        tripleta new_tripleta = new tripleta(prod_name, category);
                        tripletas.add(new_tripleta);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.toBinaryTree();
    }


    public void print(){
        for (tripleta t : this.tripletas) {
                System.out.println(t.getCategory()+"||"+t.getName()+"||"+t.getQuantity());
            }
    }
    private void toBinaryTree(){
        for (tripleta t : this.tripletas){
            this.BST.insert(t);
        }
    }

    private void Search(int Value){
        if(!BST.search(Value)){
            System.out.println("Ningun producto");
        }
    }
    private void SearchMay(int Value){
        if(!BST.searchMay(Value)){
            System.out.println("Ningun producto");
        }
    }
    private void SearchMen(int Value){
        if(!BST.searchMen(Value)){
            System.out.println("Ningun producto");
        }
    }
    public void userInterface(){
        Scanner input = new Scanner(System.in);
        System.out.println("Espere por favor... ");
        this.toBST();
        boolean aux = false;
        while(!aux){

            System.out.println("Escoga una de las siguientes opciones: ");
            System.out.println("1. Todos los productos mas vendidos que cierta unidad: ");
            System.out.println("2. Todos los productos menos vendidos que cierta unidad: ");
            System.out.println("3. Todos los productos exactamente vendidos: ");
            System.out.println("4. Salir");
            int opcion = input.nextInt();
            if(opcion == 1){
                System.out.println("Por favor, ingrese un numero: ");
                int n = input.nextInt();
                this.SearchMay(n);
            }else if(opcion == 2){
                System.out.println("Por favor, ingrese un numero: ");
                int n = input.nextInt();
                this.SearchMen(n);
            }else if(opcion==3){
                System.out.println("Por favor, ingrese un numero: ");
                int n = input.nextInt();
                this.Search(n);
            }else if(opcion == 4){
                aux = true;
            }else{
                System.out.println("Ingrese una opcion valida");
            }
        }
    }

}
