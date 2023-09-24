public class EventLinkedList<T> {
    Node<T> head;//the class will be changed from generic to event after event class is implemented by leen
    Node<T> current;
    public EventLinkedList() {
        this.head = null;
        this.current = null;
    }
}
