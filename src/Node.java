public class Node <T>{
    T data;
   Node<T> next;
    public Node(T data) {
        this.data=data; //1
        this.next = null; //1
        //o(1)
    }
    public T retrieve () {
        return data;
    }
}
