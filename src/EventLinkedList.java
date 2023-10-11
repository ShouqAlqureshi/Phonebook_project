public class EventLinkedList<Event> {
    Node<Event> head;
    Node<Event> current;
    public EventLinkedList() {
        this.head = null; //1
        this.current = null; //1
        //o(1)
    }

        public void insertToSortedList(Event toBeSorted) {
    	Node<Event> unsortedElement= new Node<Event>(toBeSorted);
        if (this.head == null || ((Event) this.head.data).getTitle().compareTo(unsortedElement.data.title) == 1 || ((Event) this.head.data).getTitle().compareTo(unsortedElement.data.title) == 0) {//head.data >= unsortedElement.data
            unsortedElement.next = (Node<Event>) this.head;
            this.current = this.head;
            this.head = (Node<T>) unsortedElement;
        }
        else {
        	this.current = this.head;
            while (this.current.next != null && ((Event) this.head.data).getTitle().compareTo(unsortedElement.data.title) == -1 ){//current.next.data < unsortedElement.data
            	this.current = this.current.next;//to check sorting
            }
            unsortedElement.next = (Node<Event>) this.current.next;
            this.current.next = (Node<T>) unsortedElement;
            this.current = this.current.next;
        }	
    }
}
