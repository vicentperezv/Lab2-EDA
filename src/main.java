public class main {
    public static void main(String[] args) {
        volcadoPt1 ins = new volcadoPt1();
        volcadoPt1 quick = new volcadoPt1();
        volcadoPt1 heap = new volcadoPt1();
        volcadoPt3 MaxPQ = new volcadoPt3();
        volcadoPt4 BST = new volcadoPt4();

        ins.intSort();
        quick.quickSort();
        heap.HeapSort();
        MaxPQ.toMaxPQ();
        BST.userInterface();


    }
}
