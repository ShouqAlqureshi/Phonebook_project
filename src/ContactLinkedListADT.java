public class ContactLinkedListADT{
    Node<Contact> head;
    Node<Contact> current;
    public ContactLinkedListADT() {
        this.head = null;
        this.current = null;
    }

    public void add(Contact contactToInsert){//not done yet
         isUniqueContact(contactToInsert);
         if(head == null) {
             current = head = new Node<Contact>(contactToInsert);
         }
        Node<Contact> temp = current.next;
        current.next = new Node<Contact> (contactToInsert);
        current = current.next;
        current.next = temp;
        sort(this);
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

    public Contact SearchByName(phoneBook list, String name ) {//done, need test
    	if ( head != null) {
    		Node<Contact> tmp= head;
    		while(current.next!=null) {
    			if (tmp.data.getName().equals(name))
    				return tmp.data;
    			tmp=tmp.next;
    		}
    	}
    	return null;
    }

    public Contact SearchByPhoneNumber(phoneBook list, String PhoneNumber ){//not done yet
    	if ( head != null) {
    		Node<Contact> tmp= head;
    		while(current.next!=null) {
    			if (tmp.data.getName().equals(PhoneNumber))
    				return tmp.data;
    			tmp=tmp.next;
    		}
    	}
    	return null;
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

    public void sort(ContactLinkedListADT list) {//not done yet
        Contact temp;
        if (list.head.next == null){
            System.out.println("only one element in list ");
            return;
        }else{
            list.head=list.current;
            while(list.hasNext()){
                Contact pre = list.current.data;
                Contact cur = list.current.next.data;
                if (pre.compareTo(cur) == 1){//shifting
                    temp=pre;
                    pre=cur;
                    cur=temp;
                }
                list.current = list.current.next;
            }

        }
    }
    public boolean isUniqueContact(Contact contact){
        this.head=this.current;
        while (hasNext()) {
            if (contact.compareTo(this.current.data)==0)
                return false;
            current=current.next;
        }
        return true;
    }

    }//class
