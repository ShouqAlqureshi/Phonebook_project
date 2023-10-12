public class EventLinkedList {
    Node<Event> head;
    Node<Event> current;
    public EventLinkedList() {
        this.head = null; //1
        this.current = null; //1
        //o(1)
    }
        public void insertToSortedList(Event toBeSorted) {
    	Node<Event> unsortedElement= new Node<Event>(toBeSorted);
        if (this.head == null || this.head.data.comparing(unsortedElement.data) == 1 ||  this.head.data.comparing(unsortedElement.data) == 0) {//head.data >= unsortedElement.data
            unsortedElement.next = (Node<Event>) this.head;
            this.current = this.head;
            this.head = (Node<Event>) unsortedElement;
        }
        else {
        	this.current = this.head;
            while (this.current.next != null &&   this.head.data.comparing(unsortedElement.data) == -1 ){//current.next.data < unsortedElement.data
            	this.current = this.current.next;//to check sorting
            }
            unsortedElement.next = (Node<Event>) this.current.next;
            this.current.next = (Node<Event>) unsortedElement;
            this.current = this.current.next;
        }	
    }
}
