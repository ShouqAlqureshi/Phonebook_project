public class Node <T>{
    T data;
   Node<T> next;
    public Node(T data) {
        this.data=data; //1
        this.next = null; //1
        //o(1)
    }

    public String  retrieve(){
        return ""; //1
        //o(1)
    }//just to solve errors
}
