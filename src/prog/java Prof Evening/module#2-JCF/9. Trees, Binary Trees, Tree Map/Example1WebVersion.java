import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
info: https://www.baeldung.com/java-binary-tree
code: https://github.com/eugenp/tutorials/blob/master/data-structures/src/main/java/com/baeldung/tree/BinaryTree.java
 */

public class Example1WebVersion {
    public static void main(String[] args) {
        BinaryTreeWeb bt = new BinaryTreeWeb();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        System.out.println(bt);

        System.out.print("Level Order: ");
        bt.traverseLevelOrderWeb();
        System.out.println();

        System.out.print("In order: ");
        bt.traverseInOrderWithoutRecursionWeb();
        System.out.println();

        System.out.print("Pre order: ");
        bt.traversePreOrderWithoutRecursionWeb();
        System.out.println();

        System.out.print("Post order: ");
        bt.traversePostOrderWithoutRecursionWeb();
        System.out.println();
    }
}

class NodeWeb {
    int value;
    NodeWeb left;
    NodeWeb right;

    NodeWeb(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

class BinaryTreeWeb {

    NodeWeb root;

    public void add(int value) {
        root = addRecursiveWeb(root, value);
    }

    private NodeWeb addRecursiveWeb(NodeWeb current, int value) {

        if (current == null)
            return new NodeWeb(value);

        if (value < current.value)
            current.left = addRecursiveWeb(current.left, value);
        else if (value > current.value)
            current.right = addRecursiveWeb(current.right, value);

        return current;
    }

    public boolean isEmptyWeb() {
        return root == null;
    }

    public int getSizeWeb() {
        return getSizeRecursiveWeb(root);
    }

    private int getSizeRecursiveWeb(NodeWeb current) {
        return current == null
                ? 0
                : getSizeRecursiveWeb(current.left) + 1 + getSizeRecursiveWeb(current.right);
    }

    public boolean containsNodeWeb(int value) {
        return containsNodeRecursiveWeb(root, value);
    }

    private boolean containsNodeRecursiveWeb(NodeWeb current, int value) {

        if (current == null)
            return false;

        if (value == current.value)
            return true;

        return value < current.value
                ? containsNodeRecursiveWeb(current.left, value)
                : containsNodeRecursiveWeb(current.right, value);
    }

    public void deleteWeb(int value) {
        root = deleteRecursiveWeb(root, value);
    }

    private NodeWeb deleteRecursiveWeb(NodeWeb current, int value) {

        if (current == null)
            return null;

        if (value == current.value) {

            // Case 1: no children
            if (current.left == null && current.right == null)
                return null;

            // Case 2: only 1 child
            if (current.right == null)
                return current.left;

            if (current.left == null)
                return current.right;

            // Case 3: 2 children
            int smallestValue = findSmallestValueWeb(current.right);
            current.value = smallestValue;
            current.right = deleteRecursiveWeb(current.right, smallestValue);
            return current;
        }

        if (value < current.value) {
            current.left = deleteRecursiveWeb(current.left, value);
            return current;
        }

        current.right = deleteRecursiveWeb(current.right, value);
        return current;
    }

    private int findSmallestValueWeb(NodeWeb root) {
        return root.left == null ? root.value : findSmallestValueWeb(root.left);
    }

    public void traverseInOrderWeb(NodeWeb node) {

        /*
        Алгоритм Inorder(tree)
        1. Пройти по левому поддереву, т.е. вызвать Inorder(left-subtree)
        2. Посетить корень.
        3. Пройти по правому поддереву, т.е. вызвать Inorder(right-subtree)
         */

        if (node != null) {
            traverseInOrderWeb(node.left);
            visitWeb(node.value);
            traverseInOrderWeb(node.right);
        }
    }

    public void traversePreOrderWeb(NodeWeb node) {

        /*
        Алгоритм предзаказа(дерево)
        1. Заходим в корень.
        2. Обходим левое поддерево, т. е. вызываем Preorder(left-subtree)
        3. Обходим правое поддерево, т. е. вызываем Preorder(right-subtree)
         */

        if (node != null) {
            visitWeb(node.value);
            traversePreOrderWeb(node.left);
            traversePreOrderWeb(node.right);
        }
    }

    public void traversePostOrderWeb(NodeWeb node) {

        /*
        Алгоритм Postorder(tree)
        1. Обход левого поддерева, т.е. вызов Postorder(left-subtree)
        2. Обход правого поддерева, т.е. вызов Postorder(right-subtree)
        3. Посещение корня.
         */

        if (node != null) {
            traversePostOrderWeb(node.left);
            traversePostOrderWeb(node.right);
            visitWeb(node.value);
        }
    }

    public void traverseLevelOrderWeb() {

        if (root == null)
            return;

        Queue<NodeWeb> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            NodeWeb node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null)
                nodes.add(node.left);

            if (node.right != null)
                nodes.add(node.right);
        }
    }

    public void traverseInOrderWithoutRecursionWeb() {
        Stack<NodeWeb> stack = new Stack<>();
        NodeWeb current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            NodeWeb top = stack.pop();
            visitWeb(top.value);
            current = top.right;
        }
    }

    public void traversePreOrderWithoutRecursionWeb() {
        Stack<NodeWeb> stack = new Stack<>();
        NodeWeb current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.pop();
            visitWeb(current.value);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    public void traversePostOrderWithoutRecursionWeb() {

        Stack<NodeWeb> stack = new Stack<>();
        NodeWeb prev = root;
        NodeWeb current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visitWeb(current.value);
                prev = current;
            } else {
                if (current.right != null)
                    stack.push(current.right);

                if (current.left != null)
                    stack.push(current.left);
            }
        }
    }

    private void visitWeb(int value) {
        System.out.print(" " + value);
    }
}