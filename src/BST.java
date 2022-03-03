public class BST {

        private Node root;
        public BST(){
            this.root=null;
        }
        public BST(Node root){
            this.root=root;
        }
        public Node getRoot(){
            return this.root;
        }
        private Node insertRec(Node root, tripleta Value){
            if(root == null){
                root = new Node(Value);
                return root;
            }
            if(Value.getQuantity()< root.getValue().getQuantity()){
                root.setLeft(insertRec(root.getLeft(), Value));
            }else if(Value.getQuantity()>= root.getValue().getQuantity()){
                root.setRight(insertRec(root.getRight(),Value));
            }
            return root;
        }

        public void insert(tripleta Value){
            this.root=insertRec(this.root,Value);
        }

        private void inOrderRec(Node root, int value){
            if(root != null){
                this.inOrderRec(root.getLeft(),value);
                if(root.getValue().getQuantity() == value){
                    System.out.println(root.getValue().getCategory()+" "+root.getValue().getName());
                }
                this.inOrderRec(root.getRight(),value);
            }
        }

        public void inOrder(int value){
            this.inOrderRec(this.root, value);
        }

        private boolean getSearch(int value, Node root) {
            if(root == null) return false;

            boolean left = getSearch(value, root.getLeft());
            boolean right = getSearch(value, root.getRight());
            if(root.getValue().getQuantity() == value){
                System.out.println(root.getValue().getCategory()+" || "+root.getValue().getName());
                return true;
            }
            if(left){
                return true;
            }
            else if(right){
                return true;
            }else{
                return false;
            }
        }
         public boolean search(int value) {
            return this.getSearch(value, this.root);
        }private boolean getSearchMen(int value, Node root) {
        if(root == null) return false;

        boolean left = getSearchMen(value, root.getLeft());
        boolean right = getSearchMen(value, root.getRight());
        if(root.getValue().getQuantity() < value){
            System.out.println(root.getValue().getCategory()+" || "+root.getValue().getName());
            return true;
        }
        if(left){
            return true;
        }
        else if(right){
            return true;
        }else{
            return false;
        }
    }
    public boolean searchMen(int value) {
        return this.getSearchMen(value, this.root);

    }private boolean getSearchMay(int value, Node root) {
        if(root == null) return false;

        boolean left = getSearchMay(value, root.getLeft());
        boolean right = getSearchMay(value, root.getRight());
        if(root.getValue().getQuantity() > value){
            System.out.println(root.getValue().getCategory()+" || "+root.getValue().getName());
            return true;
        }
        if(left){
            return true;
        }
        else if(right){
            return true;
        }else{
            return false;
        }
    }
    public boolean searchMay(int value) {
        return this.getSearchMay(value, this.root);
    }



}

