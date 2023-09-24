public class ContactLinkedListADT{
    Node<Contact> head;
    Node<Contact> current;
    public ContactLinkedListADT() {
        this.head = null;
        this.current = null;
    }

    public void add(Contact contactToInsert){//tested &done but names sorting is a prob
        if(isUniqueContact(contactToInsert)) {
            if(this.head == null) {
                head = new Node<Contact>(contactToInsert);
                current = head;
                sort(this);
                System.out.println(contactToInsert.toString()+"\n##has been added to the phonebook successfully ;)");
                return;
            }
            if (current.next==null){// current will be last element,and it's next is null (last in first out)
                current.next = new Node<Contact> (contactToInsert);
                current=current.next;
            } else if (hasNext()) {//current will be the new element ,and it will be in the middle of the list,this part will be reconsidered
               Node<Contact> temp = current.next;
               current.next = new Node<Contact> (contactToInsert);
               current = current.next;
               current.next = temp;
            }

            sort(this);//needs analyzing sort algo
            sort(this);
            sort(this);
            System.out.println(contactToInsert.toString()+"\n##has been added to the phonebook successfully ;)");
            return;
        }
        System.out.println(contactToInsert.toString()+"\n is already added to the phonebook :) ");
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

    public Contact SearchByName(PhoneBook list, String name ) {//done, need test
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

    public Contact SearchByPhoneNumber(PhoneBook list, String PhoneNumber ){//not done yet
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

    public void sort(ContactLinkedListADT list) {//not done yet
        Contact temp;
        if ( list.head.next == null){
            System.out.println("**only one element in list**");//for testing
            return;
        }else{
            this.current=this.head;
            while(list.hasNext()){
                if (list.current.data.compareTo(list.current.next.data) == 1){//shifting
                    temp=list.current.data;
                    list.current.data= list.current.next.data;
                    list.current.next.data=temp;
                }

                list.current = list.current.next;
            }

        }
    }
    public boolean isUniqueContact(Contact contact){//current position after method: current will be the last element+tested
        if (this.head==null){
            return true;
        }
        this.current=this.head;
        while (current != null) {//first element is checked

            if (contact.compareTo(this.current.data)==0){
                return false;
            }
            if(current.next==null)
                break;
            current=current.next;
        }
        return true;
    }
    public void printAll(){
        this.current=this.head;
        while (current != null) {//first element is checked
            System.out.println("++++++++\n"+current.data.toString()+"\n_________\n");

            if(current.next==null)
                break;
            current=current.next;
        }
    }

    public static void main(String[] args) {//testing area
        Contact c1 = new Contact("Ahmad Al -Saud", "05937636532", "jnjnjnj", "nnk222", "299","299");
        Contact c2 = new Contact(" Ahmad Alzaid", "7968867456", "njnjnj", "mmkmkm", "klll","299");
//        Contact c3 = new Contact("b2", "7968867456", "njnjnj", "mmkmkm", "klll","299");
//        Contact c4 = new Contact("b1", "7968867456", "njnjnj", "mmkmkm", "klll","299");
//        Contact c5 = new Contact("b6", "7968867456", "njnjnj", "mmkmkm", "klll","299");
//        Contact c6 = new Contact("b4", "7968867456", "njnjnj", "mmkmkm", "klll","299");
//        Contact c7 = new Contact("b3", "7968867456", "njnjnj", "mmkmkm", "klll","299");

        ContactLinkedListADT cll=new ContactLinkedListADT();
        cll.add(c1);//added successfully
        cll.add(c2);// exist not added /first element checked
      // uniqueness checks each letter it will accept b11 with b1
        cll.printAll();
    }

    }//class
