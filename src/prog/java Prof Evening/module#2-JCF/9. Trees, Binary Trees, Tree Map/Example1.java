/*
BinaryTree
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Example1 {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

        bt.insert(1, "node 1");
        bt.insert(2, "node 2");
        bt.insert(3, "node 3");
        bt.insert(4, "node 4");
        bt.insert(5, "node 5");

        bt.print();

    }
}

class Node {
    private int key;
    private String value;
    private Node left;
    private Node right;

    public void printNode() {
        System.out.println(value);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

class BinaryTree {
    private Node root;

    public Node find(int key) {
        Node current = root;                                // начинаем поиск с корневого узла

        while (current.getKey() != key) {                   // поиск покуда не будет найден элемент или не будут перебраны все
            if (current.getKey() < key)                     // движение влево?
                current = current.getLeft();
            else
                current = current.getRight();               // движение вправо

            if (current == null)                            // если потомка нет
                return null;
        }
        return current;
    }

    public void insert(int key, String value) {
        Node newNode = new Node();                          // создание нового узла
        newNode.setKey(key);
        newNode.setValue(value);

        if (root == null)                                   // если корневой узел не существует
            root = newNode;                                 // то новый элемент и есть корневой узел
        else {                                              // корневой узел занят
            Node current = root;
            Node parent = null;

            while (true) {                                  // мы имеем внутренний выход из цикла

                parent = current;

                if (key == current.getKey())                // если такой элемент в дереве уже есть, не сохраняем его
                    return;                                 // просто выходим из него

                else if (key < current.getKey()) {          // движение влево
                    current = current.getLeft();
                    if (current == null) {                  // если был достигнут конец цепочки
                        parent.setLeft(newNode);            // то вставить слева и выйти из методы
                        return;
                    }
                } else {                                    // или направо?
                    current = current.getRight();
                    if (current == null) {                  // если был достигнут конец цепочки
                        parent.setRight(newNode);           // то вставить справа
                        return;                             // и выйти
                    }
                }
            }
        }
    }

    public void print(Node node) {
        if (node != null) {
            print(node.getLeft());
            node.printNode();
            print(node.getRight());
        }
    }

    public void print() {                                   // метод для вывода дерева в консоль
        Stack<Node> globalStack = new Stack<>();            // общий стек для значений дерева
        globalStack.push(root);

        int gaps = 32;                                      // начальное значение расстояния между элементами
        boolean isRowEmpty = false;

        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);                      // черта для указания начала нового дерева

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();         // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');

            while (!globalStack.isEmpty()) {                // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop();       // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue());      // выводим его значение в консоли
                    localStack.push(temp.getLeft());   // сохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");                 // - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;                                      // при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());    // перемещаем все элементы из локального стека в глобальный
            }
        }
        System.out.println(separator);                      // подводим черту
    }

    public Node getRoot() {
        return root;
    }
}

class Util {
    public static void breadthFirstSearch(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.getValue() + " ");

            /*Enqueue left child */
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }

            /*Enqueue right child */
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
    }

    public static void depthPostorder(Node node) {
        if (node == null)
            return;

        // first recur on left subtree
        depthPostorder(node.getLeft());

        // then recur on right subtree
        depthPostorder(node.getRight());

        // now deal with the node
        System.out.print(node.getValue() + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    public static void depthInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        depthInorder(node.getLeft());

        /* then print the data of node */
        System.out.print(node.getValue() + " ");

        /* now recur on right child */
        depthInorder(node.getRight());
    }

    public static void depthInorderStack(Node node) {
        if (node == null)
            return;


        Stack<Node> s = new Stack<>();
        Node current = node;

        // traverse the tree
        while (current != null || !s.isEmpty()) {

            /* Reach the left most Node of the
            curr Node */
            while (current != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(current);
                current = current.getLeft();
            }

            /* Current must be NULL at this point */
            current = s.pop();

            System.out.print(current.getValue() + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            current = current.getRight();
        }
    }

    /* Given a binary tree, print its nodes in preorder*/
    public static void depthPreorder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.getValue() + " ");

        /* then recur on left subtree */
        depthPreorder(node.getLeft());

        /* now recur on right subtree */
        depthPreorder(node.getRight());
    }
}