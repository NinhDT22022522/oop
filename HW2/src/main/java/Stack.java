public class Stack<Item> {
    private Node head = null;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(Item item){
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
    }

    public Item pop(){
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        Item res = head.item;
        head = head.next;
        return res;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("Hello");
        String s = (String) stack.pop();

        if (stack.isEmpty()){
            System.out.println("True");
        }else System.out.println("False");
    }
}
