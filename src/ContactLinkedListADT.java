public class ContactLinkedListADT{
    Node<Contact> head;
    Node<Contact> current;
    public ContactLinkedListADT() {
        this.head = null;
        this.current = null;
    }

    public void add(Contact ItemToInsert){//not done yet
      if(head == null) current = head = new Node<Contact>(ItemToInsert);
      Node<Contact> temp = current.next;
      current.next = new Node<Contact> (ItemToInsert);
      current = current.next;
      current.next = temp;
    }
    public void remove (Node<Contact>item) {//remove at current which is item//not done yet
        current=item;
        if (current == head) {
            head = head.next;
        }
        else {
            Node<Contact> temp = head;

            while (temp.next != current)
                temp = temp.next;

            temp.next = current.next;
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;
    }

    public void SearchByName(String name ) {//not done yet
    }

    public void SearchByPhoneNumber(String PhoneNumber ){//not done yet
    }

    public void SearchByEmailAddress(String EmailAddress ){//not done yet
    }

    public void SearchByAddress(String Address ) {//not done yet
    }

    public Contact getElement(){
        return current.data;
    }

    public boolean hasNext() {
        return current.next != null;
    }

    public static void main(String[] args) {
        ContactLinkedListADT lists = new ContactLinkedListADT();
    }
    }//class