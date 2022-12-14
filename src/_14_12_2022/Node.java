package _14_12_2022;

public class Node {

    public Integer value;
    public Node left;
    public Node right;

    private static boolean isNodeExist(Node node) {
        return node != null && node.value != null;
    }

    //root
    private static void createNode(Node node, int value) {
        node.left = new Node();
        node.right = new Node();
        node.value = value;
    }

    private static void insert(Node node, int value) {
        if (!isNodeExist(node)) {
            createNode(node, value);
        } else if (value < node.value) {
            insert(node.left, value);
        } else {
            insert(node.right, value);
        }
    }

    //todo
    private static Node search(Node node, int value) {
        return null;
    }

    private static Node getMin(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if ((!isNodeExist(node.left))) {
            return node;
        }
        return getMin(node.left);
    }

    //todo
    private static Node getMax(Node node) {
        return null;
    }

    //симметричный обход
    private static void inOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println("[ " + node + " ]");
        inOrderTraversal(node.right);
    }

    //todo
    //обратный обход
    private static void postOrderTraversal(Node node) {
        //вот тут написать метод
    }

    //todo
    //прямой обход
    private static void directOrderTraversal(Node node) {
        //вот тут написать метод
    }

    //todo
    private static void moveNode(Node toNode, Node fromNode) {
        //вот тут написать метод
    }

    //todo
    private static int getChildrenCount(Node node) {
        //вот тут написать метод
        return 0;
    }

    //todo
    private static Node getChildOrNull(Node node) {
        //вот тут написать метод
        return null;
    }

    private static void removeNodeWithOneOrZeroChild(Node nodeToDelete) {
        Node childOrNull = getChildOrNull(nodeToDelete);
        moveNode(nodeToDelete, childOrNull);
    }

    //todo
    private static boolean remove(Node root, int value) {
        return false;
    }

    public static void main(String[] args) {
        Integer[] digit = {9, 2, 5, 13, 6, 10, 14, 7, 33, 44, 3};
        Node node = new Node();
        createNode(node, 9);
        for (int i = 1; i < digit.length; i++) {
            insert(node, digit[i]);
        }
        inOrderTraversal(node);
        remove(node, 10);
        System.out.println();
        inOrderTraversal(node);
    }
}