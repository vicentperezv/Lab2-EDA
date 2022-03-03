public class tripleta implements Comparable {
    private String name;
    private String category;
    private int quantity;

    public tripleta(String nombre, String categoria){
        name = nombre;
        category = categoria;
        quantity = 1;
    }
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }
    public int getQuantity(){
        return quantity;
    }
    public void incQuantity(){
        quantity = quantity + 1;
    }
    @Override
    public int compareTo(Object t2)
    {
        int t2count = ((tripleta)t2).getQuantity();
        return t2count - this.getQuantity();
    }
}
