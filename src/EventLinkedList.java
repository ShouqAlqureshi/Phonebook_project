public class EventLinkedList {
    Node<Event> head;

    Node<Event> current;

    public EventLinkedList() {
        this.head = null;
        this.current = null;
    }
    public void insertToSortedList(Event toBeSorted) {
        Node<Event> unsortedElement = new Node<Event>(toBeSorted);
        if (this.head == null || this.head.data.comparing(unsortedElement.data) == 1 ||  this.head.data.comparing(unsortedElement.data) == 0) {//head.data >= unsortedElement.data
            unsortedElement.next = this.head;
            this.current = this.head;
            this.head = unsortedElement;
        }
        else {
        	this.current = this.head;
            while (this.current.next != null && this.head.data.comparing(unsortedElement.data) == -1 ){//current.next.data < unsortedElement.data
            	this.current = this.current.next;//to check sorting
            }
            unsortedElement.next = this.current.next;
            this.current.next = unsortedElement;
            this.current = this.current.next;
        }	
    }

}//class