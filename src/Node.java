public class Node {

        private tripleta Value;
        private Node left;
        private Node right;

        public Node(tripleta Value) {
            this.Value = Value;
            this.left = null;
            this.right = null;
        }
        public Node(tripleta Value, Node left, Node right) {
            this.Value = Value;
            this.left = left;
            this.right = right;
        }

        public tripleta getValue() {
            return Value;
        }

        public void setValue(tripleta Value) {
            this.Value = Value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

}
