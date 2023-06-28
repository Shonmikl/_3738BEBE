import java.util.Stack;

public class Example1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.add(0);
        stack.add(-5);

        // push помещает элемент на вершину стека
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);

        // Доступ к элементу.
        // Чтобы получить или извлечь первый элемент стека или элемент, находящийся на вершине стека, мы можем
        // использовать метод peek(). Полученный элемент не удаляется и не удаляется из стека.
        System.out.println("First element in stack: " + stack.peek());

        // Удаление элементов.
        // Чтобы извлечь элемент из стека, мы можем использовать метод pop(). Элемент извлекается из вершины стека и удаляется из него.
        System.out.println("Element will be shown and deleted: " + stack.pop());
        System.out.println(stack);

        // empty() возвращает true, если на вершине стека ничего нет. В противном случае возвращает ложь.
        System.out.println(stack.empty());

        // Note -> Обратить внимание, что вершина в Стек это не нулевой индекс !!!
        System.out.println(stack.get(1));

        // search(Object e) определяет, существует ли объект в стеке.
        // Если элемент найден, возвращает позицию элемента с вершины стека. В противном случае он возвращает -1
        System.out.println(stack.search(-5));
    }
}
